package br.com.counter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOMINIO")
public class Dominio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_DOMINIO")
	private Long idDominio;
	
	@Column(name="CD_DOMINIO")
	private String cdDominio;
	
	@Column(name="DS_DOMINIO")
	private String dsDominio;

	public Long getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(Long idDominio) {
		this.idDominio = idDominio;
	}

	public String getCdDominio() {
		return cdDominio;
	}

	public void setCdDominio(String cdDominio) {
		this.cdDominio = cdDominio;
	}

	public String getDsDominio() {
		return dsDominio;
	}

	public void setDsDominio(String dsDominio) {
		this.dsDominio = dsDominio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDominio == null) ? 0 : idDominio.hashCode());
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
		Dominio other = (Dominio) obj;
		if (idDominio == null) {
			if (other.idDominio != null)
				return false;
		} else if (!idDominio.equals(other.idDominio))
			return false;
		return true;
	}
	
}
