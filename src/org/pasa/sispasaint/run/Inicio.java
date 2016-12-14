package org.pasa.sispasaint.run;

import org.pasa.sispasaint.carga.CargaVLIBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.model.intg.Log;


/**
 *
 * @author 90J00318
 */
public class Inicio {

    public static void main(String args[]) {
        Configuracao.getInstance();        
      //  Maestro maestro = new Maestro(); 
      
       CargaVLIBeanImpl carga = new CargaVLIBeanImpl(30L, new Log());
        carga.cargaArquivosTemp();
        carga.mapearEntidades();
    }
}
