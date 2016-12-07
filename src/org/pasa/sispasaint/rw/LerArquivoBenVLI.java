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
import org.pasa.sispasaint.map.CamposBenVLI;
import org.pasa.sispasaint.map.MapaCamposBenVLI;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class LerArquivoBenVLI {

     public List<ModeloBenVLI> lerArquivo(Long id){
         return lerArquivo(Configuracao.getInstance().getBenNomeArqComPath(id),
                Configuracao.getInstance().getNomeArqBen(id));
    }
    
    public List<ModeloBenVLI> lerArquivo(String path, String nomeArq){
        return lerArquivo(new File(path), nomeArq);
    }

    public List<ModeloBenVLI> lerArquivo(File file, String nomeArq) {
        List<ModeloBenVLI> listaBenVLI = new ArrayList<>();
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
                    listaBenVLI.add(parseCampos(line, nomeArq));// vrf se usar trim() o nao														// ñ
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
        return listaBenVLI;
    }

    private ModeloBenVLI parseCampos(String line, String nomeArq) {
        line = StringUtil.removeCharsEspeciais(line);
        System.out.println(line);

        ModeloBenVLI modelo = new ModeloBenVLI();
        Map<String, PosicaoCampo> mapa = new MapaCamposBenVLI().getMapa();
        PosicaoCampo campo;

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.EMPRESA);
        modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.MATRICULA);
        modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.COD_BENEFICIARIO);
        modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DIREITO_AMS_CREDENCIAMENTO);
        modelo.setDireitoAMSCredenciamento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DIREITO_AMS_REEMBOLSO);
        modelo.setDireitoAmsReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DATA_VALIDADE_CREDENCIADO);
        modelo.setDataValidadeCredenciado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DATA_VALIDADE_REEMBOLSO);
        modelo.setDataValidadeReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DATA_DE_ATUALIZACAO);
        modelo.setDataDeAtualizacao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.NOME_BENEFICIARIO_ABREVIADO);
        modelo.setNomeBeneficiarioAbreviado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CODIGO_CR);
        modelo.setCodigoCR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.ORGAO_PESSOAL);
        modelo.setOrgaoPessoal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.VINCULO);
        modelo.setVinculo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.PLANO);
        modelo.setPlano(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.FAIXA_NIVEL);
        modelo.setFaixaNivel(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DATA_NASCIMENTO);
        modelo.setDataNascimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DIREITO_ABATER_IR);
        modelo.setDireitoAbaterIR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.NUCLEO_DA_AMS);
        modelo.setNucleoDaAms(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.AGENCIA_BANCARIA);
        modelo.setAgenciaBancaria(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.BANCO);
        modelo.setBanco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CONTA_CORRENTE);
        modelo.setContaCorrente(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DATA_ADMISSAO);
        modelo.setDataAdmissao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.GRAU_PARENTESCO);
        modelo.setGrauParentesco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.FINACEIRA);
        modelo.setFinanceira(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CONTRATO_TRABALHO);
        modelo.setContratoTrabalho(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.SEXO);
        modelo.setSexo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.EMPRESA_ATUALIZADOR);
        modelo.setEmpresaAtualizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.MATRICULA_ATUALIZADOR);
        modelo.setMatriculaAtulizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.TIPO_BENEFICIARIO);
        modelo.setTipoBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CODIGO_DIREITO_PASA);
        modelo.setCodigoDireitoPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.GRAU_ESCOLARIDADE);
        modelo.setGrauEscolaridade(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.INDICAR_CONCLUSAO);
        modelo.setIndicadorConclusao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DATA_FALECIMENTO);
        modelo.setDataFalecimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.MATRICULA_PASA);
        modelo.setMatriculaPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.NOME_DA_MAE);
        modelo.setNomeDaMae(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.PIS);
        modelo.setPis(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CPF);
        modelo.setCpf(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.EMPRESA_ORIGEM);
        modelo.setEmpresaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.MATRICULA_ORIGEM);
        modelo.setMatriculaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.EMPRESA_PEOPLE);
        modelo.setEmpresaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.MATRICULA_PEOPLE);
        modelo.setMatriculaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.UNIDADE_DE_CONTROLE);
        modelo.setUnidadeDeControle(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CENTRO_DE_CUSTO);
        modelo.setCentroDeCusto(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.MATRICULA_PARTICIPANTE);
        modelo.setMatriculaParticipante(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.MATRICULA_REPRESENTANTE_LEGAL);
        modelo.setMatriculaRepresentanteLegal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.NOME_BENEFICIARIO);
        modelo.setNomeBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.PLANO_DE_RECIPROCIDADE_CASSI);
        modelo.setPlanoDeReciprocidadeCassi(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CODIGO_NACIONAL_DE_SAUDE);
        modelo.setCodigoNacionalDeSaude(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.DECLARACAO_NASCIDO_VIVO);
        modelo.setDeclaracaoNascidoVivo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CASSI_DATA);// fim direito
        // do plano
        modelo.setCassiData(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.BRANCO);
        modelo.setBranco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenVLI.CODIGO_FILIAL_VLI);
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
