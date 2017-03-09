package org.pasa.sispasaint.mail;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.pasa.sispasaint.bean.impl.LogBeanImpl;
import org.pasa.sispasaint.config.Configuracao;
import org.pasa.sispasaint.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class EnviaEmail {

    private final List<String> lista;
    private final String subject;
    private final String message;

    public EnviaEmail(List<String> lista, String subject, String message) {
        this.lista = lista;
        this.subject = subject;
        this.message = message;
    }

    public void enviar() {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", Configuracao.getInstance().getServidor());
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session s = Session.getDefaultInstance(props, new Autenticar(Configuracao.getInstance().getUsuario(), Configuracao.getInstance().getSenha()));
            MimeMessage email = new MimeMessage(s);
            InternetAddress de = new InternetAddress(Configuracao.getInstance().getUsuario());
            email.setFrom(de);
            for (String d : lista) {
                InternetAddress para = new InternetAddress(d);
                email.addRecipient(Message.RecipientType.TO, para);
            }
            email.setSubject(subject + DateUtil.obterDataAtual());
            email.setText(message);
            Transport.send(email);
        } catch (AddressException ex) {
            System.err.println(ex);
            Logger.getLogger(EnviaEmail.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        } catch (MessagingException ex) {
            System.err.println(ex);
            Logger.getLogger(EnviaEmail.class).error(ex);
            new LogBeanImpl().logErroClass(this.getClass().getName(), ex.getMessage());
        }
    }
}
