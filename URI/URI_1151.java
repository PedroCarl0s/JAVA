import java.util.Scanner;

public class URI_1151 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int entrada, ultimo=1, penultimo=0, proxFibonacci=0, aux,aux2;
		String espaco = " ";
		entrada = input.nextInt();
		
		for (int k = 0; k < entrada; k++) {
			aux2 = (k+1);
			proxFibonacci = ultimo + penultimo;
			if (aux2 == entrada) {
				espaco = "";
			}
			System.out.print(penultimo + espaco);
			aux = ultimo;
			penultimo = aux;
			ultimo = proxFibonacci;
		}
		System.out.print("\n");
		input.close();
	}
}
