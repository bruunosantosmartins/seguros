package br.com.corretora.seguro.model;

import java.util.List;

public class ClienteInsurance {

	// Nome do cliente na área de retono
	private String name;
	// Lista com as opções de seguros.
	private List<Insurances> insurances;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Insurances> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurances> insurances) {
		this.insurances = insurances;
	}

}
