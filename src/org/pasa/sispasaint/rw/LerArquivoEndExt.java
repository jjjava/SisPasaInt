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
import org.pasa.sispasaint.map.CamposEndExt;
import org.pasa.sispasaint.map.MapaCamposEndExt;
import org.pasa.sispasaint.model.intg.ModeloEndExt;

/**
 *
 * @author hudson
 */
public class LerArquivoEndExt {

    private Long id;
  
    public List<ModeloEndExt> lerArquivo(Long id) {
        this.id = id;
        return lerArquivo(Configuracao.getInstance().getEndNomeArqComPath(id),
                Configuracao.getInstance().getNomeArqEnd(id));
    }

    public List<ModeloEndExt> lerArquivo(String path, String nomeArq) {
        return lerArquivo(new File(path), nomeArq);
    }

    public List<ModeloEndExt> lerArquivo(File file, String nomeArq) {
        List<ModeloEndExt> listaEndExt = new ArrayList<>();
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
                    listaEndExt.add(parseCampos(line, nomeArq));// vrf se usar trim() ou  ñ
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
                file.delete();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return listaEndExt;
    }

    private ModeloEndExt parseCampos(String line, String nomeArq) {
        //System.out.println(line);
        ModeloEndExt modelo = new ModeloEndExt();
        Map<String, PosicaoCampo> mapa = new MapaCamposEndExt().getMapa();
        PosicaoCampo campo;

        try {

            campo = (PosicaoCampo) mapa.get(CamposEndExt.EMPRESA);
            modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.MATRICULA);
            modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.COD_BENEFICIARIO);
            modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.TELEFONE1);
            modelo.setTelefone1(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.TELEFONE2);
            modelo.setTelefone2(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.BRANCO);
            modelo.setBrancos(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.ENDERECO);
            modelo.setEndereco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.BAIRRO);
            modelo.setBairro(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.CIDADE);
            modelo.setCidade(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.UF);
            modelo.setUf(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

            campo = (PosicaoCampo) mapa.get(CamposEndExt.CEP);
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
