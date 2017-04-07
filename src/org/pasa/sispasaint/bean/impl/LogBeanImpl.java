package org.pasa.sispasaint.bean.impl;

import java.util.List;
import org.pasa.sispasaint.bean.LogBean;
import org.pasa.sispasaint.dao.impl.LogDAOImpl;
import org.pasa.sispasaint.model.intg.Log;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntErro;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class LogBeanImpl implements LogBean{

    public LogBeanImpl(){
    }

    @Override
    public void cadastrar(Log l) {
        l.setDataFim(DateUtil.obterDataAtual());
       // new LogDAOImpl().atualizar(l);
    }

    @Override
    public void atualizar(Log l) {
        l.setDataFim(DateUtil.obterDataAtual());
      //  new LogDAOImpl().atualizar(l);
    }

    @Override
    public void apagar(Log l) {
        new LogDAOImpl().apagar(l);
    }

    @Override
    public List<Log> listar() {
        return new LogDAOImpl().listar();
    }
    
    public void logErroClass(String classe, String erro){
       Log l = new Log();
       l.addClasseErro(classe, SisPasaIntErro.TP_LOG_0 , StringUtil.truncErroLog(erro));
       l.setDataFim(DateUtil.obterDataAtual());
     //  new LogDAOImpl().cadastrar(l);
    }
}