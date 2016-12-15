/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pasa.sispasaint.dao.impl;

import java.util.List;
import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ModeloBenEndDAO;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;

/**
 *
 * @author 90J00318
 */
public class ModeloBenEndDAOImpl extends DaoGenerico<ModeloBenEnd> implements ModeloBenEndDAO{

    public ModeloBenEndDAOImpl() {
        super(ModeloBenEnd.class);
    }

    @Override
    public void limparTbTemp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetarIdentity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarTbTemp(List<ModeloBenEnd> listaModeloBenEnd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
