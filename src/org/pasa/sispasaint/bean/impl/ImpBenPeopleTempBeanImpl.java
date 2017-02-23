package org.pasa.sispasaint.bean.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.pasa.sispasaint.dao.impl.ImpBenPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.bean.ImpBenPeopleTempBean;
import org.pasa.sispasaint.carga.thread.CargaBenPeopleThread;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.util.ArquivoUtil;
import org.pasa.sispasaint.util.Sistema;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpBenPeopleTempBeanImpl implements ImpBenPeopleTempBean {

    private final ImpBenPeopleTempDAOImpl modeloDAO;

    public ImpBenPeopleTempBeanImpl() {
        modeloDAO = new ImpBenPeopleTempDAOImpl();
    }

    @Override
    public ModeloBenPeople obter(Long id) {
        ModeloBenPeople modeloBenPeople = new ModeloBenPeople();
        modeloBenPeople.setId(id);
        return obter(modeloBenPeople);
    }

    @Override
    public ModeloBenPeople obter(ModeloBenPeople modelo) {
        return modeloDAO.obter(modelo.getId());
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
            lote = lote * 401;
            int ini = 0;
            int fim = lote;

            for (int i = 0; i < Sistema.getNumberProcessors() ; i++) {
                executor.execute(new CargaBenPeopleThread(id, ini, fim, lote, loteLines));
                ini = fim ;
                fim = fim + lote;
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("Acabou !!!!!!!!");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI) {
        modeloDAO.salvarTbTemp(listaModeloBenVLI);
    }

    @Override
    public Long contar() {
        return modeloDAO.contar();
    }

    @Override
    public List<ModeloBenPeople> listarBeneficiarios(ModeloBenPeople modeloBenPeople) {
        return listarBeneficiarios(modeloBenPeople.getEmpresa(), modeloBenPeople.getMatricula());
    }

    @Override
    public List<ModeloBenPeople> listarBeneficiarios(String empresa, String matricula) {
        return modeloDAO.listarBeneficiarios(empresa, matricula);
    }
}
