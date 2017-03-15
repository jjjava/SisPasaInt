package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.model.intg.ModeloEndPeople;
import org.pasa.sispasaint.dao.ImpEndPeopleDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpEndPeopleDAOImpl extends DaoGenerico<ModeloEndPeople> implements ImpEndPeopleDAO {

    public ImpEndPeopleDAOImpl() {
        super(ModeloEndPeople.class);
    }

    @Override
    public ModeloEndPeople obterPorMatricula(String empresa, String matricula, String codBeneficiario) {
        ModeloEndPeople m = new ModeloEndPeople();
        List<ModeloEndPeople> lista = null;
        try {
            Query q1 = getEntityManager().
                    createQuery("select e from ModeloEndPeople e WHERE e.empresa = :empresa AND e.matricula = :matricula");
            q1.setParameter("empresa", empresa);
            q1.setParameter("matricula", matricula);
            q1.setMaxResults(1);
            lista = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName() + " Mat:" + empresa + matricula + codBeneficiario + "\n" + ex);
            Logger.getLogger(ImpEndPeopleDAOImpl.class).error(empresa + matricula + codBeneficiario + "\n" + ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), empresa + matricula + codBeneficiario + "\n" + ex.getMessage());
            return null;
        }
        if (lista.size() > 0) {
            return lista.get(0);
        }
        return null;
    }

    @Override
    public void resetarIdentity() {
        try {
            getEntityManager().getTransaction().begin();
            Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('[" + Configuracao.getInstance().getBanco() + "].[" + Configuracao.getInstance().getEsquema() + "].[CARG_END_PEOPLE]', RESEED, 0)");
            q1.executeUpdate();
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            Logger.getLogger(ImpEndPeopleDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        }
    }

    @Override
    public void salvarTbTemp(List<ModeloEndPeople> listaModeloEndVLI) {
        for (ModeloEndPeople model : listaModeloEndVLI) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(model);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                System.err.println(this.getClass().getName() + "\n" + ex);
                Logger.getLogger(ImpEndPeopleDAOImpl.class).error(ex);
                new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
                getEntityManager().getTransaction().rollback();
            }
        }
    }

    @Override
    public List<ModeloEndPeople> list(String empresa, String matricula) {
        Query q1 = getEntityManager().
                createQuery("select m from ModeloEndVLI m where m.matricula and = :mat and m.empresa = :emp and m.codBeneficiario <> '00'");
        q1.setParameter("emp", empresa);
        q1.setParameter("mat", matricula);
        List<ModeloEndPeople> ModeloEnd = null;
        try {
            ModeloEnd = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            Logger.getLogger(ImpEndPeopleDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        return ModeloEnd;
    }

    @Override
    public void copiarTabela() {
        try {
            getEntityManager().getTransaction().begin();
            Query q1 = getEntityManager().createNativeQuery("insert into "
                    + " [sispasa].[dbo].[CARG_END_PEOPLE_TMP] select "
                    + " [BAIRRO]"
                    + ",[BRANCOS]"
                    + ",[CEP]"
                    + ",[CIDADE]"
                    + ",[CODBENEFICIARIO]"
                    + ",[EMPRESA]"
                    + ",[ENDERECO]"
                    + ",[MATRICULA]"
                    + ",[NOMEARQUIVO]"
                    + ",[TELEFONE1]"
                    + ",[TELEFONE2]"
                    + ",[UF]) select "
                    + " [BAIRRO]"
                    + ",[BRANCOS]"
                    + ",[CEP]"
                    + ",[CIDADE]"
                    + ",[CODBENEFICIARIO]"
                    + ",[EMPRESA]"
                    + ",[ENDERECO]"
                    + ",[MATRICULA]"
                    + ",[NOMEARQUIVO]"
                    + ",[TELEFONE1]"
                    + ",[TELEFONE2]"
                    + ",[UF] from [sispasa].[dbo].[CARG_END_PEOPLE]");
            q1.executeUpdate();
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(this.getClass().getName() + "\n" + ex);
            Logger.getLogger(ImpBenPeopleDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        }
    }
}
