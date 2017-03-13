package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.config.DadosConfiguracao;
import org.pasa.sispasaint.dao.DadosConfiguracaoDAO;
import org.pasa.sispasaint.dao.DaoGenerico;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class DadosConfiguracaoDAOImpl extends DaoGenerico<DadosConfiguracao> implements DadosConfiguracaoDAO {

    public DadosConfiguracaoDAOImpl() {
        super(DadosConfiguracao.class);
    }

    @Override
    public DadosConfiguracao obterPorEmpresa(String cdVale) {
        Query q1 = getEntityManager().
                createQuery("select e from DadosConfiguracao e where e.idEmpresa = :cd");
        q1.setParameter("cd", cdVale);
        q1.setMaxResults(1);
        List<DadosConfiguracao> dados = null;
        try {
            dados = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(DadosConfiguracaoDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (dados.size() > 0) {
            return dados.get(0);
        }
        return null;
    }
}
