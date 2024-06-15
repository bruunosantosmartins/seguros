package br.com.corretora.seguro.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.corretora.seguro.Service.CalculoSegurosService;
import br.com.corretora.seguro.model.Cliente;
import br.com.corretora.seguro.model.ClienteInsurance;

@RestController
public class SeguroController {

	private final CalculoSegurosService calculoSeguroService;

	public SeguroController(CalculoSegurosService calculoSeguroService) {
		this.calculoSeguroService = calculoSeguroService;
	}

	@PostMapping("/seguros")
	public ResponseEntity<?> calculateInsurance(@RequestBody Cliente cliente) {
		try {
			ClienteInsurance response = calculoSeguroService.calculoSeguro(cliente);
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error occurred");
		}
	}

}
