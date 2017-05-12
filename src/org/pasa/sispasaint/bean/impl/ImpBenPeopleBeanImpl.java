package org.pasa.sispasaint.bean.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasaint.dao.impl.ImpBenPeopleDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.carga.thread.CargaBenPeopleThread;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.util.ArquivoUtil;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.Sistema;
import org.pasa.sispasaint.bean.ImpBenPeopleBean;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpBenPeopleBeanImpl implements ImpBenPeopleBean {

    private final ImpBenPeopleDAOImpl modeloDAO;
    private final FuncionarioBeanImpl funcionarioBean;
    private final BeneficiarioBeanImpl beneficiarioBean;

    public ImpBenPeopleBeanImpl() {
        this.modeloDAO = new ImpBenPeopleDAOImpl();
        this.funcionarioBean = new FuncionarioBeanImpl();
        this.beneficiarioBean = new BeneficiarioBeanImpl();
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
    public void limparTabela() {
        modeloDAO.limpaTB();
    }

    @Override
    public void resetarIdentity() {
        modeloDAO.resetarIdentity();
    }

    @Override
    public void carregarArquivo(String cdVale, Log log) {
        try {
            if (ArquivoUtil.getNumerosLinhaArquivo(Configuracao.getInstance().getBenNomeArqComPath(cdVale)) > 20000) {
                ExecutorService executor = Executors.newFixedThreadPool(Sistema.getNumberProcessors());
                int lote = ArquivoUtil.getNumeroLinhasLote(ArquivoUtil.getNumerosLinhaArquivo(Configuracao.getInstance().getBenNomeArqComPath(cdVale)));
                int loteLines = lote;
                lote = lote * SisPasaIntCommon.LINE_TAM_2;
                int ini = 0;
                int fim = lote;
                for (int i = 0; i < Sistema.getNumberProcessors(); i++) {
                    executor.execute(new CargaBenPeopleThread(log, cdVale, ini, fim, lote, loteLines));
                    ini = fim;
                    fim = fim + lote;
                }
                executor.shutdown();
                while (!executor.isTerminated()) {
                }
            } else {
                ExecutorService executor = Executors.newFixedThreadPool(1);
                executor.execute(new CargaBenPeopleThread(log, cdVale));
            }
        } catch (IOException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            Logger.getLogger(ImpBenPeopleBeanImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
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

    @Override
    public void copiarTabela() {
        modeloDAO.copiarTabela();
    }

    @Override
    public List<ModeloBenPeople> verificarInativos() {
        return modeloDAO.verificarInativos();
    }

    @Override
    public void inativar(List<ModeloBenPeople> listaInativar) {
        for (ModeloBenPeople modelo : listaInativar) {
            Funcionario f = funcionarioBean.obter(modelo.getEmpresa(), modelo.getMatricula());
            f.setIndAtivo(SisPasaIntCommon.INATIVO);
            f.setDataDesligamento(DateUtil.obterDataAtual());
            f.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            funcionarioBean.atualizar(f);
            //BENEFICIARIOS
            List<Beneficiario> lista = beneficiarioBean.listar(modelo.getEmpresa(), modelo.getMatricula());
            for (Beneficiario b : lista) {
                b.setIndAtivo(SisPasaIntCommon.INATIVO);
                b.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
                beneficiarioBean.atualizar(b);
            }
        }
    }
}
