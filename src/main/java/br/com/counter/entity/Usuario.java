package br.com.counter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="DT_CADASTRO")
	private Date dataCadastro;
	
	@Column(name="DT_NASCIMENTO")
	private Date dataNascimento;

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
	
}
