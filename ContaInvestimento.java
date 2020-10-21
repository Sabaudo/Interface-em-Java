import java.math.BigDecimal;

public class ContaInvestimento implements ContaBancaria, Tributavel {
	
	String cliente;
	String numeroConta;
	BigDecimal saldo;
	
	@Override
	public BigDecimal calcularTributo(BigDecimal taxaRendimento) {
		BigDecimal m = taxaRendimento.multiply(saldo);
		BigDecimal taxaTributo = new BigDecimal(0.005);
		return taxaTributo.multiply(m);
	}

	
	public ContaInvestimento(String cliente, String numeroConta, BigDecimal saldo) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public void sacar(BigDecimal valor) {
		if(saldo.compareTo(valor) == 1 || saldo.compareTo(valor) == 0) {
			saldo = saldo.subtract(valor);
		}
	}

	@Override
	public void depositar(BigDecimal valor) {
		saldo = saldo.add(valor);
	}
	
	public void calcularNovoSaldo(BigDecimal taxaRendimento) {
		BigDecimal m = taxaRendimento.multiply(saldo);
		saldo = saldo.add(m);
	}
	
	public BigDecimal calcularTaxaAdministracao(BigDecimal taxaRendimento) {
		BigDecimal m = taxaRendimento.multiply(saldo);
		BigDecimal taxaAdm = new BigDecimal(0.01);
		return taxaAdm.multiply(m);
	}
	
}
