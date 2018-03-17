import java.util.Scanner;

public class URI_1009 {
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	String nome;
	double salarioFixo, totalDeVendas, salarioTotal;
	
	nome = input.next();
	salarioFixo = input.nextDouble();
	totalDeVendas = input.nextDouble();
	salarioTotal = salarioFixo + (totalDeVendas * 0.15);
	System.out.printf("TOTAL = R$ %.2f\n",salarioTotal);
	
	input.close();
	}
}
