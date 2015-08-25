package br.com.counter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FILME")
@EntityListeners(value = LogListener.class)
public class Filme implements Audit, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FILME")
	private Long idFilme;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="ID_GENERO")
	private ItemDominio genero;
	
	@ManyToOne
	@JoinColumn(name="ID_CLASSIFICACAO")
	private ItemDominio classificacao;
	
	@Column(name="DS_NOME")
	private String dsNome;
	
	@Column(name="DS_NACIONALIDADE")
	private String dsNacionalidade;
	
	@Column(name="VL_DURACAO")
	private Integer vlDuracao;
	
	@Column(name="DT_LANCAMENTO")
	@Temporal(TemporalType.DATE)
	private Date dtLancamento;
	
	@Column(name="DT_CADASTRO")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

//	@Column(name="FOTO")
//	private Clob foto;
	
	public Long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ItemDominio getGenero() {
		return genero;
	}

	public void setGenero(ItemDominio genero) {
		this.genero = genero;
	}

	public ItemDominio getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ItemDominio classificacao) {
		this.classificacao = classificacao;
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}

	public String getDsNacionalidade() {
		return dsNacionalidade;
	}

	public void setDsNacionalidade(String dsNacionalidade) {
		this.dsNacionalidade = dsNacionalidade;
	}

	public Integer getVlDuracao() {
		return vlDuracao;
	}

	public void setVlDuracao(Integer vlDuracao) {
		this.vlDuracao = vlDuracao;
	}

	public Date getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(Date dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (idFilme == null) {
			if (other.idFilme != null)
				return false;
		} else if (!idFilme.equals(other.idFilme))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilme == null) ? 0 : idFilme.hashCode());
		return result;
	}
}
