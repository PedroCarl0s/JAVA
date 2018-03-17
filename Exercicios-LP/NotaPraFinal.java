/* Crie uma classe que peça 3 notas pela JOPtionPane, imprima a média
 * e caso fique na prova final, mostre a nota que precisará para passar
 */

import javax.swing.JOptionPane;

public class NotaPraFinal {
	public static void main(String[] args) {
		// Imprimindo mensagem de Boas Vindas
		JOptionPane.showMessageDialog(null, "BEM-VINDO A CALCULADORA DE MÉDIAS!");
		//Somando as 3 notas e imprimindo a média
		double nota1 = Double.parseDouble(JOptionPane.showInputDialog("1ª nota: "));
		double nota2 = Double.parseDouble(JOptionPane.showInputDialog("2ª nota: "));
		double nota3 = Double.parseDouble(JOptionPane.showInputDialog("3ª nota: "));
		double media = (nota1 + nota2 + nota3) / 3;
		double notaPraPassar;

		System.out.println("Sua média foi: " + media);

		if (media >= 4 && media < 7) {
			notaPraPassar = (5 - 0.6 * media) / 0.4;
			System.out.println("Você precisa de " + notaPraPassar + " para passar na final.");

		}
	}
}
