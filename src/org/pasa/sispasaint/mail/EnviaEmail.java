package org.pasa.sispasaint.mail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.pasa.sispasaint.config.Configuracao;

/**
 *
 * @author Hudson Schumaker 
 * @version 1.0.0
 */
public class EnviaEmail {

    private String remetente;
    private String subject;
    private String message;
    private String senha;
    private String host;
    private List<String> lista;

    public EnviaEmail(List<String> l, String s, String m) {
        lista = l;
        subject = s;
        message = m;
        remetente = Configuracao.getInstance().getUsuario();
        senha = Configuracao.getInstance().getSenha();
        host = Configuracao.getInstance().getServidor();        
    }

   public void send() {
        try {
            SimpleDateFormat dtString = new SimpleDateFormat("dd/MM/yyyy hh:MM");
            SimpleEmail email = new SimpleEmail();
            email.setHostName(host);
            for (String d: lista) {
                email.addTo(d);
            }
            email.setFrom(remetente);
            email.setSubject(subject + dtString.format(new Date()));
            email.setMsg(message);
            System.out.println("autenticando...");
            email.setSSL(true);
            email.setAuthentication(remetente, senha);
            System.out.println("enviando...");
            email.send();
            System.out.println("Email enviado!");
        } catch (EmailException ex) {
            System.err.println(ex);
        }
    }
}
