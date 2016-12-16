package org.pasa.sispasaint.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.dao.impl.ModeloBenEndDAOImpl;
import org.pasa.sispasaint.map.CamposModelo;
import org.pasa.sispasaint.map.MapaCamposModeloBen;
import org.pasa.sispasaint.map.MapaCamposModeloEnd;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class LerArquivosBenEnd {

    private boolean read;
    private String benNomeArq, endNomeArq;
    private Log log;

    public LerArquivosBenEnd(Log log) {
        this.log = log;
        read = true;
    }

    public void ler(Long id) {
        ler(Configuracao.getInstance().getPathIn(id),
                Configuracao.getInstance().getNomeArqBen(id),
                Configuracao.getInstance().getNomeArqEnd(id));
    }

    public void ler(String path, String benNomeArq, String endNomeArq) {
        this.benNomeArq = benNomeArq;
        this.endNomeArq = endNomeArq;
        ler(new File(path + "/" + benNomeArq), new File(path + "/" + endNomeArq));
    }

    public void ler(File ben, File end) {
        log.setNomeArquivoBen(benNomeArq);
        log.setNomeArquivoEnd(endNomeArq);
        try {
            BufferedReader brBen = new BufferedReader(new FileReader(ben));
            BufferedReader brEnd = new BufferedReader(new FileReader(end));
            while (read) {
                String benLine = brBen.readLine();
                String endLine = brEnd.readLine();
                if (benLine == null || endLine == null) {
                    read = false;
                    break;
                }
                if (benLine.length() > 1) {
                    benLine = normalizaLinha(benLine);
                    endLine = normalizaLinha(endLine);
                    benLine = acerta400Pos(benLine);
                    endLine = acerta190Pos(endLine);
                    //DAO
                    new ModeloBenEndDAOImpl().cadastrar(parseCampos(benLine, endLine));
                    log.addLinhaArq();
                }
            }
            brBen.close();
            brEnd.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
            log.addLinhaArqErro();
        } catch (IOException e) {
            log.addLinhaArqErro();
        } finally {
        }
    }

    public ModeloBenEnd parseCampos(String benLine, String endLine) {
        benLine = StringUtil.removeCharsEspeciais(benLine);
        endLine = StringUtil.removeCharsEspeciais(endLine);
        
        ModeloBenEnd modelo = new ModeloBenEnd();
        Map<String, PosicaoCampo> mapaBen = new MapaCamposModeloBen().getMapa();
        Map<String, PosicaoCampo> mapaEnd = new MapaCamposModeloEnd().getMapa();
        PosicaoCampo campo;

        //BENEFICIARIO
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.EMPRESA);
        modelo.setEmpresa(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.MATRICULA);
        modelo.setMatricula(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.COD_BENEFICIARIO);
        modelo.setCodBeneficiario(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DIREITO_AMS_CREDENCIAMENTO);
        modelo.setDireitoAMSCredenciamento(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DIREITO_AMS_REEMBOLSO);
        modelo.setDireitoAmsReembolso(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DATA_VALIDADE_CREDENCIADO);
        modelo.setDataValidadeCredenciado(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DATA_VALIDADE_REEMBOLSO);
        modelo.setDataValidadeReembolso(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DATA_DE_ATUALIZACAO);
        modelo.setDataDeAtualizacao(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.NOME_BENEFICIARIO_ABREVIADO);
        modelo.setNomeBeneficiarioAbreviado(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CODIGO_CR);
        modelo.setCodigoCR(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.ORGAO_PESSOAL);
        modelo.setOrgaoPessoal(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.VINCULO);
        modelo.setVinculo(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.PLANO);
        modelo.setPlano(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.FAIXA_NIVEL);
        modelo.setFaixaNivel(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DATA_NASCIMENTO);
        modelo.setDataNascimento(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DIREITO_ABATER_IR);
        modelo.setDireitoAbaterIR(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.NUCLEO_DA_AMS);
        modelo.setNucleoDaAms(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.AGENCIA_BANCARIA);
        modelo.setAgenciaBancaria(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.BANCO);
        modelo.setBanco(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CONTA_CORRENTE);
        modelo.setContaCorrente(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DATA_ADMISSAO);
        modelo.setDataAdmissao(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.GRAU_PARENTESCO);
        modelo.setGrauParentesco(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.FINACEIRA);
        modelo.setFinanceira(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CONTRATO_TRABALHO);
        modelo.setContratoTrabalho(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.SEXO);
        modelo.setSexo(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.EMPRESA_ATUALIZADOR);
        modelo.setEmpresaAtualizador(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.MATRICULA_ATUALIZADOR);
        modelo.setMatriculaAtulizador(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.TIPO_BENEFICIARIO);
        modelo.setTipoBeneficiario(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CODIGO_DIREITO_PASA);
        modelo.setCodigoDireitoPasa(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.GRAU_ESCOLARIDADE);
        modelo.setGrauEscolaridade(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.INDICAR_CONCLUSAO);
        modelo.setIndicadorConclusao(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DATA_FALECIMENTO);
        modelo.setDataFalecimento(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.MATRICULA_PASA);
        modelo.setMatriculaPasa(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.NOME_DA_MAE);
        modelo.setNomeDaMae(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.PIS);
        modelo.setPis(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CPF);
        modelo.setCpf(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.EMPRESA_ORIGEM);
        modelo.setEmpresaOrigem(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.MATRICULA_ORIGEM);
        modelo.setMatriculaOrigem(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.EMPRESA_PEOPLE);
        modelo.setEmpresaPeople(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.MATRICULA_PEOPLE);
        modelo.setMatriculaPeople(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.UNIDADE_DE_CONTROLE);
        modelo.setUnidadeDeControle(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CENTRO_DE_CUSTO);
        modelo.setCentroDeCusto(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.MATRICULA_PARTICIPANTE);
        modelo.setMatriculaParticipante(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.MATRICULA_REPRESENTANTE_LEGAL);
        modelo.setMatriculaRepresentanteLegal(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.NOME_BENEFICIARIO);
        modelo.setNomeBeneficiario(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.PLANO_DE_RECIPROCIDADE_CASSI);
        modelo.setPlanoDeReciprocidadeCassi(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CODIGO_NACIONAL_DE_SAUDE);
        modelo.setCodigoNacionalDeSaude(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.DECLARACAO_NASCIDO_VIVO);
        modelo.setDeclaracaoNascidoVivo(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CASSI_DATA);// fim direito do plano
        modelo.setCassiData(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.BRANCO);
        modelo.setBranco(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaBen.get(CamposModelo.CODIGO_FILIAL_VLI);
        modelo.setCodigoFilialVLI(benLine.substring(campo.getInicioCampo(), campo.getFimCampo()));

        //ENDERECO
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.TELEFONE1);
        modelo.setTelefone1(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.TELEFONE2);
        modelo.setTelefone2(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.BRANCO);
        modelo.setBrancos(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.ENDERECO);
        modelo.setEndereco(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.BAIRRO);
        modelo.setBairro(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.CIDADE);
        modelo.setCidade(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.UF);
        modelo.setUf(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        campo = (PosicaoCampo) mapaEnd.get(CamposModelo.CEP);
        modelo.setCep(endLine.substring(campo.getInicioCampo(), campo.getFimCampo()));
        
        //NOME ARQUIVO
        modelo.setNomeArquivo(benNomeArq+ " | "+endNomeArq);

        return modelo;
    }

    private String acerta190Pos(String line) {
        while (line.length() < 190) {
            line = line + " ";
        }
        return line;
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
}
