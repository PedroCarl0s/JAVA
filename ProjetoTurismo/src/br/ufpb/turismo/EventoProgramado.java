package br.ufpb.turismo;


public class EventoProgramado extends AtrativoTuristico {
    
    private String dataInicio;
    private String dataFim;
    private String tipo;
    private Endereco endereco;
    
    private static final String TIPO_FESTA = "Festa";
    private static final String TIPO_FEIRA_GASTRONOMICA = "Feira";

   
    public EventoProgramado(String nome, String comoChegar, String site, String infoContato, String dataInicio,
            String dataFinal, String tipo, Endereco endereco) {
        
        super(nome, comoChegar, site, infoContato);
        this.dataInicio = dataInicio;
        this.dataFim = dataFinal;
        this.tipo = tipo;
        this.endereco = endereco;
    }
    
    // Getters and Setters
    public String getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public String getDataFim() {
        return this.dataFim;
    }
    
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getLogradouro() {
        return this.endereco.getLogradouro();
    }
    
    public String getNumeroLogradouro() {
        return this.endereco.getNumero();
    }
    
    public String getBairro() {
        return this.endereco.getBairro();
    }
    
    public String getDescricao() {
        return "Nome do Evento Programado: " + this.getNome() 
                +"\nData Inicial: " + this.getDataInicio() 
                +"\nData Fim: " + this.getDataFim() 
                +"\nTipo: " + this.getTipo() 
                +"\nLogradouro: " + this.endereco.getLogradouro() 
                +"\nNúmero: " + this.endereco.getNumero() 
                +"\nBairro: " + this.endereco.getBairro();
    }
    
}

