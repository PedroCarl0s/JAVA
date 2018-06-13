package exception;

import javax.swing.JOptionPane;


public class MunicipioJaExisteException extends Exception {
    
    public MunicipioJaExisteException(String mensagemErro) {
        super(mensagemErro);
    }
    
    public MunicipioJaExisteException() {
        this("Erro: Município já existe");
    }
    
}
