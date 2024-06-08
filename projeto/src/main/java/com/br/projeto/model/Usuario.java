package com.br.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome",length = 50, nullable = true)
	private String nome;
	
	@Column(name = "email",length = 50, nullable = true)
	private String email;
	
	@Column(name = "senha",columnDefinition = "TEXT", nullable = true)
	private String senha;

	@Column(name = "confirmar_senha", columnDefinition = "TEXT", nullable = true)
	private String confirmar_senha;
	
	@Column(name = "telefone",length = 15, nullable = true)
	private String telefone;

	@Column(name = "endereco", length = 150, nullable = true)
	private String endereco;

	@Column(name = "cpf", length = 15, nullable = true)
	private String cpf;

	@Column(name = "data_nascimento", nullable = true)
	private Date data_nascimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmar_senha() {
		return confirmar_senha;
	}

	public void setConfirmar_senha(String confirmar_senha) {
		this.confirmar_senha = confirmar_senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
}
