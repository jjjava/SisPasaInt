package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.CargaVLIBean;
import org.pasa.sispasaint.model.Endereco;
import org.pasa.sispasaint.model.Estado;
import org.pasa.sispasaint.model.Funcionario;
import org.pasa.sispasaint.model.Municipio;
import static org.pasa.sispasaint.model.Pessoa_.endereco;
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
            System.out.println(modeloBenVLI.getNomeBeneficiario());
            ModeloEndVLI modeloEndVLI = new ImpEndVLITempBeanImpl().obterPorMatricula(modeloBenVLI);

            if (modeloBenVLI.getId() != null) {
                if (modeloBenVLI.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
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

                    new FuncionarioBeanImpl().atualizar(funcionario);
                }
            }
        }
    }
}
