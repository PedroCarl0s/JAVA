import java.util.Scanner;

public class URI_1015 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] pontos = new String[2];
		double x1, x2, y1, y2, distancia;
		double resultado1, resultado2;

		pontos = input.nextLine().split(" ");
		x1 = Double.parseDouble(pontos[0]); 
		y1 = Double.parseDouble(pontos[1]);
		
		pontos = input.nextLine().split(" ");
		x2 = Double.parseDouble(pontos[0]); 
		y2 = Double.parseDouble(pontos[1]); 

		resultado1 = Math.pow(x2 - x1, 2);
		resultado2 = Math.pow(y2 - y1, 2);

		distancia = Math.sqrt((resultado1 + resultado2));
		
		System.out.printf("%.4f\n",distancia);


	}
}