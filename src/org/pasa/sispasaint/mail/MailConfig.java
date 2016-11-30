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

    @Id
    @Column(name = "ID_CONFIG",columnDefinition = ConstantesBanco.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String usuario;
    private String senha;
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
        try {
            return Criptografia.decriptografarBase64(senha);
        } catch (EncoderException ex) {
            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setSenha(String senha) {
        try {
            this.senha = Criptografia.criptografarBase64(senha);
        } catch (EncoderException ex) {
            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
}
