package org.pasa.sispasaint.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.model.intg.ModeloBenPeople;
import org.pasa.sispasaint.dao.ImpBenPeopleDAO;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ImpBenPeopleDAOImpl extends DaoGenerico<ModeloBenPeople> implements ImpBenPeopleDAO {

    public ImpBenPeopleDAOImpl() {
        super(ModeloBenPeople.class);
    }

    @Override
    public void resetarIdentity() {
        getEntityManager().getTransaction().begin();
        Query q1 = getEntityManager().createNativeQuery("DBCC CHECKIDENT ('["+Configuracao.getInstance().getBanco()+"].["+Configuracao.getInstance().getEsquema()+"].[CARG_BEN_PEOPLE]', RESEED, 0)");
        q1.executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void salvarTbTemp(List<ModeloBenPeople> listaModeloBenVLI) {
        for (ModeloBenPeople model : listaModeloBenVLI) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(model);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                System.err.println(this.getClass().getName()+"\n"+ex);
                Logger.getLogger(ImpBenPeopleDAOImpl.class).error(ex);
                new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
                getEntityManager().getTransaction().rollback();
            }
        }
    }

    @Override
    public List<ModeloBenPeople> listarBeneficiarios(String empresa, String matricula) {
        Query q1 = getEntityManager().
                createQuery("select m from ModeloBenPeople m where m.matricula = :mat and m.empresa = :emp");
        q1.setParameter("emp", empresa);
        q1.setParameter("mat", matricula);
        List<ModeloBenPeople> modelos = null;
        try {
            modelos = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(ImpBenPeopleDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            return null;
        }
        return modelos;
    }

    @Override
    public List<ModeloBenPeople> verificarInativos() {
        List<ModeloBenPeople> modelos = null;
        Query q1 = getEntityManager().
                createQuery("SELECT a FROM ModeloBenPeople a LEFT JOIN ModeloBenPeopleTemp b ON "
                        + "a.empresa = b.empresa AND a.matricula = b.matricula WHERE "
                        + "b.empresa IS NULL AND b.matricula IS NULL");
        try {
            modelos = q1.getResultList();
        } catch (NoResultException ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
            Logger.getLogger(BeneficiarioDAOImpl.class).error(ex);
            return null;
        }
        return modelos;
    }

    @Override
    public void copiarTabela() {
        try {
            getEntityManager().getTransaction().begin();
            Query q1 = getEntityManager().createNativeQuery("insert into ["+Configuracao.getInstance().getBanco()+"].["+Configuracao.getInstance().getEsquema()+".[CARG_BEN_PEOPLE_TMP] "
                    + "select [AGENCIABANCARIA]"
                    + ",[BANCO]"
                    + ",[BRANCO]"
                    + ",[CASSIDATA]"
                    + ",[CENTRODECUSTO]"
                    + ",[CODBENEFICIARIO]"
                    + ",[CODIGOCR]"
                    + ",[CODIGODIREITOPASA]"
                    + ",[CODIGOFILIALVLI]"
                    + ",[CODIGONACIONALDESAUDE]"
                    + ",[CONTACORRENTE]"
                    + ",[CONTRATOTRABALHO]"
                    + ",[CPF]"
                    + ",[DATAADMISSAO]"
                    + ",[DATADEATUALIZACAO]"
                    + ",[DATAFALECIMENTO]"
                    + ",[DATANASCIMENTO]"
                    + ",[DATAVALIDADECREDENCIADO]"
                    + ",[DATAVALIDADEREEMBOLSO]"
                    + ",[DECLARACAONASCIDOVIVO]"
                    + ",[DIREITOAMSCREDENCIAMENTO]"
                    + ",[DIREITOABATERIR]"
                    + ",[DIREITOAMSREEMBOLSO]"
                    + ",[EMPRESA]"
                    + ",[EMPRESAATUALIZADOR]"
                    + ",[EMPRESAORIGEM]"
                    + ",[EMPRESAPEOPLE]"
                    + ",[FAIXANIVEL]"
                    + ",[FINANCEIRA]"
                    + ",[GRAUESCOLARIDADE]"
                    + ",[GRAUPARENTESCO]"
                    + ",[INDICADORCONCLUSAO]"
                    + ",[MATRICULA]"
                    + ",[MATRICULAATULIZADOR]"
                    + ",[MATRICULAORIGEM]"
                    + ",[MATRICULAPARTICIPANTE]"
                    + ",[MATRICULAPASA]"
                    + ",[MATRICULAPEOPLE]"
                    + ",[MATRICULAREPRESENTANTELEGAL]"
                    + ",[NOMEARQUIVO]"
                    + ",[NOMEBENEFICIARIO]"
                    + ",[NOMEBENEFICIARIOABREVIADO]"
                    + ",[NOMEDAMAE]"
                    + ",[NUCLEODAAMS]"
                    + ",[ORGAOPESSOAL]"
                    + ",[PIS]"
                    + ",[PLANO]"
                    + ",[PLANODERECIPROCIDADECASSI]"
                    + ",[SEXO]"
                    + ",[TIPOBENEFICIARIO]"
                    + ",[UNIDADEDECONTROLE]"
                    + ",[VINCULO] from [sispasa-dev].[dbo].[CARG_BEN_PEOPLE]");
            q1.executeUpdate();
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(this.getClass().getName()+"\n"+ex);
            Logger.getLogger(ImpBenPeopleDAOImpl.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        }
    }
}
