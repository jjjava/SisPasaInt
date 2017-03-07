package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.config.DadosConfiguracao;
import org.pasa.sispasaint.dao.DadosConfigDAO;
import org.pasa.sispasaint.dao.DaoGenerico;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class DadosConfigDAOImpl extends DaoGenerico<DadosConfiguracao> implements DadosConfigDAO {

    public DadosConfigDAOImpl() {
        super(DadosConfiguracao.class);
    }

    @Override
    public DadosConfiguracao obterPorEmpresa(Long id) {
        Query q1 = getEntityManager().
                createQuery("select e from DadosConfiguracao e where e.idEmpresa = :id");
        q1.setParameter("id", id);
        q1.setMaxResults(1);
        List<DadosConfiguracao> dados = null;
        try {
            dados = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(ex);
            Logger.getLogger(DadosConfigDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        if (dados.size() > 0) {
            return dados.get(0);
        }
        return null;
    }
}
