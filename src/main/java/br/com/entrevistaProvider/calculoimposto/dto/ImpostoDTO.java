package br.com.entrevistaProvider.calculoimposto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImpostoDTO {
	
	@JsonProperty("id_imposto")
	private String id;
	
	@JsonProperty("nome")
	private String nomePessoa;
	
	@JsonProperty("aliquotaImposto")
	private String aliquotaImposto;
	
	@JsonProperty("documento")
	private String documento;
	
	@JsonProperty("salario")
	private String salario;
	
	@JsonProperty("valor")
	private String valor;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getAliquotaImposto() {
		return aliquotaImposto;
	}

	public void setAliquotaImposto(String aliquotaImposto) {
		this.aliquotaImposto = aliquotaImposto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ImpostoDTO [id=" + id + ", nomePessoa=" + nomePessoa + ", aliquotaImposto=" + aliquotaImposto
				+ ", documento=" + documento + ", salario=" + salario + ", valor=" + valor + "]";
	}

}
