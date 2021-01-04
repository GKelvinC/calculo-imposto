package br.com.entrevistaProvider.calculoimposto.service.imposto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entrevistaProvider.calculoimposto.domain.model.ImpostoDeRenda;
import br.com.entrevistaProvider.calculoimposto.domain.repository.ImpostoDeRendaRepository;
import br.com.entrevistaProvider.calculoimposto.exception.ImpostoNotFoundException;

@Service
public class ImpostoDeRendaService {
	
	@Autowired
	private ImpostoDeRendaRepository impostoRepository;
	
	
	public List<ImpostoDeRenda> buscarTodosOsImpostos(){
		List<ImpostoDeRenda> listImpostos = impostoRepository.findAll();
		return listImpostos;	
	}
	

	public ImpostoDeRenda buscarPorId(Long id) throws ImpostoNotFoundException{
		var imposto = impostoRepository.findById(id);
		
		ImpostoDeRenda impostoDeRenda = null;
		if(!imposto.isPresent()){
			throw new ImpostoNotFoundException("Imposto Não encontrado através do ID:"+id);
		}else {
			impostoDeRenda = imposto.get();
		}
		return impostoDeRenda;
	}
	

}
