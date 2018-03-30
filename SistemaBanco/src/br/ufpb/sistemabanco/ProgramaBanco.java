package br.ufpb.sistemabanco;

import java.util.Scanner;

public class ProgramaBanco {
	
	public static void main(String[] args) {
		
		Conta c1 = new Conta("918.773.344-72", "60798255-7", "1756", 50.0);
		Conta c2 = new Conta("881.445.994-03", "43992886-6", "4636", 1000.0);
		
		// Tranferindo R$50 de c2 para c1
		c2.debitar(50);
		c1.creditar(50);
		
		// Saldo de c1
		System.out.println("Saldo de c1: R$" + c1.getSaldo());
		
		// Saldo de c2
		System.out.println("Saldo de c2: R$" + c2.getSaldo());
		
		// Vendo os dados das contas C1 e C2
		System.out.println("C1: " + c1.imprimeDados());
		System.out.println("C2: " + c2.imprimeDados());
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.print("Vamos criar sua conta ? Digite seu CPF: ");
		String cpf = input.nextLine();
		
		System.out.print("Insira o número da conta: ");
		String numConta = input.nextLine();
		
		System.out.print("Insira o número da agência: ");
		String numAgencia = input.nextLine();
		
		System.out.print("Insira o valor inicial: R$");
		double saldoInicial = Double.parseDouble(input.nextLine());
		
		Conta minhaConta = new Conta(cpf, numConta, numAgencia, saldoInicial);
		System.out.print("Conta criada com sucesso!\n");
		
		System.out.println("Minha Conta\n" + minhaConta.imprimeDados());
		
		Conta outraConta = new Conta();
		
		System.out.print("Vamos criar sua conta ? Digite seu CPF: ");
		outraConta.setCpfTitular(input.nextLine());
		
		System.out.print("Insira o número da conta: ");
		outraConta.setNumeroConta(input.nextLine());
		
		System.out.print("Insira o número da agência: ");
		outraConta.setNumeroAgencia(input.nextLine());
		
		System.out.print("Insira o valor inicial: R$");
		outraConta.setSaldo(Double.parseDouble(input.nextLine()));
		
		System.out.print("Conta criada com sucesso!\n");
		
		System.out.println("Outra Conta\n" + outraConta.imprimeDados());
		
		
	}
}
