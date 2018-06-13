package br.ufpb.turismo;

public abstract class AtrativoTuristico {
    
    private String nome;
    private double latitude;
    private double longitude;
    private String comoChegar;
    private String site;
    private String infoContato;
    
      
    // Construtor
    public AtrativoTuristico(String nome, double latitude, double longitude,
            String comoChegar, String site, String infoContato) {
        
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.comoChegar = comoChegar;
        this.site = site;
        this.infoContato = infoContato;
    }
    
    public AtrativoTuristico(String nome, String comoChegar, String site, String infoContato) {
        this.nome = nome;
        this.comoChegar = comoChegar;
        this.site = site;
        this.infoContato = infoContato;
        
    }
    
    // Métodos getters e setters
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public String getComoChegar() {
        return this.comoChegar;
    }
    
    public void setComoChegar(String comoChegar) {
        this.comoChegar = comoChegar;
    }
    
    public String getSite() {
        return this.site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }
    
    public String getInfoContato() {
        return this.infoContato;
    }
    
    public void setInfoContato(String infoContato) {
        this.infoContato = infoContato;
    }
    
    // Método getDescricao
    public abstract String getDescricao();
}
