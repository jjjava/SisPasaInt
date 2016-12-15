package org.pasa.sispasaint.run;

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
      
//       CargaVLIBeanImpl carga = new CargaVLIBeanImpl(30L, new Log());
//        carga.cargaArquivosTemp();
//       // carga.mapearEntidades();
    }
}
