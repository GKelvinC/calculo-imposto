package br.com.entrevistaProvider.calculoimposto.service.imposto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.entrevistaProvider.calculoimposto.domain.model.ImpostoDeRenda;
import br.com.entrevistaProvider.calculoimposto.exception.ImpostoNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ImpostoDeRendaServiceTest {

	@Autowired
	private ImpostoDeRendaService impostoService;
	
	@Test
	public void buscarPorIdTest() throws ImpostoNotFoundException{
		ImpostoDeRenda imposto = impostoService.buscarPorId(1L);
		assertEquals(Long.parseLong("1"),imposto.getId());
		assertEquals("Kelvin Gonçalves",imposto.getNomePessoa());
		assertEquals("CPF",imposto.getDocumento());
		assertEquals(Double.parseDouble("1000"),imposto.getSalario());
		assertEquals(Double.parseDouble("22.5"),imposto.getAliquotaImposto());
		assertEquals(Double.parseDouble("300"),imposto.getValorImposto());
	}
}
