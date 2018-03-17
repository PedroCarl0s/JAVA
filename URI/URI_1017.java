import java.util.Scanner;

public class URI_1017 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tempoGasto, velocidadeMedia, espacoPercorrido;
		double totalDeLitros;

		tempoGasto = input.nextInt();
		velocidadeMedia = input.nextInt();

		espacoPercorrido = tempoGasto * velocidadeMedia;
		totalDeLitros = espacoPercorrido / 12.0;

		System.out.printf("%.3f\n", totalDeLitros);

	}
}