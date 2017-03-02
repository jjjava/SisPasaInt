package org.pasa.sispasaint.rw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import org.pasa.sispasa.core.enumeration.EnumBanco;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.dao.impl.ImpBenPeopleTempDAOImpl;
import org.pasa.sispasaint.map.CamposModelo;
import org.pasa.sispasaint.map.MapaCamposModeloBen;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class LerArquivoBenPeople {

    private Log log;
    private Long id;
    private String benNomeArq;
    private PosicaoCampo campo;
    private final Map<String, PosicaoCampo> mapa;
    private final ImpBenPeopleTempDAOImpl modeloDAO;
    private int ini;
    private int fim;
    private int lote;
    private int loteLines;

    public LerArquivoBenPeople(Log log) {
        this.log = log;

        modeloDAO = new ImpBenPeopleTempDAOImpl();
        mapa = new MapaCamposModeloBen().getMapa();
    }

    public void lerArquivo(Long id, int ini, int fim, int lote, int loteLines) {
        this.id = id;
        this.ini = ini;
        this.fim = fim;
        this.lote = lote;
        this.loteLines = loteLines;

        lerArquivo(Configuracao.getInstance().getBenNomeArqComPath(id),
                Configuracao.getInstance().getNomeArqBen(id));
    }

    private void lerArquivo(String path, String nomeArq) {
        this.benNomeArq = nomeArq;
        lerArquivo(new File(path));
    }

    private void lerArquivo(File file) {
        String out = "";
        try {
            RandomAccessFile aFile = new RandomAccessFile(file, "r");
            FileChannel inChannel = aFile.getChannel();

            for (int i = 0; i < loteLines; i++) {
                MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, ini, 400);
                buffer.load();
                out = "";
                for (int j = 0; j < 400; j++) {
                    out = out + ((char) buffer.get());
                }
                System.out.println(out);
                ini = ini + 401;
                buffer.clear();
                modeloDAO.cadastrar(parseCampos(out, benNomeArq));
            }
            inChannel.close();
            aFile.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private ModeloBenPeople parseCampos(String line, String nomeArq) {
        //NORMALIZACOES DA LINHA
        line = acerta400Pos(line);
        line = StringUtil.removeCharsEspeciais(line);
        line = normalizaLinha(line);

        ModeloBenPeople modelo = new ModeloBenPeople();
        //BENEFICIARIO - FUNCIONARIO
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA);
        modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA);
        modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.COD_BENEFICIARIO);
        modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DIREITO_AMS_CREDENCIAMENTO);
        modelo.setDireitoAMSCredenciamento(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DIREITO_AMS_REEMBOLSO);
        modelo.setDireitoAmsReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_VALIDADE_CREDENCIADO);
        modelo.setDataValidadeCredenciado(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_VALIDADE_REEMBOLSO);
        modelo.setDataValidadeReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_DE_ATUALIZACAO);
        modelo.setDataDeAtualizacao(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.NOME_BENEFICIARIO_ABREVIADO);
        modelo.setNomeBeneficiarioAbreviado(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_CR);
        modelo.setCodigoCR(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.ORGAO_PESSOAL);
        modelo.setOrgaoPessoal(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.VINCULO);
        modelo.setVinculo(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        
        campo = (PosicaoCampo) mapa.get(CamposModelo.PLANO);//Acerto Plano
        modelo.setPlano(acertaPlano(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim()));
        
        campo = (PosicaoCampo) mapa.get(CamposModelo.FAIXA_NIVEL);
        modelo.setFaixaNivel(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_NASCIMENTO);
        modelo.setDataNascimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DIREITO_ABATER_IR);
        modelo.setDireitoAbaterIR(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.NUCLEO_DA_AMS);
        modelo.setNucleoDaAms(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.AGENCIA_BANCARIA);
        modelo.setAgenciaBancaria(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

        //Normaliza codigo bancario.
        campo = (PosicaoCampo) mapa.get(CamposModelo.BANCO);
        modelo.setBanco(normalizaBanco(line.substring(campo.getInicioCampo(), campo.getFimCampo())));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CONTA_CORRENTE);
        modelo.setContaCorrente(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_ADMISSAO);
        modelo.setDataAdmissao(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.GRAU_PARENTESCO);
        modelo.setGrauParentesco(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.FINACEIRA);
        modelo.setFinanceira(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CONTRATO_TRABALHO);
        modelo.setContratoTrabalho(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.SEXO);
        modelo.setSexo(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA_ATUALIZADOR);
        modelo.setEmpresaAtualizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_ATUALIZADOR);
        modelo.setMatriculaAtulizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.TIPO_BENEFICIARIO);
        modelo.setTipoBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_DIREITO_PASA);
        modelo.setCodigoDireitoPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.GRAU_ESCOLARIDADE);
        modelo.setGrauEscolaridade(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.INDICAR_CONCLUSAO);
        modelo.setIndicadorConclusao(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_FALECIMENTO);
        modelo.setDataFalecimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_PASA);
        modelo.setMatriculaPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.NOME_DA_MAE);
        modelo.setNomeDaMae(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.PIS);
        modelo.setPis(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CPF);
        modelo.setCpf(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA_ORIGEM);
        modelo.setEmpresaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_ORIGEM);
        modelo.setMatriculaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA_PEOPLE);
        modelo.setEmpresaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_PEOPLE);
        modelo.setMatriculaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.UNIDADE_DE_CONTROLE);
        modelo.setUnidadeDeControle(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CENTRO_DE_CUSTO);
        modelo.setCentroDeCusto(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_PARTICIPANTE);
        modelo.setMatriculaParticipante(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_REPRESENTANTE_LEGAL);
        modelo.setMatriculaRepresentanteLegal(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.NOME_BENEFICIARIO);
        modelo.setNomeBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.PLANO_DE_RECIPROCIDADE_CASSI);
        modelo.setPlanoDeReciprocidadeCassi(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_NACIONAL_DE_SAUDE);
        modelo.setCodigoNacionalDeSaude(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.DECLARACAO_NASCIDO_VIVO);
        modelo.setDeclaracaoNascidoVivo(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CASSI_DATA);// fim direito do plano
        modelo.setCassiData(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.BRANCO);
        modelo.setBranco(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_FILIAL_VLI);
        modelo.setCodigoFilialVLI(line.substring(campo.getInicioCampo(), campo.getFimCampo()).trim());

        modelo.setNomeArquivo(nomeArq);
        //  System.err.println(line);
        return modelo;
    }

    private String acerta400Pos(String line) {
        while (line.length() < 400) {
            line = line + " ";
        }
        return line;
    }

    private String normalizaLinha(String line) {
        line = " " + line;
        return line;
    }

    private String normalizaBanco(String s) {
        s = s.replaceFirst("^0+(?!$)", "");
        s = s.trim();//A pediddo do Allan
        s = s.toUpperCase();
        if (EnumBanco.existe(s)) {
            return s;
        } else {
            return "";
        }
    }
    
    private String acertaPlano(String plano){
        if(plano.equals(" ")){
            return "0";
        }
        return plano;
    }

    private void zipArq(File file, String name, String pathOri, String pathDest) {
        new Thread(() -> {
            ZipArquivo zipArquivo = new ZipArquivo();
            zipArquivo.zip(name, pathOri, pathDest);
            //  file.delete();
        }).start();
    }
}
