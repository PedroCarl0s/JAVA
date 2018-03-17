import java.util.Scanner;

public class URI_1019 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tempoEmHoras, tempoEmMinutos, resto;

		int tempoEmSegundos = input.nextInt();

		tempoEmHoras = tempoEmSegundos / 3600;
		resto = tempoEmSegundos % 3600;

		tempoEmMinutos = resto / 60;
		resto = resto % 60;

		tempoEmSegundos = resto;

		System.out.printf("%d:%d:%d", tempoEmHoras, tempoEmMinutos, tempoEmSegundos);
	}
}