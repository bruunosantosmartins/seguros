package br.com.corretora.seguro.model;

public class Insurances {

	// Descrição do tipo de seguro oferecido
	private String type;

	// Valor calculado do seguro
	private double cost;

	// Construtor lista json retorno nas opções de seguros
	public Insurances() {
	}

	public Insurances(String type, double cost) {
		this.type = type;
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
