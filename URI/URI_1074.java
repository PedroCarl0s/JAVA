import java.util.Scanner;

public class URI_1074 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N, X, C;
		C = 0;
		N = input.nextInt();
		while (C < N){
			X = input.nextInt();
			if (X == 0) {
				System.out.println("NULL");
			
			} else if (X % 2 == 0){
				if (X < 0) {
					System.out.println("EVEN NEGATIVE");
					
				} else if (X > 0) {
					System.out.println("EVEN POSITIVE");
				}

			} else if (X % 2 != 0 ) {
				if (X < 0) {
					System.out.println("ODD NEGATIVE");
				
				} else if (X > 0) {
					System.out.println("ODD POSITIVE");
				}
			}
			C++;
		}
		input.close();
	}
}
