import java.math.BigDecimal;

public class ContaCorrente implements ContaBancaria {

	String cliente;
	String numeroConta;
	BigDecimal saldo;
	BigDecimal limite = new BigDecimal(400); //Deixei um limite padrao de 400 reais
	BigDecimal aux, aux2;
	
	public ContaCorrente(String cliente, String numeroConta, BigDecimal saldo) {
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

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	@Override
	public void sacar(BigDecimal valor) {
		if(saldo.compareTo(BigDecimal.ZERO) == 0) {
			if(limite.compareTo(valor) == 1 || limite.compareTo(valor) == 0) {
				limite = limite.subtract(valor);
			}
		}
		if(saldo.compareTo(valor) == -1 && saldo.compareTo(BigDecimal.ZERO) == 1) {
			aux = saldo.subtract(valor);
			aux.negate();
			aux2 = valor.subtract(aux);
			saldo = saldo.subtract(aux2);
			limite = limite.subtract(aux);	
		}
		if(saldo.compareTo(valor) == 1) {
			saldo = saldo.subtract(valor);
		}
	}

	@Override
	public void depositar(BigDecimal valor) {
		saldo = saldo.add(valor);
	}

}
