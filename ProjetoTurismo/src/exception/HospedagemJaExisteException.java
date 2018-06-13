package exception;


public class HospedagemJaExisteException extends Exception {
    
    public HospedagemJaExisteException(String mensagemErro) {
        super(mensagemErro);
    }
    
    public HospedagemJaExisteException() {
        this("Erro: A Hospedagem já existe!");
    }
}
