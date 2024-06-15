package br.com.corretora.seguro.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.corretora.seguro.model.Cliente;
import br.com.corretora.seguro.model.ClienteInsurance;
import br.com.corretora.seguro.model.Insurances;

@Service
public class CalculoSegurosService {

	public ClienteInsurance calculoSeguro(Cliente cliente) {

		List<Insurances> insurances = new ArrayList<>();
		// Valor do veiculo informado
		double valorVeiculo = cliente.getValor_veiculo();
		// Idade do cliente
		int age = cliente.getAge();
		// Localização do cliente
		String location = cliente.getLocation();
		// Taxa para plano Basic
		double valorPercBasic = 0.02;
		// Taxa para plano Parcial
		double valorPercParcial = 0.03;
		// Taxa para plano Total
		double valorPercTotal = 0.04;

		// Verificar qual tipo de seguro pode ser aplicado
		if (valorVeiculo <= 70000) {
			insurances.add(new Insurances("basic", valorVeiculo * valorPercBasic));
			if (age < 30 && location.equals("SP")) {
				insurances.add(new Insurances("parcial", valorVeiculo * valorPercParcial));
			}
		} else if (valorVeiculo < 100000) {
			insurances.add(new Insurances("basic", valorVeiculo * valorPercBasic));
			if (location.equals("SP")) {
				insurances.add(new Insurances("parcial", valorVeiculo * valorPercParcial));
			}
		} else {
			insurances.add(new Insurances("basic", valorVeiculo * valorPercBasic));
			if (age < 30) {
				insurances.add(new Insurances("parcial", valorVeiculo * valorPercParcial));
			}
			insurances.add(new Insurances("total", valorVeiculo * valorPercTotal));
		}

		ClienteInsurance response = new ClienteInsurance();
		response.setName(cliente.getName());
		response.setInsurances(insurances);

		return response;
	}
}