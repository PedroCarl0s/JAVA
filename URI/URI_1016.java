import java.util.Scanner;

public class URI_1016 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int distancia, resultado = 0;

		distancia = input.nextInt();

		for (int k = distancia; k > 0; k--) {
			resultado += 2;

		}
		System.out.printf("%d minutos\n",resultado);

	}
}