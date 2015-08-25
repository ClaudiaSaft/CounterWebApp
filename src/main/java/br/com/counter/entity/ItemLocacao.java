package br.com.counter.entity;

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

@Entity
@Table(name="ITEM_LOCACAO")
public class ItemLocacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ITEM_LOCACAO")
	private Long idItemLocacao;
	
	@ManyToOne
	@JoinColumn(name="ID_LOCACAO")
	private Locacao locacao;

	@ManyToOne
	@JoinColumn(name="ID_EXEMPLAR")
	private Exemplar exemplar;
	
	@Column(name="DT_DEVOLUCAO")
	@Temporal(TemporalType.DATE)
	private Date dtDevolucao;
	
	@ManyToOne
	@JoinColumn(name="ID_STATUS_LOCACAO")
	private ItemDominio statusLocacao;

	public Long getIdItemLocacao() {
		return idItemLocacao;
	}

	public void setIdItemLocacao(Long idItemLocacao) {
		this.idItemLocacao = idItemLocacao;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public ItemDominio getStatusLocacao() {
		return statusLocacao;
	}

	public void setStatusLocacao(ItemDominio statusLocacao) {
		this.statusLocacao = statusLocacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idItemLocacao == null) ? 0 : idItemLocacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLocacao other = (ItemLocacao) obj;
		if (idItemLocacao == null) {
			if (other.idItemLocacao != null)
				return false;
		} else if (!idItemLocacao.equals(other.idItemLocacao))
			return false;
		return true;
	}

}
