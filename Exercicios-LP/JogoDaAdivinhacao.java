
import javax.swing.JOptionPane;

public class JogoDaAdivinhacao {

  public static int verificaValor(int valor) {
    while (valor < 0 || valor > 100) {
        valor = Integer.parseInt(JOptionPane.showInputDialog("ATENÇÃO: INSIRA SOMENTE VALORES ENTRE 0 E 100 \n Insira um novo número: "));

    }
    return valor;

  }

  public static void main(String[] args) {
    boolean adivinhar = true;
    int valorLido, totalDeErros = 0, totalDePontos = 100;

    int valorMisterio = Integer.parseInt(JOptionPane.showInputDialog("\tJOGADOR 1: \nInsira um número entre 0 e 100: "));
    valorMisterio = verificaValor(valorMisterio);

    while (adivinhar) {
      valorLido = Integer.parseInt(JOptionPane.showInputDialog("Jogador 2:\n Tente adivinhar o valor: "));
      valorLido = verificaValor(valorLido);

      if (valorLido == valorMisterio) {
        adivinhar = false;
        JOptionPane.showMessageDialog(null, "Parabéns, vocẽ ganhou! \n Total de Erros: " + totalDeErros + "\n Total de Pontos: " + totalDePontos);
      
      } else {
        if (valorLido < valorMisterio) {
          totalDeErros++; totalDePontos--;
          JOptionPane.showMessageDialog(null, "Ops, você errou! \n DICA: O valor que você digitou é menor que o valor a ser adivinhado");
        
        } else {
          totalDeErros++; totalDePontos--;
          JOptionPane.showMessageDialog(null, "Ops, você errou! \n DICA: O valor que vocẽ digitou é maior que o valor a ser adivinhado");
        }

      }

    }

  }
  
}