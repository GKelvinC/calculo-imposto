package br.com.entrevistaProvider.calculoimposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entrevistaProvider.calculoimposto.domain.model.ImpostoDeRenda;
import br.com.entrevistaProvider.calculoimposto.dto.ImpostoDTO;
import br.com.entrevistaProvider.calculoimposto.exception.ImpostoNotFoundException;
import br.com.entrevistaProvider.calculoimposto.service.imposto.ImpostoDeRendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/calculo")
@Api(value="API REST Calculo Imposto")
@CrossOrigin(origins="*")
public class CalculoController {
	
	
	@Autowired
	private ImpostoDeRendaService impostoService;
	
	
	@GetMapping("/")
	@ApiOperation(value = "Retorna a lista de Impostos Já Calculados")
	public List<ImpostoDeRenda> findAll(){
		return impostoService.buscarTodosOsImpostos();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um imposto já calculado")
	public ImpostoDeRenda findById(@PathVariable(name="id",required=true) Long id) throws Exception{
		return impostoService.buscarPorId(id);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Calcula um novo imposto")
	public void saveImposto(@RequestBody ImpostoDTO imposto) {
		impostoService.cadastro(imposto);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um imposto já calculado")
	public void updateImposto(@PathVariable(name="id",required=true) Long id,@RequestBody ImpostoDTO impostoDTO) throws Exception {
		impostoService.atualizarImposto(id, impostoDTO);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um imposto já calculado")
	public void deleteImposto(@PathVariable(name="id",required=true) Long id) throws ImpostoNotFoundException {
		impostoService.deletarPorId(id);
	}

}
