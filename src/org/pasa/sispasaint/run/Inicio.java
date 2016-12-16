package org.pasa.sispasaint.run;

import org.pasa.sispasaint.carga.CargaBenEndBeanImpl;
import org.pasa.sispasaint.carga.CargaVLIBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.model.intg.Log;

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

//        CargaBenEndBeanImpl carga = new CargaBenEndBeanImpl(30L, new Log());
//        carga.inicar();

    }
}
