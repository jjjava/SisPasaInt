package org.pasa.sispasaint.run;

import org.pasa.sispasaint.config.Configuracao;


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
