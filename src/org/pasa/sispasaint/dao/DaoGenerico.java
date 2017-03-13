package org.pasa.sispasaint.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;

/**
 *
 * @author Hudson Schumaker
 * @param <T> Classe concreta (Model)
 *
 */
public abstract class DaoGenerico<T> {

    @PersistenceContext
    private final EntityManager em;
    private final EntityManagerFactory emf;
    public final Class<T> entityClass;

    public DaoGenerico(Class<T> entityClass) {
        emf = Persistence.createEntityManagerFactory("SisPasaIntPU");
        em = emf.createEntityManager();
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public boolean cadastrar(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            Logger.getLogger(DaoGenerico.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            Logger.getLogger(DaoGenerico.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return false;
        }
    }

    public void apagar(T entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    public T obter(Long id) {
        em.getTransaction().begin();
        T t = em.find(entityClass, id);
        em.getTransaction().commit();
        return t;
    }

    public Long contar() {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(entityClass)));
        return em.createQuery(cq).getSingleResult();
    }

    public void limpaTB() {
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<T> query = builder.createCriteriaDelete(entityClass);
        query.from(entityClass);
        em.createQuery(query).executeUpdate();
        em.getTransaction().commit();
    }

    public List<T> listar() {
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return (List<T>) em.createQuery(cq).getResultList();
    }
}
