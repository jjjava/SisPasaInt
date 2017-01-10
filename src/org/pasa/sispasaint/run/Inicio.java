package org.pasa.sispasaint.run;

import org.pasa.sispasaint.config.Configuracao;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class Inicio {

    public static void main(String args[]) {
        Configuracao.getInstance();
        Maestro maestro = new Maestro(); 
        maestro.iniciar();
    }
}
