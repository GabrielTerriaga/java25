package entities;

public class PessoaJuridica extends Contribuintes{

	private Integer numeroFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public double impostoPago() {
		double tax = 0.0;
		
		if (numeroFuncionarios > 10) {
			tax = getRendaAnual() * 0.14;
		}
		else {
			tax = getRendaAnual() * 0.1;
		}//fim if TAXAS
		
		return tax;
	}
}
