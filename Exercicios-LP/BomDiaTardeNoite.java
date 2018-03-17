import javax.swing.JOptionPane;

public class BomDiaTardeNoite {
	
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Qual seu nome ? ");
		JOptionPane.showMessageDialog(null, "Olá " + nome);
		String horasString = JOptionPane.showInputDialog("Que horas são ? ");
		
		int horas = Integer.parseInt(horasString);
		
		if (horas >= 0 && horas < 5){
			JOptionPane.showMessageDialog(null, "Boa madrugada!");

		} else if (horas > 5 && horas <= 12){
			JOptionPane.showMessageDialog(null, "Bom dia!");
		
		} else if (horas > 12 && horas <= 18){
			JOptionPane.showMessageDialog(null, "Boa tarde!");
			
		} else if (horas > 18 && horas <= 23){
			JOptionPane.showMessageDialog(null, "Boa noite!");
			
		} else {
			JOptionPane.showMessageDialog(null, "Hora inválida!");
			
		}
	}
}