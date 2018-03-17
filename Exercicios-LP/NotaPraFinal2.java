/* Crie uma classe que pe�a 3 notas pela JOPtionPane,
 * mostre a m�dia tamb�m pela JOPtionPane e caso a m�dia seja
 * menor que 7 e maior ou igual a 4, mostre pela JOPtionPane a nota necess�ria
 * para passar na prova final
 * 
 */
import javax.swing.JOptionPane;

public class NotaPraFinal2 {
	public static void main(String[] args) {
		double notaPraPassar;
		
		// Entrada das notas pelo usu�rio
		double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1� nota: "));
		double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2� nota: "));
		double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 3� nota: "));
		
		// C�lculo e impress�o da m�dia
		double media = (nota1 + nota2 + nota3) / 3;
		JOptionPane.showMessageDialog(null, "Sua m�dia foi: " + media);
		
		// Caso tenha m�dia menor que sete e maior que 4
		if (media >= 4 && media < 7) {
			notaPraPassar = (5 - 0.6 * media) / 0.4;
			JOptionPane.showMessageDialog(null, "Voc� precisa de " + notaPraPassar + " para passar na final.");
	
		}	
	}
}
