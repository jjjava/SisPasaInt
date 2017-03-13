package org.pasa.sispasaint.rw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.dao.impl.ImpEndPeopleDAOImpl;
import org.pasa.sispasaint.map.CamposModelo;
import org.pasa.sispasaint.map.MapaCamposModeloEnd;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class LerArquivoEndPeople {

    private final Log log;
    private String cdVale;
    private String endNomeArq;
    private PosicaoCampo campo;
    private final Map<String, PosicaoCampo> mapa;
    private final ImpEndPeopleDAOImpl modeloDAO;
    private int ini;
    private int fim;
    private int lote;
    private int loteLines;

    public LerArquivoEndPeople(Log log) {
        this.log = log;
        this.mapa = new MapaCamposModeloEnd().getMapa();
        this.modeloDAO = new ImpEndPeopleDAOImpl();
    }

    public void lerArquivo(String cdVale, int ini, int fim, int lote, int loteLines) {
        this.cdVale = cdVale;
        this.ini = ini;
        this.fim = fim;
        this.lote = lote;
        this.loteLines = loteLines;
        lerArquivo(Configuracao.getInstance().getEndNomeArqComPath(cdVale),
                Configuracao.getInstance().getNomeArqEnd(cdVale));
    }

    public void lerArquivo(String path, String nomeArq) {
        this.endNomeArq = nomeArq;
        log.setNomeArquivoEnd(endNomeArq);
        lerArquivo(new File(path));
    }

    public void lerArquivo(File file) {
        String out = "";
        try {
            RandomAccessFile aFile = new RandomAccessFile(file, "r");
            FileChannel inChannel = aFile.getChannel();
            for (int i = 0; i < loteLines; i++) {
                MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, ini, SisPasaIntCommon.LINE_TAM_3);
                buffer.load();
                out = "";
                for (int j = 0; j < SisPasaIntCommon.LINE_TAM_3; j++) {
                    out = out + ((char) buffer.get());
                }
                ini = ini + SisPasaIntCommon.LINE_TAM_4;
                buffer.clear();
                modeloDAO.cadastrar(parseCampos(out, endNomeArq));
                log.addLinhaArq();
            }
            inChannel.close();
            aFile.close();
        } catch (FileNotFoundException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(LerArquivoEndPeople.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            log.addLinhaArqErro();
        } catch (IOException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(LerArquivoEndPeople.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            log.addLinhaArqErro();
        } finally {
            zipArq(file, file.getName() + "_PROC_" + DateUtil.dataParaArquivo(),
                    Configuracao.getInstance().getEndNomeArqComPath(cdVale),
                    Configuracao.getInstance().getEndNomeProcComPath(cdVale));
        }
    }

    private ModeloEndPeople parseCampos(String line, String nomeArq) {
        //NORMALIZACOES DA LINHA
        line = acerta190Pos(line);
        line = StringUtil.removeCharsEspeciais(line);
        line = normalizaLinha(line);
        ModeloEndPeople modelo = new ModeloEndPeople();
        try {
            //ENDERECO - TELEFONES
            campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA);
            modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA);
            modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.COD_BENEFICIARIO);
            modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.TELEFONE1);
            modelo.setTelefone1(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.TELEFONE2);
            modelo.setTelefone2(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.BRANCO);
            modelo.setBrancos(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.ENDERECO);
            modelo.setEndereco(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.BAIRRO);
            modelo.setBairro(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.CIDADE);
            modelo.setCidade(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.UF);
            modelo.setUf(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
            campo = (PosicaoCampo) mapa.get(CamposModelo.CEP);
            modelo.setCep(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

            modelo.setNomeArquivo(nomeArq);
        } catch (Exception ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(LerArquivoEndPeople.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            log.addLinhaArqErro();
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
            file.delete();
        }).start();
    }
}
