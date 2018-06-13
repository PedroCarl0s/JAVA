package exception;


public class MunicipioNaoExisteException extends Exception {
    
    public MunicipioNaoExisteException(String mensagemErro) {
        super(mensagemErro);
    }
    
    public MunicipioNaoExisteException() {
        this("Erro: Município não existe");
    }
    
}
