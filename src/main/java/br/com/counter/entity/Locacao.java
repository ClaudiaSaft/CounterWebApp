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
@Table(name="LOCACAO")
public class Locacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LOCACAO")
	private Long idLocacao;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Usuario cliente;

	@ManyToOne
	@JoinColumn(name="ID_FUNCIONARIO")
	private Usuario funcionario;
	
	@Column(name="DT_LOCACAO")
	@Temporal(TemporalType.DATE)
	private Date dtLocacao;

	public Long getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Usuario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Usuario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDtLocacao() {
		return dtLocacao;
	}

	public void setDtLocacao(Date dtLocacao) {
		this.dtLocacao = dtLocacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idLocacao == null) ? 0 : idLocacao.hashCode());
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
		Locacao other = (Locacao) obj;
		if (idLocacao == null) {
			if (other.idLocacao != null)
				return false;
		} else if (!idLocacao.equals(other.idLocacao))
			return false;
		return true;
	}
	
}
