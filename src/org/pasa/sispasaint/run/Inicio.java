package org.pasa.sispasaint.run;

import org.pasa.sispasaint.bean.impl.CargaVLIBeanImpl;
import org.pasa.sispasaint.bean.impl.MailConfigBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.mail.MailConfig;


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
