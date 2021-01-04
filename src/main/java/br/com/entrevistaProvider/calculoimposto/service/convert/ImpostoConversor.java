package br.com.entrevistaProvider.calculoimposto.service.convert;

import org.springframework.stereotype.Component;

import br.com.entrevistaProvider.calculoimposto.domain.model.ImpostoDeRenda;
import br.com.entrevistaProvider.calculoimposto.dto.ImpostoDTO;
import br.com.entrevistaProvider.calculoimposto.exception.ImpostoDTOException;


@Component
public class ImpostoConversor {

	public ImpostoDeRenda converterDTOtoEntity(ImpostoDTO impostoDTO) throws ImpostoDTOException{
		
		try {
			
			ImpostoDeRenda impostoDeRenda = new ImpostoDeRenda();
			
			Long idImposto =  checkIdImposto(impostoDTO.getId());
			Double salario = checkSalario(impostoDTO.getSalario());
			Double aliquota = checkAliquota(impostoDTO.getAliquotaImposto());
			Double valor = checkValor(impostoDTO.getValor());
			
			if(idImposto!=null) {
				impostoDeRenda.setId(idImposto);				
			}
			if(impostoDTO.getNomePessoa()!=null) {
				impostoDeRenda.setNomePessoa(impostoDTO.getNomePessoa());			
			}
			if(impostoDTO.getDocumento()!=null) {
				impostoDeRenda.setDocumento(impostoDTO.getDocumento());			
			}
			if(salario!=null) {
				impostoDeRenda.setSalario(salario);		
			}
			if(aliquota!=null) {
				impostoDeRenda.setAliquotaImposto(aliquota);
			}
			if(valor!=null) {
				impostoDeRenda.setAliquotaImposto(valor);
			}
			
			return impostoDeRenda;
			
		} catch (Exception e) {
			throw new ImpostoDTOException("Falha ao converter o dto para entidade, dto: "+impostoDTO);
		}
		
	}
	
	private Long checkIdImposto(String idImposto){
		if(idImposto != null) {
			return Long.parseLong(idImposto);	
		}else {
			return null;
		}
		
	}
	private Double checkSalario(String salario){
		if(salario != null) {
			return Double.parseDouble(salario);
		}else {
			return null;
		}
		
	}
	private Double checkAliquota(String aliquota){
		if(aliquota != null) {
			return Double.parseDouble(aliquota);
		}else {
			return null;
		}
	}
	private Double checkValor(String valor){
		if(valor != null) {
			return Double.parseDouble(valor);
		}else {
			return null;
		}
	}
}
