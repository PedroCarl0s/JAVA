import java.util.Scanner;

public class Media {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalDeNotas; 
		double somatorio = 0, nota, media;
		
		System.out.print("Deseja colocar quantas notas ?  ");
		totalDeNotas = input.nextInt();
		
		for (int k = 0; k < totalDeNotas; k++) {
			System.out.printf("Digite a %d� nota: ",k+1);
			nota = input.nextDouble();
			somatorio += nota;
			
		}
		media = (somatorio / totalDeNotas);
		System.out.printf("M�dia das notas: %.1f", media);
		input.close();
	}
}