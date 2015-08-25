package br.com.counter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.counter.validators.Cep;

@Entity
@Table(name="USUARIO")
@EntityListeners(value = LogListener.class)
public class Usuario implements Audit, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Nome é obrigatório")
	@Length(max = 45)
	@Column(name="NOME")
	private String nome;
	
	@NotEmpty(message = "E-mail é obrigatório")
	@Email
	@Length(max = 45)
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONE")
	@Length(max = 45)
	private String telefone;
	
	@Column(name="DT_CADASTRO")
	private Date dataCadastro;
	
	@Column(name="DT_NASCIMENTO")
	private Date dataNascimento;
	
	@Cep
	@Column(name="NR_CEP")
	private String cep;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

//	@PrePersist
//	public void changeDate(){
//		this.dataCadastro = new Date();
//	}
	
	
}
