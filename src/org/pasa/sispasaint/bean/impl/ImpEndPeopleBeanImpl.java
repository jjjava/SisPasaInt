package org.pasa.sispasaint.bean.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.dao.impl.ImpEndPeopleDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.carga.thread.CargaEndPeopleThread;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.util.ArquivoUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.Sistema;
import org.pasa.sispasaint.bean.ImpEndPeopleBean;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpEndPeopleBeanImpl implements ImpEndPeopleBean {

    private final ImpEndPeopleDAOImpl modeloDAO;

    public ImpEndPeopleBeanImpl() {
        modeloDAO = new ImpEndPeopleDAOImpl();
    }

    @Override
    public ModeloEndPeople obter(ModeloEndPeople modeloEndPeople) {
        return modeloDAO.obter(modeloEndPeople.getId());
    }

    @Override
    public ModeloEndPeople obterPorMatricula(ModeloBenPeople modeloBenVli) {
        return modeloDAO.obterPorMatricula(modeloBenVli.getEmpresa(), modeloBenVli.getMatricula(), modeloBenVli.getCodBeneficiario());
    }

    @Override
    public void limparTbTemp() {
        modeloDAO.limpaTB();
    }

    @Override
    public void resetarIdentity() {
        modeloDAO.resetarIdentity();
    }

    @Override
    public void carregarArquivo(Long id, Log log) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(Sistema.getNumberProcessors());
            int lote = ArquivoUtil.getNumeroLinhasLote(ArquivoUtil.getNumerosLinhaArquivo(Configuracao.getInstance().getBenNomeArqComPath(id)));
            int loteLines = lote;
            lote = lote * SisPasaIntCommon.LINE_TAM_4;
            int ini = 0;
            int fim = lote;
            for (int i = 0; i < Sistema.getNumberProcessors(); i++) {
                executor.execute(new CargaEndPeopleThread(log, id, ini, fim, lote, loteLines));
                ini = fim;
                fim = fim + lote;
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
        } catch (IOException ex) {
            System.err.println(ex);
            Logger.getLogger(ImpEndPeopleBeanImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        }
    }

    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI) {
        modeloDAO.salvarTbTemp(listaModeloEndVLI);
    }

    @Override
    public Long contar() {
        return modeloDAO.contar();
    }

    @Override
    public List<ModeloEndPeople> list(String empresa, String matricula) {
        return modeloDAO.list(empresa, matricula);
    }

    @Override
    public void copiarTabela() {
        modeloDAO.copiarTabela();
    }
}
