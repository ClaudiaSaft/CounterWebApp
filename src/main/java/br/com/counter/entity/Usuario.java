package br.com.counter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.counter.enumeration.SexoEnum;
import br.com.counter.validators.Cep;

@Entity
@Table(name="USUARIO")
@EntityListeners(value = LogListener.class)
public class Usuario implements Audit, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotEmpty(message = "Nome é obrigatório")
	@Length(max = 40)
	@Column(name="DS_NOME")
	private String dsNome;

	@Length(max = 40)
	@Column(name="DS_ENDERECO")
	private String dsEndereco;

	@Length(max = 40)
	@Column(name="DS_CIDADE")
	private String dsCidade;
	
	@Cep
	@Column(name="NR_CEP")
	private String cep;
	
	@Length(max = 40)
	@Column(name="DS_UF")
	private String dsUf;

	@Column(name="NR_TELEFONE")
	private Long nrTelefone;

	@Column(name="DT_NASCIMENTO")
	private String dtNascimento;
	
	@Column(name="NR_RG")
	private Long nrRg;
	
	@Column(name="NR_CPF")
	private Long nrCpf;
	
	@Email
	@Length(max = 40)
	@Column(name="DS_EMAIL")
	private String dsEmail;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="TP_SEXO")
	private SexoEnum sexo;
	
	//MAPEAR DEPOIS
	@Transient
	private Usuario usuarioDependente;
	
	@Column(name="DT_CADASTRO")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}

	public String getDsEndereco() {
		return dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsCidade() {
		return dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDsUf() {
		return dsUf;
	}

	public void setDsUf(String dsUf) {
		this.dsUf = dsUf;
	}

	public Long getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(Long nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Long getNrRg() {
		return nrRg;
	}

	public void setNrRg(Long nrRg) {
		this.nrRg = nrRg;
	}

	public Long getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(Long nrCpf) {
		this.nrCpf = nrCpf;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public Usuario getUsuarioDependente() {
		return usuarioDependente;
	}

	public void setUsuarioDependente(Usuario usuarioDependente) {
		this.usuarioDependente = usuarioDependente;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

//	@PrePersist
//	public void changeDate(){
//		this.dataCadastro = new Date();
//	}
	
}
