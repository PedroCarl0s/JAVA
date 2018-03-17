import java.util.Scanner;

public class URI_1001 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A,B,X;
        
        A = input.nextInt();
        B = input.nextInt();
        X = (A+B);
        System.out.printf("X = %d\n", X);
     
    input.close();
	}
}
