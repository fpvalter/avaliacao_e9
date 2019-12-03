/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.e9.avaliacao.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


/**
 *
 * @author Thiago
 */
public class FuncionarioModel implements Comparable<FuncionarioModel> {
    
    /* Nome  - caracteres  max 128 - obrigatorio */
    /* Apelido - caracteres  max 64 */
    /* Nascimento - date - obrigatorio */
    /* CPF - caracteres  fixo 11 - obrigatorio */
    /* CEP - caracteres  fixo 8 - obrigatorio */
    /* Endereco - caracteres  max 128 - obrigatorio */    
    /* Número - caracteres  max 8 -  */    
    /* Cidade - caracteres  max 128 - obrigatorio */    
    /* Estado - caracteres  fixo 2 - obrigatorio */    
    /* Cargo - caracteres  max 64 - obrigatorio */    
	
	@NotNull(message = "O campo Nome não pode ser Nulo")
	@NotEmpty(message = "O campo Nome não pode ser vazio")
	@Size(max = 128, message = "O campo Nome deve ter no máximo 128 caracteres")
	private String nome;
		
	@Size(max = 64, message = "O campo Apelido deve ter no máximo 64 caracteres")
	private String apelido;
	
	@Past(message = "A Data de Nascimento deve ser uma data passada")
	@NotNull(message = "A data de nascimento deve ser uma data válida")
	private Date nascimento;
	
	@NotNull(message = "O campo CPF não pode ser Nulo")
	@NotEmpty(message = "O campo CPF não pode ser vazio")
	@Size(max = 11, min = 11,  message = "O campo CPF deve ter 11 caracteres")
	private String cpf;
	
	@NotNull(message = "O campo CEP não pode ser Nulo")
	@NotEmpty(message = "O campo CEP não pode ser vazio")
	@Size(max = 8, min = 8,  message = "O campo CEP deve ter 8 caracteres")
	private String cep;
	
	@NotNull(message = "O campo Endereco não pode ser Nulo")
	@NotEmpty(message = "O campo Endereco não pode ser vazio")
	@Size(max = 128, message = "O campo Endereço deve ter no máximo 128 caracteres")
	private String endereco;
		
	@Size(max = 8,  message = "O campo Número deve ter no máximo 11 caracteres")
	private String numero;
	
	@NotNull(message = "O campo Cidade não pode ser Nulo")
	@NotEmpty(message = "O campo Cidade não pode ser vazio")
	@Size(max = 128,  message = "O campo Cidade deve ter no máximo 128 caracteres")
	private String cidade;
	
	@NotNull(message = "O campo Estado não pode ser Nulo")
	@NotEmpty(message = "O campo Estado não pode ser vazio")
	@Size(max = 2,  message = "O campo Estado deve ter no máximo 2 caracteres")
	private String estado;
	
	@NotNull(message = "O campo Cargo não pode ser Nulo")
	@NotEmpty(message = "O campo Cargo não pode ser vazio")
	@Size(max = 64,  message = "O campo Cargo deve ter no máximo 128 caracteres")
	private String cargo;
		
	
	public FuncionarioModel() {
		
	}
	
	public FuncionarioModel(
			String nome, String apelido, Date nascimento, String cpf, String cep, String endereco,
			String numero, String cidade, String estado, String cargo) {
		
		super();
		
		this.nome = nome;
		this.apelido = apelido;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {		
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public String getNascimentoFormatado() {
		
		if(nascimento != null) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(nascimento);
		}
		
		return "";
		
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

		
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioModel other = (FuncionarioModel) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public String toString() {
		return  this.nome + ";" 
				+ this.apelido + ";" 
				+ getNascimentoFormatado() + ";" 
				+ this.cpf + ";" 
				+ this.cep + ";" 
				+ this.endereco + ";" 
				+ this.numero + ";" 
				+ this.cidade + ";"
				+ this.estado + ";" 
				+ this.cargo
				+ "\n";
	}

	
	public int compareTo(FuncionarioModel func) {
		return this.cpf.compareTo(func.getCpf());
	}	
    
}
