package br.com.entrevistaProvider.calculoimposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entrevistaProvider.calculoimposto.domain.model.ImpostoDeRenda;
import br.com.entrevistaProvider.calculoimposto.dto.ImpostoDTO;
import br.com.entrevistaProvider.calculoimposto.service.imposto.ImpostoDeRendaService;


@RestController
@RequestMapping("/calculo")
@CrossOrigin(origins="*")
public class CalculoController {
	
	
	@Autowired
	private ImpostoDeRendaService impostoService;
	
	
	@GetMapping("/")
	public List<ImpostoDeRenda> findAll(){
		return impostoService.buscarTodosOsImpostos();
	}
	
	@GetMapping("/{id}")
	public ImpostoDeRenda findById(@PathVariable(name="id",required=true) Long id) throws Exception{
		return impostoService.buscarPorId(id);
	}
	
	@PostMapping("/")
	public void saveImposto(@RequestBody ImpostoDTO imposto) {
		impostoService.cadastro(imposto);
	}

}
