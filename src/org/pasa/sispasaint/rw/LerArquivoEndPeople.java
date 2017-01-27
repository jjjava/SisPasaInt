package org.pasa.sispasaint.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.dao.impl.ImpEndPeopleTempDAOImpl;
import org.pasa.sispasaint.map.CamposModelo;
import org.pasa.sispasaint.map.MapaCamposModeloEnd;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class LerArquivoEndPeople {

    private Log log;
    private Long id;
    private String endNomeArq;
    private PosicaoCampo campo;
    private final Map<String, PosicaoCampo> mapa;
    private final ImpEndPeopleTempDAOImpl modeloDAO;

    public LerArquivoEndPeople(Log log) {
        this.log = log;
        mapa = new MapaCamposModeloEnd().getMapa();
        modeloDAO = new ImpEndPeopleTempDAOImpl();
    }

    public void lerArquivo(Long id) {
        this.id = id;
        lerArquivo(Configuracao.getInstance().getEndNomeArqComPath(id),
                Configuracao.getInstance().getNomeArqEnd(id));
    }

    public void lerArquivo(String path, String nomeArq) {
        this.endNomeArq = nomeArq;
        lerArquivo(new File(path), nomeArq);
    }

    public void lerArquivo(File file, String nomeArq) {
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
                    modeloDAO.cadastrar(parseCampos(line, nomeArq));// vrf se usar trim() ou  ñ
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
                zipArq(file, endNomeArq,
                        Configuracao.getInstance().getBenNomeArqComPath(id),
                        Configuracao.getInstance().getBenNomeProcComPath(id));
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private ModeloEndPeople parseCampos(String line, String nomeArq) {
        line = StringUtil.removeCharsEspeciais(line);
        ModeloEndPeople modelo = new ModeloEndPeople();
        try {
            //ENDEREÇO
            campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA);
            modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA);
            modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.COD_BENEFICIARIO);
            modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.TELEFONE1);
            modelo.setTelefone1(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.TELEFONE2);
            modelo.setTelefone2(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.BRANCO);
            modelo.setBrancos(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.ENDERECO);
            modelo.setEndereco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.BAIRRO);
            modelo.setBairro(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.CIDADE);
            modelo.setCidade(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.UF);
            modelo.setUf(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
            campo = (PosicaoCampo) mapa.get(CamposModelo.CEP);
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

    private void zipArq(File file, String name, String pathOri, String pathDest) {
        new Thread(() -> {
            ZipArquivo zipArquivo = new ZipArquivo();
            zipArquivo.zip(name, pathOri, pathDest);
            //  file.delete();
        }).start();
    }
}
