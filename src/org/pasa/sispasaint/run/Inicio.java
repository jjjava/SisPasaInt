package org.pasa.sispasaint.run;

import org.pasa.sispasaint.bean.impl.CargaVLIBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.mail.MailConfig;


/**
 *
 * @author 90J00318
 */
public class Inicio {

    public static void main(String args[]) {
        Configuracao.getInstance();
        
        MailConfig mailConfig = new MailConfig();
        mailConfig.setSenha("pasa1005");
        mailConfig.setUsuario("naoresponda@planopasa.com.br");
        mailConfig.setServidor("smtp.planopasa.com.br");
        
        
        
        
        
        Maestro maestro = new Maestro();
        
        
    }
}
