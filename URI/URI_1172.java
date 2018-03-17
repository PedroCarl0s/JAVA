import java.util.Scanner;

public class URI_1172 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int valores[] = new int[10];

		for (int k = 0; k < valores.length; k++) {
			valores[k] = Integer.parseInt(input.nextLine());

			if (valores[k] <= 0) {
				valores[k] = 1;
			}
			System.out.printf("X[%d] = %d\n", valores[k], valores[k]);
		}
		input.close();

	}
}
