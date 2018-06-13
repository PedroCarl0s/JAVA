package exception;


public class AtrativoNaoExisteException extends Exception {
    
    public AtrativoNaoExisteException(String mensagemErro) {
        super(mensagemErro);
    }
    
    public AtrativoNaoExisteException() {
        this("Erro: Atrativo não existe");
    }
    
}
