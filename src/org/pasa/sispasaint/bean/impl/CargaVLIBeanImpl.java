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
    }

    @Override
    public void cargaArquivosTemp() {
        System.out.println("benVLi");
        ImpBenVLITempBeanImpl impBenVLITempBeanImpl = new ImpBenVLITempBeanImpl();
        impBenVLITempBeanImpl.limparTbTemp();
        System.out.println("limpou tb");
        impBenVLITempBeanImpl.resetarIdentity();
        System.out.println("resetou tabela");
        impBenVLITempBeanImpl.carregarArquivo();
        System.out.println("ben-fim");

        ImpEndVLITempBeanImpl impEndVLITempBeanImpl = new ImpEndVLITempBeanImpl();
        impEndVLITempBeanImpl.limparTbTemp();
        impEndVLITempBeanImpl.resetarIdentity();
        impEndVLITempBeanImpl.carregarArquivo();
    }

    @Override
    public void mapearEntidades() {

        Long t = new ImpBenVLITempBeanImpl().contar();
        for (Long k = 1L; k < t; k++) {
            System.out.println(k);
            ModeloBenVLI modeloBenVLI = new ImpBenVLITempBeanImpl().obter(k);
            System.out.println(modeloBenVLI.getNomeBeneficiario());

//            
            ModeloEndVLI modeloEndVLI = new ImpEndVLITempBeanImpl().obterPorMatricula(modeloBenVLI);
            if (modeloBenVLI.getId() != null) {
                System.out.println("Cidade :" + modeloEndVLI.getCidade());
                System.out.println("emp :" + modeloEndVLI.getEmpresa());
                System.out.println("matri :" + modeloEndVLI.getMatricula());
                System.out.println("cod ben :" + modeloEndVLI.getCodBeneficiario());
            }
//

            //funcionarioBeanImpl.cadastar(funcionario)
        }

    }
}
