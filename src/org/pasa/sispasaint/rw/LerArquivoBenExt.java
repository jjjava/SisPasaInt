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
import org.pasa.sispasaint.map.CamposBenExt;
import org.pasa.sispasaint.map.MapaCamposBenExt;
import org.pasa.sispasaint.model.intg.ModeloBenExt;

/**
 *
 * @author hudson schumaker
 */
public class LerArquivoBenExt {
    
    private Long id;
    
    public List<ModeloBenExt> lerArquivo(Long id){
        this.id = id;
        return lerArquivo(Configuracao.getInstance().getBenNomeArqComPath(id),
                Configuracao.getInstance().getNomeArqBen(id));
    }
    
    public List<ModeloBenExt> lerArquivo(String path, String nomeArq){
        return lerArquivo(new File(path), nomeArq);
    }
    
    public List<ModeloBenExt> lerArquivo(File file, String nomeArq) {
        List<ModeloBenExt> listaBenExt = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.length() > 1) {
                    line = normalizaLinha(line);
                    if (line.length() < 400) {
                        line = acerta400Pos(line);
                    }
                    listaBenExt.add(parseCampos(line,nomeArq));// vrf se usar trim() o nao														// ñ
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
                        Configuracao.getInstance().getBenNomeArqComPath(id),
                        nomeArq);
                
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return listaBenExt;
    }

    private ModeloBenExt parseCampos(String line, String nomeArq) {
        System.out.println(line);

        ModeloBenExt modelo = new ModeloBenExt();
        Map<String, PosicaoCampo> mapa = new MapaCamposBenExt().getMapa();
        PosicaoCampo campo;

        campo = (PosicaoCampo) mapa.get(CamposBenExt.EMPRESA);
        modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.MATRICULA);
        modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.COD_BENEFICIARIO);
        modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DIREITO_AMS_CREDENCIAMENTO);
        modelo.setDireitoAMSCredenciamento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DIREITO_AMS_REEMBOLSO);
        modelo.setDireitoAmsReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DATA_VALIDADE_CREDENCIADO);
        modelo.setDataValidadeCredenciado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DATA_VALIDADE_REEMBOLSO);
        modelo.setDataValidadeReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DATA_DE_ATUALIZACAO);
        modelo.setDataDeAtualizacao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.NOME_BENEFICIARIO_ABREVIADO);
        modelo.setNomeBeneficiarioAbreviado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CODIGO_CR);
        modelo.setCodigoCR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.ORGAO_PESSOAL);
        modelo.setOrgaoPessoal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.VINCULO);
        modelo.setVinculo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.PLANO);
        modelo.setPlano(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.FAIXA_NIVEL);
        modelo.setFaixaNivel(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DATA_NASCIMENTO);
        modelo.setDataNascimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DIREITO_ABATER_IR);
        modelo.setDireitoAbaterIR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.NUCLEO_DA_AMS);
        modelo.setNucleoDaAms(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.AGENCIA_BANCARIA);
        modelo.setAgenciaBancaria(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.BANCO);
        modelo.setBanco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CONTA_CORRENTE);
        modelo.setContaCorrente(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DATA_ADMISSAO);
        modelo.setDataAdmissao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.GRAU_PARENTESCO);
        modelo.setGrauParentesco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.FINACEIRA);
        modelo.setFinanceira(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CONTRATO_TRABALHO);
        modelo.setContratoTrabalho(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.SEXO);
        modelo.setSexo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.EMPRESA_ATUALIZADOR);
        modelo.setEmpresaAtualizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.MATRICULA_ATUALIZADOR);
        modelo.setMatriculaAtulizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.TIPO_BENEFICIARIO);
        modelo.setTipoBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CODIGO_DIREITO_PASA);
        modelo.setCodigoDireitoPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.GRAU_ESCOLARIDADE);
        modelo.setGrauEscolaridade(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.INDICAR_CONCLUSAO);
        modelo.setIndicadorConclusao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DATA_FALECIMENTO);
        modelo.setDataFalecimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.MATRICULA_PASA);
        modelo.setMatriculaPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.NOME_DA_MAE);
        modelo.setNomeDaMae(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.PIS);
        modelo.setPis(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CPF);
        modelo.setCpf(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.EMPRESA_ORIGEM);
        modelo.setEmpresaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.MATRICULA_ORIGEM);
        modelo.setMatriculaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.EMPRESA_PEOPLE);
        modelo.setEmpresaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.MATRICULA_PEOPLE);
        modelo.setMatriculaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.UNIDADE_DE_CONTROLE);
        modelo.setUnidadeDeControle(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CENTRO_DE_CUSTO);
        modelo.setCentroDeCusto(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.MATRICULA_PARTICIPANTE);
        modelo.setMatriculaParticipante(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.MATRICULA_REPRESENTANTE_LEGAL);
        modelo.setMatriculaRepresentanteLegal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.NOME_BENEFICIARIO);
        modelo.setNomeBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.PLANO_DE_RECIPROCIDADE_CASSI);
        modelo.setPlanoDeReciprocidadeCassi(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CODIGO_NACIONAL_DE_SAUDE);
        modelo.setCodigoNacionalDeSaude(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.DECLARACAO_NASCIDO_VIVO);
        modelo.setDeclaracaoNascidoVivo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CASSI_DATA);// fim direito do plano
        modelo.setCassiData(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.BRANCO);
        modelo.setBranco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenExt.CODIGO_FILIAL_VLI);
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
}
