package org.pasa.sispasaint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
@Entity
@Table(name = "DADOS_BANCARIOS")
public class DadosBancarios extends EntidadeBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DADOS_BANCARIOS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ENTIDADE")
    private Long idEntidade;

    @Column(name = "CD_BANCO")
    private int codigoBanco;

    @Column(name = "NR_AGENCIA")
    private int numeroAgencia;

    @Column(name = "NR_CONTA_CORRENTE")
    private int numeroContaCorrente;

    public DadosBancarios() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(Long idEntidade) {
        this.idEntidade = idEntidade;
    }

    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public void setNumeroContaCorrente(int numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
    }
}
