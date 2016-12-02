package org.pasa.sispasaint.run;

import org.pasa.sispasa.core.model.Pais;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.dao.impl.PaisDAOImpl;


/**
 *
 * @author 90J00318
 */
public class Inicio {

    public static void main(String args[]) {
        Configuracao.getInstance();        
        Maestro maestro = new Maestro(); 
    }
}
