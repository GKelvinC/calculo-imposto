package br.com.entrevistaProvider.calculoimposto.domain.model;


public enum TipoImposto {
	CNPJ(22.5),
	CPF(11.5);
	
	private double valor;
	
	TipoImposto(double d) {
		this.valor = d;
	}

	TipoImposto(){
	}
	
	
	public double getValor() {
		return valor;
	}
	
}
