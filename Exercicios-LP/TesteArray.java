import javax.swing.JOptionPane;

public class TesteArray {

	public static void main(String[] args) {
		int quantidadeDeNomes = 3;
		String nomes[] = new String[3];

		for (int k = 0; k < quantidadeDeNomes; k++) {
			nomes[k] = JOptionPane.showInputDialog("Digite um nome: ");
		}
		JOptionPane.showMessageDialog(null, "O primeiro nome foi: " + nomes[0]);
		JOptionPane.showMessageDialog(null, "O último nome foi: " + nomes[nomes.length-1]);
	} 
}