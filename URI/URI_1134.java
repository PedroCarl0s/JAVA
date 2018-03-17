import java.util.Scanner;

public class URI_1134 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tipo, alcool = 0, gasolina = 0, diesel = 0;
		tipo = 0;
		
		while (tipo != 4) {
			tipo = input.nextInt();
			if (tipo == 1) {
				alcool++;
				
			} else if (tipo == 2) {
				gasolina++;
				
			} else if (tipo == 3) {
				diesel++;
			}
			
		}	
		input.close();
		System.out.print("MUITO OBRIGADO\n");
		System.out.printf("Alcool: %d\n",alcool);
		System.out.printf("Gasolina: %d\n",gasolina);
		System.out.printf("Diesel: %d\n",diesel);
	}
}
