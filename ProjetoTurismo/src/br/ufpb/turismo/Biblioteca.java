package br.ufpb.turismo;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Biblioteca {
    
    /** 
     * @author Pedro Carlos
     * 
     * Método que retorna uma lista contendo os nomes 
     * dos municípios cadastrados que serão usados na ComboBox, 
     * e existe uma opção padrão seleciona chamada "SELECIONE"
     * 
     * @param areaDeInteresse - Área de interesse turístico criada
     * @return String[] AreaDeInteresseTuristico - Array contendo os nomes dos municípios cadastrados
     * para serem usados na ComboBox do Menu
     */
    public static String[] retornaMunicipios(AreaDeInteresseTuristico areaDeInteresse) { 
        List<Municipio> municipio = areaDeInteresse.getMunicipios();
        
        // A lista possui uma posição a mais para poder inserir a opção padrão "SELECIONE"
        String[] lista = new String[areaDeInteresse.getMunicipios().size()+1];
        
        // O primeiro índice da lista é a opção padrão "SELECIONE"
        lista[0] = "SELECIONE";        
        
        // O início da varredura começa do segundo índice da lista, pois o primeiro é ocupado pela opção padrão "SELECIONE"
        int contador = 1;
        
        for (Municipio x : areaDeInteresse.getMunicipios()) {
            lista[contador] = x.getNome();
            contador++;
        }
        return lista;
    }
    
   
    /** 
     * @author Pedro Carlos
     * 
     * Método que pede uma entrada ao usuário, e caso ele deixe 
     * o campo em branco, será pedida outra entrada até que ela 
     * contenha algum conteúdo diferente de vazio
     * 
     * @param mensagem - Mensagem que será mostrada ao usuário para pedir o que ele deverá digitar
     * @exception NullPointerException - Caso o usuário selecione cancelar ou fechar a JOptionPane, a variável entrada irá ser do tipo "null" e o programa finaliza
     * @return String - O retorno será a resposta do usuário
     */
    public static String corrigeCampoVazio(String mensagem) {
        String entrada = JOptionPane.showInputDialog(mensagem);
        
        try {
            while (entrada.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo não pode ficar vazio! Insira novamente");
                entrada = JOptionPane.showInputDialog(mensagem);
            }
        
        } catch (NullPointerException erro) {
            JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!");
            System.exit(0);
        }
        
        return entrada;
    }
    
    
    /**
     * @author Pedro Carlos
     * 
     * Método que pede que o usuário selecione uma opção da ComboBox,
     * e caso ele deixe a opção padrão chamada "SELECIONE", será pedido
     * que ele selecione uma opção válida
     * 
     * @param frame - JFrame para que apareça a janelinha da ComboBox
     * @param mensagemErro - Mensagem que será mostrada caso o usuário não selecione nenhuma opção
     * @param tituloJanela - Título da JFrame
     * @param mensagemEntrada - Mensagem que será mostrada ao usuário para que escolha uma opção
     * @param lista - Um Array contendo os nomes dos municípios a serem mostrados na ComboBox
     * @exception NullPointerException - Caso o usuário selecione cancelar ou fechar a ComboBox, a variável seleção irá ser do tipo "null" e o programa finaliza
     * @return String - Nome do município selecionado da ComboBox
     */
    public static String selecaoComboBox(JFrame frame, String mensagemErro, String tituloJanela, String mensagemEntrada, String[] lista) {
        String selecao = (String) JOptionPane.showInputDialog(frame, mensagemEntrada, tituloJanela, 
            JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]);
        
        try {
            while (selecao.equals("SELECIONE")) {
                JOptionPane.showMessageDialog(null, mensagemErro);
                selecao = (String) JOptionPane.showInputDialog(frame, mensagemEntrada, tituloJanela, 
                JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]); 
            }
            
        } catch (NullPointerException erro) {
            JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!");
            System.exit(0);
        }
        
        return selecao;
    }
    
    
    /**
     * @author Pedro Carlos
     * 
     * Método que abre mostra uma mensagem de erro caso não existam municípios cadastrados,
     * e o usuário tente cadastrar ou listar algo que necessite do nome de um município
     */
    public static void MensagemErro() {
        JOptionPane.showMessageDialog(null, "Não existem municípios cadastrados!");
    }
    
    
    /** 
     * @author Pedro Carlos
     * 
     * Método que pede uma entrada ao usuário, e caso ele deixe 
     * o campo em branco, será requisitada outra entrada até que ela 
     * contenha algum conteúdo diferente de vazio. Em seguida
     * irá ser realizada a conversão de String para Inteiro, e
     * caso exista erro de conversão ele irá pedir outra entrada
     * até que a mesma seja do tipo inteiro e sem campo vazio
     * 
     * @param mensagem - Mensagem que será mostrada ao usuário para pedir o que ele deverá digitar
     * @exception NullPointerException - Caso o usuário selecione cancelar ou fechar a JOptionPane, a variável entrada irá ser do tipo "null" e o programa finaliza
     * @exception NumberFormatException - Caso o usuário deixe o campo em branco ou insira letras, ocorrerá erro de conversão
     * @return int - O retorno será um valor inteiro a ser utilizado no número de habitantes no Menu
     */
    public static int conversaoInteira(String mensagem) {
        int valorConvertido = 0;
        boolean erro = true;
        boolean campoVazio = false;
        
        while (erro) {
            
            String entrada = JOptionPane.showInputDialog(mensagem);
            if (entrada.isEmpty()) {
                campoVazio = true;
                
            } else {
                campoVazio = false;
            }

            try {
                valorConvertido = Integer.parseInt(entrada);
                erro = false;

            } catch (NumberFormatException e) {
                if (campoVazio == true) {
                    JOptionPane.showMessageDialog(null, "O campo não pode ficar vazio! Insira novamente");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Insira somente números!");
                }
            
            } catch (NullPointerException e) {
                System.exit(0);
                JOptionPane.showMessageDialog(null, "O programa foi finalizado com sucesso!"); 
            }
        }
        return valorConvertido;
    }
    
     /** 
     * @author Pedro Carlos
     * 
     * Método que pede uma entrada ao usuário, e caso ele deixe 
     * o campo em branco, será requisitada outra entrada até que ela 
     * contenha algum conteúdo diferente de vazio. Em seguida
     * irá ser realizada a conversão de String para double, e
     * caso exista erro de conversão ele irá pedir outra entrada
     * até que a mesma seja do tipo double e sem campo vazio
     * 
     * @param mensagem - Mensagem que será mostrada ao usuário para pedir o que ele deverá digitar
     * @exception NullPointerException - Caso o usuário selecione cancelar ou fechar a JOptionPane, a variável entrada irá ser do tipo "null" e o programa finaliza
     * @exception NumberFormatException - Caso o usuário deixe o campo em branco ou insira letras, ocorrerá erro de conversão
     * @return double - O retorno será um valor double a ser utilizado na latitude e longitude no Menu
     */
    public static double conversaoDouble(String mensagem) {
        double valorConvertido = 0.0;
        boolean campoVazio = true;
        boolean erro = true;
        
        while (erro) {
            String entrada = JOptionPane.showInputDialog(mensagem);
            if (entrada.isEmpty()) {
                campoVazio = true;
            
            } else {
                campoVazio = false;
            }
        
            try {
                valorConvertido = Double.parseDouble(entrada);
                erro = false;
            
            } catch (NumberFormatException e) {
                if (campoVazio == true ){
                    JOptionPane.showMessageDialog(null, "O campo não pode ficar vazio! Insira novamente");
                
                } else {
                    JOptionPane.showMessageDialog(null, "Insira somente números!");
                }
                
            } catch (NullPointerException e) {
                System.exit(0);
                JOptionPane.showMessageDialog(null, "Programa finalizado com sucesso!");
            }
        }
        return valorConvertido;
    }
    
    
}
