package br.com.entrevistaProvider.calculoimposto.domain.model;

import javax.persistence.*;

@Entity
@Table(name="imposto")
public class ImpostoDeRenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	protected Long id;
	
	@Column(name="nome_pessoa")
	protected String nomePessoa;
	
	@Column(name="documento")
	protected String documento;
	
	@Column(name="salario")
	protected double salario;
	
	@Column(name="aliquota")
	protected double aliquotaImposto;
	
	@Column(name="valor_imposto")
	protected double valorImposto;
	

	public ImpostoDeRenda() {
		super();
	}

	public double calcularImposto(String tipoImposto){
		
		TipoImposto tipo = (Enum.valueOf(TipoImposto.class,tipoImposto));
		double aliquota = tipo.getValor();
		this.aliquotaImposto = aliquota;
		
		var valorImposto = (this.salario * this.aliquotaImposto)/100;
		this.valorImposto = valorImposto;
		
		return valorImposto;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomePessoa() {
		return nomePessoa;
	}


	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public double getAliquotaImposto() {
		return aliquotaImposto;
	}


	public void setAliquotaImposto(double aliquotaImposto) {
		this.aliquotaImposto = aliquotaImposto;
	}


	public double getValorImposto() {
		return valorImposto;
	}


	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

}
