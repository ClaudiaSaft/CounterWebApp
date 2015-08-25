package br.com.counter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="ITEM_DOMINIO")
public class ItemDominio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ITEM_DOMINIO")
	private Long idItemDominio;
	
	@Column(name="CD_ITEM_DOMINIO")
	private String cdItemDominio;

	@Column(name="DS_ITEM_DOMINIO")
	private String dsItemDominio;
	
	@ManyToOne
	@JoinColumn(name="ID_DOMINIO")
	private Dominio dominio;

	public Long getIdItemDominio() {
		return idItemDominio;
	}

	public void setIdItemDominio(Long idItemDominio) {
		this.idItemDominio = idItemDominio;
	}

	public String getCdItemDominio() {
		return cdItemDominio;
	}

	public void setCdItemDominio(String cdItemDominio) {
		this.cdItemDominio = cdItemDominio;
	}

	public String getDsItemDominio() {
		return dsItemDominio;
	}

	public void setDsItemDominio(String dsItemDominio) {
		this.dsItemDominio = dsItemDominio;
	}

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idItemDominio == null) ? 0 : idItemDominio.hashCode());
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
		ItemDominio other = (ItemDominio) obj;
		if (idItemDominio == null) {
			if (other.idItemDominio != null)
				return false;
		} else if (!idItemDominio.equals(other.idItemDominio))
			return false;
		return true;
	}
	
}
