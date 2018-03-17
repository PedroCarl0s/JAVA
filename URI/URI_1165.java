import java.util.Scanner;

public class URI_1165 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N;
		long X;
		boolean primo = true;
		N = input.nextInt();
		
		for (int k = 0; k < N; k++) {
			X = input.nextLong();
			primo = true;

			for (int j = 2; j < X; j++) {
				if (X % j  == 0) {
					primo = false;
					
				}
			}
			if (primo) {
				System.out.printf("%d eh primo\n",X);
			
			} else {
				System.out.printf("%d nao eh primo\n",X);
		    }	

 
		}
		input.close();
	}
}

