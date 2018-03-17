/* Crie uma classe que peça 3 notas pela JOPtionPane,
 * mostre a média também pela JOPtionPane e caso a média seja
 * menor que 7 e maior ou igual a 4, mostre pela JOPtionPane a nota necessária
 * para passar na prova final
 * 
 */
import javax.swing.JOptionPane;

public class NotaPraFinal2 {
	public static void main(String[] args) {
		double notaPraPassar;
		
		// Entrada das notas pelo usuário
		double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1ª nota: "));
		double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2ª nota: "));
		double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 3ª nota: "));
		
		// Cálculo e impressão da média
		double media = (nota1 + nota2 + nota3) / 3;
		JOptionPane.showMessageDialog(null, "Sua média foi: " + media);
		
		// Caso tenha média menor que sete e maior que 4
		if (media >= 4 && media < 7) {
			notaPraPassar = (5 - 0.6 * media) / 0.4;
			JOptionPane.showMessageDialog(null, "Você precisa de " + notaPraPassar + " para passar na final.");
	
		}	
	}
}
