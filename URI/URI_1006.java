import java.util.Scanner;

public class URI_1006 {
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double A, B, C, MD;
        A = input.nextDouble();
        B = input.nextDouble();
        C = input.nextDouble();
        MD = ((A * 2) + (B * 3) + (C * 5)) / 10;
        System.out.printf("MEDIA = %.1f\n",MD);
        
        input.close();
	}
}
