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
import org.pasa.sispasaint.map.CamposBenPeople;
import org.pasa.sispasaint.map.MapaCamposBenPeople;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;

/**
 *
 * @author Hudson Schumaker
 */
public class LerArquivoBenPeople {

    public LerArquivoBenPeople() {
    }

    public List<ModeloBenPeople> lerArquivo() {
        return lerArquivo(Configuracao.getInstance().getPathComArquivoBenPeople());
    }

    public List<ModeloBenPeople> lerArquivo(String path) {
        return lerArquivo(new File(path));
    }

    public List<ModeloBenPeople> lerArquivo(File file) {
        List<ModeloBenPeople> listaBenPeolpe = new ArrayList<>();
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
                    listaBenPeolpe.add(parseCampos(line));// vrf se usar trim() o nao														// ñ
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
        return listaBenPeolpe;
    }

    private ModeloBenPeople parseCampos(String line) {

        System.out.println(line);

        ModeloBenPeople modelo = new ModeloBenPeople();
        Map<String, PosicaoCampo> mapa = new MapaCamposBenPeople().getMapa();
        PosicaoCampo campo;

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.EMPRESA);
        modelo.setEmpresa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.MATRICULA);
        modelo.setMatricula(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.COD_BENEFICIARIO);
        modelo.setCodBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DIREITO_AMS_CREDENCIAMENTO);
        modelo.setDireitoAMSCredenciamento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DIREITO_AMS_REEMBOLSO);
        modelo.setDireitoAmsReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DATA_VALIDADE_CREDENCIADO);
        modelo.setDataValidadeCredenciado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DATA_VALIDADE_REEMBOLSO);
        modelo.setDataValidadeReembolso(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DATA_DE_ATUALIZACAO);
        modelo.setDataDeAtualizacao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.NOME_BENEFICIARIO_ABREVIADO);
        modelo.setNomeBeneficiarioAbreviado(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CODIGO_CR);
        modelo.setCodigoCR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.ORGAO_PESSOAL);
        modelo.setOrgaoPessoal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.VINCULO);
        modelo.setVinculo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.PLANO);
        modelo.setPlano(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.FAIXA_NIVEL);
        modelo.setFaixaNivel(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DATA_NASCIMENTO);
        modelo.setDataNascimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DIREITO_ABATER_IR);
        modelo.setDireitoAbaterIR(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.NUCLEO_DA_AMS);
        modelo.setNucleoDaAms(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.AGENCIA_BANCARIA);
        modelo.setAgenciaBancaria(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.BANCO);
        modelo.setBanco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CONTA_CORRENTE);
        modelo.setContaCorrente(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DATA_ADMISSAO);
        modelo.setDataAdmissao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.GRAU_PARENTESCO);
        modelo.setGrauParentesco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.FINACEIRA);
        modelo.setFinanceira(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CONTRATO_TRABALHO);
        modelo.setContratoTrabalho(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.SEXO);
        modelo.setSexo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.EMPRESA_ATUALIZADOR);
        modelo.setEmpresaAtualizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.MATRICULA_ATUALIZADOR);
        modelo.setMatriculaAtulizador(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.TIPO_BENEFICIARIO);
        modelo.setTipoBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CODIGO_DIREITO_PASA);
        modelo.setCodigoDireitoPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.GRAU_ESCOLARIDADE);
        modelo.setGrauEscolaridade(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.INDICAR_CONCLUSAO);
        modelo.setIndicadorConclusao(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DATA_FALECIMENTO);
        modelo.setDataFalecimento(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.MATRICULA_PASA);
        modelo.setMatriculaPasa(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.NOME_DA_MAE);
        modelo.setNomeDaMae(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.PIS);
        modelo.setPis(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CPF);
        modelo.setCpf(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.EMPRESA_ORIGEM);
        modelo.setEmpresaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.MATRICULA_ORIGEM);
        modelo.setMatriculaOrigem(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.EMPRESA_PEOPLE);
        modelo.setEmpresaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.MATRICULA_PEOPLE);
        modelo.setMatriculaPeople(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.UNIDADE_DE_CONTROLE);
        modelo.setUnidadeDeControle(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CENTRO_DE_CUSTO);
        modelo.setCentroDeCusto(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.MATRICULA_PARTICIPANTE);
        modelo.setMatriculaParticipante(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.MATRICULA_REPRESENTANTE_LEGAL);
        modelo.setMatriculaRepresentanteLegal(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.NOME_BENEFICIARIO);
        modelo.setNomeBeneficiario(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.PLANO_DE_RECIPROCIDADE_CASSI);
        modelo.setPlanoDeReciprocidadeCassi(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CODIGO_NACIONAL_DE_SAUDE);
        modelo.setCodigoNacionalDeSaude(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.DECLARACAO_NASCIDO_VIVO);
        modelo.setDeclaracaoNascidoVivo(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CASSI_DATA);// fim direito
        // do plano
        modelo.setCassiData(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.BRANCO);
        modelo.setBranco(line.substring(campo.getInicioCampo(), campo.getFimCampo()));

        campo = (PosicaoCampo) mapa.get(CamposBenPeople.CODIGO_FILIAL_VLI);
        modelo.setCodigoFilialVLI(line.substring(campo.getInicioCampo(), campo.getFimCampo()));
        
        modelo.setNomeArquivo(Configuracao.getInstance().getNomeBenPeople());

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
