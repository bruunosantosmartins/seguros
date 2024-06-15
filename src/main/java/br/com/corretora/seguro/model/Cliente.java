package br.com.corretora.seguro.model;

import lombok.Data;

@Data
public class Cliente {

	// Nome do cliente informado na entrada.
	private String name;

	// CPF do cliente.
	private String cpf;

	// Idade informada.
	private int age;

	// Localizacao do cliente.
	private String location;

	// Valor informado
	private double valor_veiculo;

	// Construtor para retorno do no POST
	public Cliente() {
	}

	public Cliente(String name, String cpf, int age, String location, double valor_veiculo) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.location = location;
		this.valor_veiculo = valor_veiculo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getValor_veiculo() {
		return valor_veiculo;
	}

	public void setValor_veiculo(double valor_veiculo) {
		this.valor_veiculo = valor_veiculo;
	}

}
