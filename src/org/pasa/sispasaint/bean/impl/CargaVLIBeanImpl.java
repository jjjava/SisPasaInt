package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.CargaVLIBean;
import org.pasa.sispasaint.model.Beneficiario;
import org.pasa.sispasaint.model.Endereco;
import org.pasa.sispasaint.model.Estado;
import org.pasa.sispasaint.model.Funcionario;
import org.pasa.sispasaint.model.Municipio;
import org.pasa.sispasaint.model.enun.TipoBeneficiario;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaVLIBeanImpl implements CargaVLIBean {

    public CargaVLIBeanImpl() {
    }

    @Override
    public void cargaArquivosTemp() {
        ImpBenVLITempBeanImpl impBenVLITempBeanImpl = new ImpBenVLITempBeanImpl();
        impBenVLITempBeanImpl.limparTbTemp();
        impBenVLITempBeanImpl.resetarIdentity();
        impBenVLITempBeanImpl.carregarArquivo();

        ImpEndVLITempBeanImpl impEndVLITempBeanImpl = new ImpEndVLITempBeanImpl();
        impEndVLITempBeanImpl.limparTbTemp();
        impEndVLITempBeanImpl.resetarIdentity();
        impEndVLITempBeanImpl.carregarArquivo();
    }

    @Override
    public void mapearEntidades() {
        Long t = new ImpBenVLITempBeanImpl().contar();
        for (Long k = 1L; k < t; k++) {
            ModeloBenVLI modeloBenVLI = new ImpBenVLITempBeanImpl().obter(k);
            ModeloEndVLI modeloEndVLI = new ImpEndVLITempBeanImpl().obterPorMatricula(modeloBenVLI);
            if (modeloBenVLI.getId() != null) {
                if (modeloBenVLI.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                    System.out.println(modeloBenVLI.getNomeBeneficiario());
                    Funcionario funcionario = new Funcionario();
                    funcionario.setCodEmpresa(modeloBenVLI.getEmpresa());
                    funcionario.setMatricula(modeloBenVLI.getMatricula());
                    funcionario.setVinculo(modeloBenVLI.getVinculo());
                    funcionario.setDireitoAbaterIR(StringUtil.parseBoolean(modeloBenVLI.getDireitoAbaterIR()));
                    funcionario.setDataAdmissao(DateUtil.toDate(modeloBenVLI.getDataAdmissao()));
                    funcionario.setFinanceira(modeloBenVLI.getFinanceira());
                    funcionario.setContratoTrabalho(modeloBenVLI.getContratoTrabalho());
                    funcionario.setEmpresaAtualizador(modeloBenVLI.getEmpresaAtualizador());
                    funcionario.setMatriculaAtulizador(modeloBenVLI.getMatriculaAtulizador());
                    funcionario.setCodigoDireitoPasa(modeloBenVLI.getCodigoDireitoPasa());
                    funcionario.setMatriculaPasa(modeloBenVLI.getMatriculaPasa());
                    funcionario.setEmpresaOrigem(modeloBenVLI.getEmpresaOrigem());
                    funcionario.setMatriculaOrigem(modeloBenVLI.getMatriculaOrigem());
                    funcionario.setEmpresaPeople(modeloBenVLI.getEmpresaPeople());
                    funcionario.setMatriculaPeople(modeloBenVLI.getMatriculaPeople());
                    funcionario.setUnidadeDeControle(modeloBenVLI.getUnidadeDeControle());
                    funcionario.setCentroDeCusto(modeloBenVLI.getCentroDeCusto());
                    funcionario.setBranco(modeloBenVLI.getBranco());
                    funcionario.setCodigoFilialVLI(modeloBenVLI.getCodigoFilialVLI());

                    Estado estado = new Estado();
                    estado.setUf(modeloEndVLI.getUf());

                    Municipio municipio = new Municipio();
                    municipio.setNome(modeloEndVLI.getCidade());
                    municipio.setEstado(estado);

                    Endereco endereco = new Endereco();
                    endereco.setLogradouro(modeloEndVLI.getEndereco());
                    endereco.setBairro(modeloEndVLI.getBairro());
                    endereco.setCep(modeloEndVLI.getCep());
                    endereco.setEstado(estado);

                    funcionario.setEndereco(endereco);
                    new FuncionarioBeanImpl().atualizar(funcionario);


                } else {
                    Funcionario funcionario = new FuncionarioBeanImpl().obter(modeloBenVLI.getEmpresa(), modeloBenVLI.getMatricula());
                    Beneficiario beneficiario = new Beneficiario();

                    Estado estado = new Estado();
                    estado.setUf(modeloEndVLI.getUf());

                    Municipio municipio = new Municipio();
                    municipio.setNome(modeloEndVLI.getCidade());
                    municipio.setEstado(estado);

                    Endereco endereco = new Endereco();
                    endereco.setLogradouro(modeloEndVLI.getEndereco());
                    endereco.setBairro(modeloEndVLI.getBairro());
                    endereco.setCep(modeloEndVLI.getCep());
                    endereco.setEstado(estado);
                    
                    beneficiario.setCodBeneficiario(modeloBenVLI.getCodBeneficiario());
                    beneficiario.setDireitoAMSCredenciamento(StringUtil.parseBoolean(modeloBenVLI.getDireitoAMSCredenciamento()));
                    beneficiario.setDataValidadeCredenciado(DateUtil.toDate(modeloBenVLI.getDataValidadeCredenciado()));
                    beneficiario.setDireitoAmsReembolso(StringUtil.parseBoolean(modeloBenVLI.getDireitoAmsReembolso()));
                    beneficiario.setDataValidadeReembolso(DateUtil.toDate(modeloBenVLI.getDataValidadeReembolso()));
                    beneficiario.setDataDeAtualizacao(DateUtil.toDate(modeloBenVLI.getDataDeAtualizacao()));
                    beneficiario.setCodigoCR(modeloBenVLI.getCodigoCR());
                    beneficiario.setOrgaoPessoal(modeloBenVLI.getOrgaoPessoal());
                    beneficiario.setFaixaNivel(modeloBenVLI.getFaixaNivel());
                    beneficiario.setNucleoDaAms(modeloBenVLI.getNucleoDaAms());
                    beneficiario.setTipoBeneficiario(TipoBeneficiario.Dependente);
                    beneficiario.setMatriculaParticipante(modeloBenVLI.getMatriculaParticipante());
                    beneficiario.setMatriculaRepresentanteLegal(modeloBenVLI.getMatriculaRepresentanteLegal());
                    beneficiario.setPlanoDeReciprocidadeCassi(StringUtil.parseBoolean(modeloBenVLI.getPlanoDeReciprocidadeCassi()));
                    beneficiario.setCodigoNacionalDeSaude(modeloBenVLI.getCodigoNacionalDeSaude());
                    beneficiario.setDeclaracaoNascidoVivo(modeloBenVLI.getDeclaracaoNascidoVivo());
                    beneficiario.setCassiData(modeloBenVLI.getCassiData());
                    
                    beneficiario.setEndereco(endereco);
                    
                    new BeneficiarioBeanImpl().cadastar(beneficiario);
                    

                }
            }
        }
    }
}
