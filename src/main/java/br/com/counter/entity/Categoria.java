package br.com.counter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CATEGORIA")
	private Long idDominio;
	
	@Column(name="DS_CATEGORIA")
	private String dsDominio;

	@Column(name="VL_PRECO")
	private Double vlPreco;

	public Long getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(Long idDominio) {
		this.idDominio = idDominio;
	}

	public String getDsDominio() {
		return dsDominio;
	}

	public void setDsDominio(String dsDominio) {
		this.dsDominio = dsDominio;
	}

	public Double getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(Double vlPreco) {
		this.vlPreco = vlPreco;
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
		Categoria other = (Categoria) obj;
		if (idDominio == null) {
			if (other.idDominio != null)
				return false;
		} else if (!idDominio.equals(other.idDominio))
			return false;
		return true;
	}
	
}
