package br.ufpb.sistemabanco;

public class Conta {
	
	/* Atributos da conta em um banco
	 * cpfTitular
	 * numeroConta
	 * numeroAgencia
	 * saldo
	 */
	
	private String cpfTitular;
	private String numeroConta;
	private String numeroAgencia;
	private double saldo;
	
	// Criando o construtor
	public Conta(String cpfTitular, String numConta, String numAgencia, double saldo) {
		this.cpfTitular = cpfTitular;
		this.numeroConta = numConta;
		this.numeroAgencia = numAgencia;
		this.saldo = saldo;
	}
	
	
	// Construtor com parâmetros pré-definidos
	public Conta() {
		this.cpfTitular = "Vazio";
		this.numeroConta = "S/N";
		this.numeroAgencia = "S/N";
		this.saldo = 0.0;
	}
	
	
	// Criando método que imprime os dados formatadamente
	public String imprimeDados() {
		return "CPF: " + this.cpfTitular + "\nNº da Conta: " + this.numeroConta +  "\nNº da Agência: " + 
				this.numeroAgencia + "\nSaldo: R$" + this.saldo;
				  
	}
	
	
	// Criando alguns métodos que trabalham com valores
	public double creditar(double valor) {
		this.saldo += valor;
		return this.saldo;
	}
	
	
	public double debitar(double valor) {
		this.saldo-= valor;
		return this.saldo;
	}
	
	
	// Criando os métodos get's() e set's()
	public String getCpfTitular() {
		return this.cpfTitular;
	}
	
	public void setCpfTitular(String cpf) {
		this.cpfTitular = cpf;
	}
	
	
	public String getNumeroConta() {
		return this.numeroConta;
	}
	
	public void setNumeroConta(String novoNumero) {
		this.numeroConta = novoNumero;
	}
	
	
	public String getNumeroAgencia() {
		return this.numeroAgencia;
	}
	
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}
	
}
