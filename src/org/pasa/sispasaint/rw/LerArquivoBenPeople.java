package org.pasa.sispasaint.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public LerArquivoBenPeople(Log log) {
        this.log = log;
        modeloDAO = new ImpBenPeopleTempDAOImpl();
        mapa = new MapaCamposModeloBen().getMapa();
    }

    public void lerArquivo(Long id) {
        this.id = id;
        lerArquivo(Configuracao.getInstance().getBenNomeArqComPath(id),
                Configuracao.getInstance().getNomeArqBen(id));
    }

    public void lerArquivo(String path, String nomeArq) {
        this.benNomeArq = nomeArq;
        lerArquivo(new File(path), nomeArq);
    }

    public void lerArquivo(File file, String nomeArq) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.length() > 100) {
                    line = normalizaLinha(line);
                    if (line.length() < 400) {
                        line = acerta400Pos(line);
                    }
                    modeloDAO.cadastrar(parseCampos(line, nomeArq));// vrf se usar trim() o nao														// ñ
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
                zipArq(file, benNomeArq,
                    Configuracao.getInstance().getBenNomeArqComPath(id),
                    Configuracao.getInstance().getBenNomeProcComPath(id));
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private ModeloBenPeople parseCampos(String line, String nomeArq) {
        line = StringUtil.removeCharsEspeciais(line);
        ModeloBenPeople modelo = new ModeloBenPeople();

        //BENEFICIARIO - FUNCIONARIO
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA);
        modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA);
        modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.COD_BENEFICIARIO);
        modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DIREITO_AMS_CREDENCIAMENTO);
        modelo.setDireitoAMSCredenciamento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DIREITO_AMS_REEMBOLSO);
        modelo.setDireitoAmsReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_VALIDADE_CREDENCIADO);
        modelo.setDataValidadeCredenciado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_VALIDADE_REEMBOLSO);
        modelo.setDataValidadeReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_DE_ATUALIZACAO);
        modelo.setDataDeAtualizacao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.NOME_BENEFICIARIO_ABREVIADO);
        modelo.setNomeBeneficiarioAbreviado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_CR);
        modelo.setCodigoCR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.ORGAO_PESSOAL);
        modelo.setOrgaoPessoal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.VINCULO);
        modelo.setVinculo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.PLANO);
        modelo.setPlano(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.FAIXA_NIVEL);
        modelo.setFaixaNivel(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_NASCIMENTO);
        modelo.setDataNascimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DIREITO_ABATER_IR);
        modelo.setDireitoAbaterIR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.NUCLEO_DA_AMS);
        modelo.setNucleoDaAms(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.AGENCIA_BANCARIA);
        modelo.setAgenciaBancaria(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        //Normaliza codigo bancario.
        campo = (PosicaoCampo) mapa.get(CamposModelo.BANCO);
        modelo.setBanco(normalizaBanco(line.substring(campo.getInicioCampo(), campo.getFimCampo())));

        campo = (PosicaoCampo) mapa.get(CamposModelo.CONTA_CORRENTE);
        modelo.setContaCorrente(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_ADMISSAO);
        modelo.setDataAdmissao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.GRAU_PARENTESCO);
        modelo.setGrauParentesco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.FINACEIRA);
        modelo.setFinanceira(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CONTRATO_TRABALHO);
        modelo.setContratoTrabalho(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.SEXO);
        modelo.setSexo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA_ATUALIZADOR);
        modelo.setEmpresaAtualizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_ATUALIZADOR);
        modelo.setMatriculaAtulizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.TIPO_BENEFICIARIO);
        modelo.setTipoBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_DIREITO_PASA);
        modelo.setCodigoDireitoPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.GRAU_ESCOLARIDADE);
        modelo.setGrauEscolaridade(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.INDICAR_CONCLUSAO);
        modelo.setIndicadorConclusao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DATA_FALECIMENTO);
        modelo.setDataFalecimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_PASA);
        modelo.setMatriculaPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.NOME_DA_MAE);
        modelo.setNomeDaMae(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.PIS);
        modelo.setPis(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CPF);
        modelo.setCpf(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA_ORIGEM);
        modelo.setEmpresaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_ORIGEM);
        modelo.setMatriculaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.EMPRESA_PEOPLE);
        modelo.setEmpresaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_PEOPLE);
        modelo.setMatriculaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.UNIDADE_DE_CONTROLE);
        modelo.setUnidadeDeControle(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CENTRO_DE_CUSTO);
        modelo.setCentroDeCusto(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_PARTICIPANTE);
        modelo.setMatriculaParticipante(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.MATRICULA_REPRESENTANTE_LEGAL);
        modelo.setMatriculaRepresentanteLegal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.NOME_BENEFICIARIO);
        modelo.setNomeBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.PLANO_DE_RECIPROCIDADE_CASSI);
        modelo.setPlanoDeReciprocidadeCassi(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_NACIONAL_DE_SAUDE);
        modelo.setCodigoNacionalDeSaude(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.DECLARACAO_NASCIDO_VIVO);
        modelo.setDeclaracaoNascidoVivo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CASSI_DATA);// fim direito do plano
        modelo.setCassiData(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.BRANCO);
        modelo.setBranco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapa.get(CamposModelo.CODIGO_FILIAL_VLI);
        modelo.setCodigoFilialVLI(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        modelo.setNomeArquivo(nomeArq);
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

    private void zipArq(File file, String name, String pathOri, String pathDest) {
        new Thread(() -> {
            ZipArquivo zipArquivo = new ZipArquivo();
            zipArquivo.zip(name, pathOri, pathDest);
            //  file.delete();
        }).start();
    }
}
