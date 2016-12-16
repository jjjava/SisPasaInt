package org.pasa.sispasaint.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Hudson Schumaker - HStudio 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Autenticar extends Authenticator {
    
    private String user;
    private String pass;
    public Autenticar(){
        
    }
    public Autenticar(String user, String pass){
        this.user = user;
        this.pass = pass;
    }
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user, pass);
    }
}