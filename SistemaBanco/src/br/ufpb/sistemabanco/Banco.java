package br.ufpb.sistemabanco;

public class Banco {
	
	private String nomeBanco;
	private String cnpj;
	private Conta[] contas;
	private int maxContas;
	
	public Banco() {
		this.nomeBanco = "";
		this.cnpj = "";
		this.maxContas = 1000;
		this.contas = new Conta[maxContas];
	}
	
	public Banco(String nome, String cnpj, Conta[] contas) {
		this.nomeBanco = nome;
		this.cnpj = cnpj;
		this.contas = contas;
		this.maxContas = contas.length;
	}
	
	
	public String imprimeDados() {
		return "Nome Banco: " + this.nomeBanco 
				+ "\nCNPJ: " + this.cnpj;
	}

	/* Tranferências entre contas do mesmo banco
	* saldo disponível, agência, conta, data, valor
	*/
	
	/* Tranferências entre contas de bancos diferentes
	 * saldo disponivel, banco, agẽncia, conta, valor, data, valor
	 * 
	 */
	
	// Depósito
	// Saque
	

}
