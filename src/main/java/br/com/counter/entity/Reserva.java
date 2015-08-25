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
@Table(name="RESERVA")
public class Reserva implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RESERVA")
	private Long idReserva;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Usuario cliente;

	@ManyToOne
	@JoinColumn(name="ID_EXEMPLAR")
	private Exemplar exemplar;

	@ManyToOne
	@JoinColumn(name="ID_FUNCIONARIO")
	private Usuario funcionario;
	
	@Column(name="ID_STATUS_RESERVA")
	private ItemDominio statusReserva;

	@Column(name="DT_RESERVA")
	@Temporal(TemporalType.DATE)
	private Date dtReserva;

	@Column(name="DT_FINAL_RESERVA")
	@Temporal(TemporalType.DATE)
	private Date dtFinalReserva;

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public Usuario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Usuario funcionario) {
		this.funcionario = funcionario;
	}

	public ItemDominio getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(ItemDominio statusReserva) {
		this.statusReserva = statusReserva;
	}

	public Date getDtReserva() {
		return dtReserva;
	}

	public void setDtReserva(Date dtReserva) {
		this.dtReserva = dtReserva;
	}

	public Date getDtFinalReserva() {
		return dtFinalReserva;
	}

	public void setDtFinalReserva(Date dtFinalReserva) {
		this.dtFinalReserva = dtFinalReserva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idReserva == null) ? 0 : idReserva.hashCode());
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
		Reserva other = (Reserva) obj;
		if (idReserva == null) {
			if (other.idReserva != null)
				return false;
		} else if (!idReserva.equals(other.idReserva))
			return false;
		return true;
	}

}
