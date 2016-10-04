package org.pasa.sispasaint.run;

import org.pasa.sispasaint.bean.impl.CargaVLIBeanImpl;
import org.pasa.sispasaint.config.Configuracao;


/**
 *
 * @author 90J00318
 */
public class Inicio {

    public static void main(String args[]) {
        Configuracao.getInstance().getNomeBenVLIarq();
        CargaVLIBeanImpl carga = new CargaVLIBeanImpl();
     //   carga.cargaArquivosTemp();
        carga.mapearEntidades();
        System.out.println("It is over");
    }
}
