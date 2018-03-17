import java.util.Scanner;

public class MultiplosDeN {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Insira o valor de n: ");
		int valor = input.nextInt();
		
		for (int k = 1; k <= 100; k++) {
			if (k % valor == 0) {
				System.out.println(k);
			}
		}
		input.close();
	}
}
