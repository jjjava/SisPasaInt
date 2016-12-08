package org.pasa.sispasaint.mail;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.codec.EncoderException;
import org.pasa.sispasa.core.constants.ConstantesBanco;
import org.pasa.sispasaint.util.Criptografia;

/**
 *
 * @author 90J00318
 */
@Entity
@Table(name = "EMAIL_CONFIGURACAO")
public class MailConfig implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CONFIG")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    
    @Column(name = "USUARIO", length = 30)
    private String usuario;
    
    @Column(name = "SENHA", length = 8)
    private String senha;
    
    @Column(name = "SERVIDOR", length = 30)
    private String servidor;
    
    public MailConfig() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
//        try {
//            return Criptografia.decriptografarBase64(senha);
//        } catch (EncoderException ex) {
//            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
    }

    public void setSenha(String senha) {
        this.senha = senha;
//        try {
//            this.senha = Criptografia.criptografarBase64(senha);
//        } catch (EncoderException ex) {
//            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
}
