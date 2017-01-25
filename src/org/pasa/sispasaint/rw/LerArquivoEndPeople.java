package org.pasa.sispasaint.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.map.CamposEndVLI;
import org.pasa.sispasaint.map.MapaCamposEndVLI;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class LerArquivoEndPeople {

    private Long id;

    public LerArquivoEndPeople() {
    }

    public List<ModeloEndPeople> lerArquivo(Long id) {
        this.id = id;
        return lerArquivo(Configuracao.getInstance().getEndNomeArqComPath(id),
                Configuracao.getInstance().getNomeArqEnd(id));
    }

    public List<ModeloEndPeople> lerArquivo(String path, String nomeArq) {
        return lerArquivo(new File(path), nomeArq);
    }

    public List<ModeloEndPeople> lerArquivo(File file, String nomeArq) {
        List<ModeloEndPeople> listaEndVLI = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.length() > 1) {
                    line = normalizaLinha(line);
                    if (line.length() < 190) {
                        line = acerta190Pos(line);
                    }
                    listaEndVLI.add(parseCampos(line, nomeArq));// vrf se usar trim() ou  ñ
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                ZipArquivo zipArquivo = new ZipArquivo();
                zipArquivo.zip(nomeArq,
                        Configuracao.getInstance().getEndNomeArqComPath(id),
                        Configuracao.getInstance().getEndNomeProcComPath(id));
               // file.delete();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return listaEndVLI;
    }

    private ModeloEndPeople parseCampos(String line, String nomeArq) {
        line = StringUtil.removeCharsEspeciais(line);
        ModeloEndPeople modelo = new ModeloEndPeople();
        Map<String, PosicaoCampo> mapa = new MapaCamposEndVLI().getMapa();
        PosicaoCampo campo;
        try {
            campo = (PosicaoCampo) mapa.get(CamposEndVLI.EMPRESA);
            modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.MATRICULA);
            modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.COD_BENEFICIARIO);
            modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.TELEFONE1);
            modelo.setTelefone1(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.TELEFONE2);
            modelo.setTelefone2(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.BRANCO);
            modelo.setBrancos(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.ENDERECO);
            modelo.setEndereco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.BAIRRO);
            modelo.setBairro(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.CIDADE);
            modelo.setCidade(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.UF);
            modelo.setUf(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndVLI.CEP);
            modelo.setCep(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            modelo.setNomeArquivo(nomeArq);
        } catch (Exception e) {
            System.out.println(e);
        }
        return modelo;
    }

    private String acerta190Pos(String line) {
        while (line.length() < 190) {
            line = line + " ";
        }
        return line;
    }

    private String normalizaLinha(String line) {
        line = " " + line;
        return line;
    }
}
