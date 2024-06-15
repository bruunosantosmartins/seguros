package br.com.corretora.seguro.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.corretora.seguro.model.Cliente;
import br.com.corretora.seguro.model.ClienteInsurance;
import br.com.corretora.seguro.model.Insurances;

public class CalculoSegurosServiceTest {

	@Mock
    private Cliente mockCliente;

    @InjectMocks
    private CalculoSegurosService serviceUnderTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateInsurance_BasicInsurance() {
        when(mockCliente.getValor_veiculo()).thenReturn(50000.0);
        when(mockCliente.getAge()).thenReturn(30);
        when(mockCliente.getLocation()).thenReturn("SP");
        ClienteInsurance response = serviceUnderTest.calculoSeguro(mockCliente);
        List<Insurances> insurances = response.getInsurances();

        assertEquals(1, insurances.size());
        assertEquals("basic", insurances.get(0).getType());
        assertEquals(1000, insurances.get(0).getCost());
    }

    @Test
    public void testCalculateInsurance_ParcialInsurance() {
        when(mockCliente.getValor_veiculo()).thenReturn(80000.0);
        when(mockCliente.getAge()).thenReturn(25);
        when(mockCliente.getLocation()).thenReturn("SP");
        ClienteInsurance response = serviceUnderTest.calculoSeguro(mockCliente);
        List<Insurances> insurances = response.getInsurances();

        assertEquals(2, insurances.size());
        assertEquals("parcial", insurances.get(1).getType());
        assertEquals(2400, insurances.get(1).getCost());
    }

    @Test
    public void testCalculateInsurance_TotalInsurance() {
        when(mockCliente.getValor_veiculo()).thenReturn(120000.0);
        when(mockCliente.getAge()).thenReturn(25);
        when(mockCliente.getLocation()).thenReturn("SP");
        ClienteInsurance response = serviceUnderTest.calculoSeguro(mockCliente);
        List<Insurances> insurances = response.getInsurances();

        assertEquals(3, insurances.size());
        assertEquals("total", insurances.get(2).getType());
        assertEquals(4800, insurances.get(2).getCost());
    }
}