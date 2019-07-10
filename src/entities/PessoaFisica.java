package entities;

public class PessoaFisica extends Contribuintes{

	private Double gastoSaude;

	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public double impostoPago() {
		double tax = 0.0;
		
		if (getRendaAnual() < 20000.00) {
			tax = getRendaAnual() * 0.15;
		}
		else if (getRendaAnual() > 20000.00){
			tax = getRendaAnual() * 0.25;
		}//fim if TAXAS
		
		return tax - gastoSaude * 0.5;
	}	
}
