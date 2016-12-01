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

/**
 *
 * @author Hudson Schumaker
 */
public class LerArquivoEndPeople {

    public LerArquivoEndPeople() {
    }

    public List<ModeloEndPeople> lerArquivo() {
        return lerArquivo(Configuracao.getInstance().getPathComArquivoEndPeople());
    }

    public List<ModeloEndPeople> lerArquivo(String path) {
        return lerArquivo(new File(path));
    }

    public List<ModeloEndPeople> lerArquivo(File file) {
        List<ModeloEndPeople> listaEndPeople = new ArrayList<>();
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
                    listaEndPeople.add(parseCampos(line));// vrf se usar trim() ou  ñ
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listaEndPeople;
    }

    private ModeloEndPeople parseCampos(String line) {
        //System.out.println(line);
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
            
            modelo.setNomeArquivo(Configuracao.getInstance().getNomeEndPeople());
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
