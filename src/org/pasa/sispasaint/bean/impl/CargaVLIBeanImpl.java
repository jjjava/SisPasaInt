package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.CargaVLIBean;
import org.pasa.sispasaint.model.Endereco;
import org.pasa.sispasaint.model.Funcionario;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;

/**
 *
 * @author Hudson Schumaker
 */
public class CargaVLIBeanImpl implements CargaVLIBean {

    public CargaVLIBeanImpl() {
        System.out.println("carga");
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
        ImpBenVLITempBeanImpl impBenVLITempBeanImpl = new ImpBenVLITempBeanImpl();
        ImpEndVLITempBeanImpl impEndVLITempBeanImpl = new ImpEndVLITempBeanImpl();

        FuncionarioBeanImpl funcionarioBeanImpl = new FuncionarioBeanImpl();

        Long t = impBenVLITempBeanImpl.contar();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@"+t);

        for (Long k = 1L; k < t; k++) {
            ModeloBenVLI modeloBenVLI = impBenVLITempBeanImpl.obter(k);
//            System.out.println(modeloBenVLI.getNomeBeneficiario());
//            System.out.println(modeloBenVLI.getChaveMatricula());
//            

            ModeloEndVLI modeloEndVLI = impEndVLITempBeanImpl.obterPorMatricula(modeloBenVLI);
//
//            System.out.println("Cidade :"+modeloEndVLI.getCidade());
//            System.out.println("emp :"+modeloEndVLI.getEmpresa());
//            System.out.println("matri :"+modeloEndVLI.getMatricula());
//            System.out.println("cod ben :"+modeloEndVLI.getCodBeneficiario());

            Funcionario funcionario = new Funcionario();
            funcionario.setNome(modeloBenVLI.getNomeBeneficiario());
            funcionario.setMatricula(modeloBenVLI.getMatricula());

            Endereco endereco = new Endereco();
            endereco.setBairro(modeloEndVLI.getBairro());

            //funcionarioBeanImpl.cadastar(funcionario)
        }

    }
}
