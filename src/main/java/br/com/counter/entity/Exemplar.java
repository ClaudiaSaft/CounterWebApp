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
@Table(name="EXEMPLAR")
public class Exemplar implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EXEMPLAR")
	private Long idExemplar;
	
	@ManyToOne
	@JoinColumn(name="ID_FILME")
	private Filme filme;
	
	@Column(name="DT_AQUISICAO")
	@Temporal(TemporalType.DATE)
	private Date dtAquisicao;
	
	@ManyToOne
	@JoinColumn(name="ID_STATUS_EXEMPLAR")
	private ItemDominio statusExemplar;

	public Long getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(Long idExemplar) {
		this.idExemplar = idExemplar;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Date getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(Date dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public ItemDominio getStatusExemplar() {
		return statusExemplar;
	}

	public void setStatusExemplar(ItemDominio statusExemplar) {
		this.statusExemplar = statusExemplar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idExemplar == null) ? 0 : idExemplar.hashCode());
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
		Exemplar other = (Exemplar) obj;
		if (idExemplar == null) {
			if (other.idExemplar != null)
				return false;
		} else if (!idExemplar.equals(other.idExemplar))
			return false;
		return true;
	}
	
}
