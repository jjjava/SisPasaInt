package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.pasa.sispasaint.config.DadosConfig;
import org.pasa.sispasaint.dao.DadosConfigDAO;
import org.pasa.sispasaint.dao.DaoGenerico;

/**
 *
 * @author Hudson Schumaker
 */
public class DadosConfigDAOImpl extends DaoGenerico<DadosConfig> implements DadosConfigDAO {

    public DadosConfigDAOImpl() {
        super(DadosConfig.class);
    }

    @Override
    public DadosConfig obterPorEmpresa(Long id) {
        Query q1 = getEntityManager().
        createQuery("select e from DadosConfig e where e.idEmpresa = :id");
        q1.setParameter("id", id);
        q1.setMaxResults(1);
        List<DadosConfig> dados = null;
        try {
            dados = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println("dadosconfig: "+ex);
            return null;
        }
        if (dados.size() > 0) {
            return dados.get(0);
        }
        return null;
    }
}
