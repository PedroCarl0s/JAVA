import java.util.Scanner;

public class URI_1020 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int idadeEmAnos, idadeEmMeses, resto;

		int idadeEmDias = input.nextInt();

		idadeEmAnos = idadeEmDias / 365;
		resto = idadeEmDias % 365;

		idadeEmMeses = resto / 30;
		resto = resto % 30;

		idadeEmDias = resto;

		System.out.printf("%d ano(s)\n", idadeEmAnos);
		System.out.printf("%d mes(es)\n", idadeEmMeses);
		System.out.printf("%d dia(s)\n", idadeEmDias);
	} 
}