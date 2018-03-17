import java.util.Scanner;

public class URI_1018 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] quantidadeDeNotas = {0, 0, 0, 0, 0, 0, 0};
		int resultado, resto;

		int valorTotal = input.nextInt();
		resultado = valorTotal;

		quantidadeDeNotas[0] = resultado / 100;
		resto = resultado % 100;

		quantidadeDeNotas[1] = resto / 50;
		resto = resto % 50;

		quantidadeDeNotas[2] = resto / 20;
		resto = resto % 20;

		quantidadeDeNotas[3] = resto / 10;
		resto = resto % 10;

		quantidadeDeNotas[4] = resto / 5;
		resto = resto % 5;

		quantidadeDeNotas[5] = resto / 2;
		resto = resto % 2;

		quantidadeDeNotas[6] = resto;

		System.out.printf("%d\n", valorTotal);
		System.out.printf("%d nota(s) de R$ 100,00\n", quantidadeDeNotas[0]);
		System.out.printf("%d nota(s) de R$ 50,00\n", quantidadeDeNotas[1]);
		System.out.printf("%d nota(s) de R$ 20,00\n", quantidadeDeNotas[2]);
		System.out.printf("%d nota(s) de R$ 10,00\n", quantidadeDeNotas[3]);
		System.out.printf("%d nota(s) de R$ 5,00\n", quantidadeDeNotas[4]);
		System.out.printf("%d nota(s) de R$ 2,00\n", quantidadeDeNotas[5]);
		System.out.printf("%d nota(s) de R$ 1,00\n", quantidadeDeNotas[6]);

	}

}
