package org.pasa.sispasa.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */

@Entity
@Table(name = "CONVENIO")
public class Convenio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CONVENIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DT_INICIO_VIGENCIA", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DT_FIM")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "QTD_DIAS_ASSOC")
	private Integer qtdDiasAssociacao;

	@Column(name = "QTD_DIAS_ADESAO")
	private Integer qtdDiasAdesao;

	@Column(name = "IND_PARTICIP_TAXA_ASSOC", nullable = false)
	private Integer indParticipacaoTaxaAssociado;

	@Column(name = "IND_CONTRIB_ASSOC", nullable = false)
	private Integer indContribuicaoAssociado;

	@Column(name = "IND_CONTRIB_AGREG", nullable = false)
	private Integer indContribuicaoAgregado;

	@Column(name = "IND_CONTRIB_DEPEN", nullable = false)
	private Integer indContribDependente;

	@Column(name = "ID_USUARIO", nullable = false)
	private Long idUsuario;

	@Column(name = "IND_ATIVO", nullable = false)
	private Integer indAtivo;
	
	@Column(name = "DT_ULT_ATULZ", nullable= false)
	@Temporal(TemporalType.DATE)
	private Date dataUltAtulizacao;
	
	@ManyToOne
	@JoinColumn(name = "ID_TP_PAGAMENTO")
	private TipoPagamento tipoPagamento;
	
	@ManyToOne
	@JoinColumn(name = "ID_TP_PARTICIP")
	private TipoParticipacao tipoParticipacao;
	
	@ManyToOne
	@JoinColumn(name = "ID_EMPRESA")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "ID_CONTRATO")
	private Contrato contrato;

	public Convenio() {
	}

}