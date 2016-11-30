/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pasa.sispasaint.dao.impl;

import org.pasa.sispasaint.dao.DaoGenerico;
import org.pasa.sispasaint.dao.ListaDestinatariosDAO;
import org.pasa.sispasaint.model.intg.ListaDestinatarios;

/**
 *
 * @author 90J00318
 */
public class ListaDestinatariosDAOImpl extends DaoGenerico<ListaDestinatarios> implements ListaDestinatariosDAO{
    
    public ListaDestinatariosDAOImpl() {
        super(ListaDestinatarios.class);
    }
}
