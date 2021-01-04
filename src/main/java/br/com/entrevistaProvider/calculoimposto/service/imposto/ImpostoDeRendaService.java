package br.com.entrevistaProvider.calculoimposto.service.imposto;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entrevistaProvider.calculoimposto.domain.model.ImpostoDeRenda;
import br.com.entrevistaProvider.calculoimposto.domain.repository.ImpostoDeRendaRepository;
import br.com.entrevistaProvider.calculoimposto.dto.ImpostoDTO;
import br.com.entrevistaProvider.calculoimposto.exception.ImpostoDTOException;
import br.com.entrevistaProvider.calculoimposto.exception.ImpostoNotFoundException;
import br.com.entrevistaProvider.calculoimposto.service.convert.ImpostoConversor;

@Service
public class ImpostoDeRendaService {
	
	private static final Logger LOG = Logger.getLogger(ImpostoDeRendaService.class);
	
	@Autowired
	private ImpostoDeRendaRepository impostoRepository;
	
	@Autowired
	private ImpostoConversor impostoConversor;
	
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
	
	public void cadastro(ImpostoDTO impostoDTO){
		
		ImpostoDeRenda impostoDeRenda;
		try {
			impostoDeRenda = impostoConversor.converterDTOtoEntity(impostoDTO);
			impostoDeRenda.calcularImposto(impostoDTO.getDocumento());
			impostoRepository.save(impostoDeRenda);
		} catch (ImpostoDTOException e) {
			LOG.error("Erro ao salvar o imposto: "+e.getMessage(),e);
		}
	}

	
	public void atualizarImposto(Long id,ImpostoDTO impostoDTO) throws ImpostoNotFoundException, ImpostoDTOException {
		var imposto = impostoRepository.findById(id);

		ImpostoDeRenda impostoDeRenda;
		if(!imposto.isPresent()){
			throw new ImpostoNotFoundException("Imposto Não encontrado através do ID:"+id);
		}else {
			impostoDTO.setId(null);
			impostoDTO.setAliquotaImposto(null);
			impostoDTO.setValor(null);
			impostoDeRenda = impostoConversor.converterDTOtoEntity(impostoDTO);
			impostoDeRenda.calcularImposto(impostoDTO.getDocumento());
			impostoDeRenda.setId(id);
			
			impostoRepository.save(impostoDeRenda);
		}
	}
	
	public void deletarPorId(Long id) throws ImpostoNotFoundException {
		var imposto = impostoRepository.findById(id);

		if(!imposto.isPresent()){
			throw new ImpostoNotFoundException("Imposto Não encontrado através do ID:"+id);
		}else {
			impostoRepository.deleteById(id);
		}
		
	}
	


}
