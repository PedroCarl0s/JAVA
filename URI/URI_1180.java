import java.util.Scanner;

public class URI_1180 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalDePosicoes = Integer.parseInt(input.nextLine());
		String numerosLidos[] = input.nextLine().split(" ");
		int valores[] = new int[totalDePosicoes];
		int menor, posicao = 0;

		for (int k = 0; k < totalDePosicoes; k++) {
			valores[k] = Integer.parseInt(numerosLidos[k]);
		}		

		menor = valores[0];

		for (int j = 1; j < totalDePosicoes; j++) {
			if (valores[j] < menor) {
				menor = valores[j]; 
				posicao = j;
			}
		}
		input.close();
		System.out.printf("Menor valor: %d\n", menor);
		System.out.printf("Posicao: %d\n", posicao);
		
	}
}