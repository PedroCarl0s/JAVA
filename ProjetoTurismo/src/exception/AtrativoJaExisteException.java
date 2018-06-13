package exception;


public class AtrativoJaExisteException extends Exception {
    
    public AtrativoJaExisteException(String mensagemErro) {
        super(mensagemErro);
    }
    
    public AtrativoJaExisteException() {
        this("Erro: Atrativo já existe");
    }
}
