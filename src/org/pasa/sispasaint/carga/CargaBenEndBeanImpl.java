package org.pasa.sispasaint.carga;

import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.bean.impl.BeneficiarioBeanImpl;
import org.pasa.sispasaint.bean.impl.FuncionarioBeanImpl;
import org.pasa.sispasaint.bean.impl.ModeloBenEndBeanImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;
import org.pasa.sispasaint.util.SisPasaIntCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaBenEndBeanImpl implements CargaBenEndBean, Runnable {

    private final Long idEmpresa;
    private Log log;
    private CargaEntidadeFuncionario cargaEntidadeFuncionario;

    public CargaBenEndBeanImpl(Long idEmpresa, Log log) {
        this.idEmpresa = idEmpresa;
        this.log = log;
        this.cargaEntidadeFuncionario = new CargaEntidadeFuncionario();
    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }

    @Override
    public void inicar() {
      //  this.cargaArquivosTemp();
        this.mapearEntidades();
        this.setQtdInativos();
    }

    @Override
    public void cargaArquivosTemp() {
        ModeloBenEndBeanImpl modeloBenEndBeanImpl = new ModeloBenEndBeanImpl();
        modeloBenEndBeanImpl.limparTbTemp();
        modeloBenEndBeanImpl.resetarIdentity();
        modeloBenEndBeanImpl.carregarArquivo(idEmpresa, log);
    }

    @Override
    public void mapearEntidades() {
        FuncionarioBeanImpl funcionarioBeanImpl = new FuncionarioBeanImpl();
        ModeloBenEndBeanImpl modeloBean = new ModeloBenEndBeanImpl();
        Long qtdRegistros = modeloBean.contar();
        Funcionario funcionario = null;
        try {
            for (Long k = 1L; k < qtdRegistros; k++) {
                System.out.println(k);
                ModeloBenEnd modeloBenEnd = modeloBean.obter(k);
                if (modeloBenEnd.getTipoBeneficiario().equalsIgnoreCase(SisPasaIntCommon.FUNCIONARIO)) {
                    funcionario = funcionarioBeanImpl.obter(modeloBenEnd.getEmpresa(), modeloBenEnd.getMatricula());
                    if (funcionario == null) {
                        if (cargaEntidadeFuncionario.newFuncionario(modeloBenEnd)) {
                            log.addAssocIncluidos();
                        } else {
                            log.addErrosAssoc();
                            log.addMatriculaErro(modeloBenEnd.getEmpresa() + modeloBenEnd.getMatricula());
                        }
                    } else {

                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setStatusEntidades() {
        new FuncionarioBeanImpl().atualizaStatus(idEmpresa);
        new BeneficiarioBeanImpl().atulizaStatus("" + idEmpresa);
    }

    private void setQtdInativos() {
        log.setQtdAssocInativo(new BeneficiarioBeanImpl().getInativos("" + idEmpresa).intValue());
    }

    @Override
    public void run() {
        inicar();
    }
}
