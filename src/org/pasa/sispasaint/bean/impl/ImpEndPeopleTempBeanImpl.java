package org.pasa.sispasaint.bean.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.pasa.sispasaint.dao.impl.ImpEndPeopleTempDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.bean.ImpEndPeopleTempBean;
import org.pasa.sispasaint.carga.impl.CargaEndPeopleThread;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.util.ArquivoUtil;
import org.pasa.sispasaint.util.Sistema;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpEndPeopleTempBeanImpl implements ImpEndPeopleTempBean {

    private final ImpEndPeopleTempDAOImpl modeloDAO;

    public ImpEndPeopleTempBeanImpl() {
        modeloDAO = new ImpEndPeopleTempDAOImpl();
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
            lote = lote * 190;
            int ini = 0;
            int fim = lote;

            for (int i = 0; i < Sistema.getNumberProcessors() ; i++) {
                executor.execute(new CargaEndPeopleThread(id, ini, fim, lote, loteLines));
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
}
