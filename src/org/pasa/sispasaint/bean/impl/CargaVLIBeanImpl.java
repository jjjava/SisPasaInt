package org.pasa.sispasaint.bean.impl;

import org.pasa.sispasaint.bean.CargaVLIBean;
import org.pasa.sispasaint.model.Funcionario;
import org.pasa.sispasaint.model.intg.ModeloBenVLI;
import org.pasa.sispasaint.model.intg.ModeloEndVLI;
import org.pasa.sispasaint.util.DateUtil;
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
            System.out.println(k);
            ModeloBenVLI modeloBenVLI = new ImpBenVLITempBeanImpl().obter(k);
            System.out.println(modeloBenVLI.getNomeBeneficiario());
            ModeloEndVLI modeloEndVLI = new ImpEndVLITempBeanImpl().obterPorMatricula(modeloBenVLI);
            
            if (modeloBenVLI.getId() != null) {
               Funcionario funcionario = new Funcionario();
               
               funcionario.setCodEmpresa(modeloBenVLI.getEmpresa());
               funcionario.setMatricula(modeloBenVLI.getMatricula());
               funcionario.setVinculo(modeloBenVLI.getVinculo());
               funcionario.setDireitoAbaterIR(StringUtil.parseBoolean(modeloBenVLI.getDireitoAbaterIR()));
               funcionario.setDataAdmissao(DateUtil.toDate(modeloBenVLI.getDataAdmissao()));
               
               
               
               funcionario.setNome(modeloBenVLI.getNomeBeneficiario());
               funcionario.setNomeAbreviado(modeloBenVLI.getNomeBeneficiarioAbreviado());
              //funcionario.
            }
//

            //funcionarioBeanImpl.cadastar(funcionario)
        }

    }
}
