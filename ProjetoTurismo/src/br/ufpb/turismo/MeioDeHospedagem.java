package br.ufpb.turismo;

public class MeioDeHospedagem  {
    
    private String nome;
    private double latitude;
    private double longitude;
    private String infoContato;
    private String site;
    private String tipoHospedagem;
    private Endereco endereco;
    
    public static final String TIPO_HOTEL = "TipoHotel";
    public static final String TIPO_POUSADA = "TipoPousada";
    public static final String TIPO_ALBERGUE = "TipoAbergue";
    
    
    public MeioDeHospedagem(String nome, double latitude, double longitude, String infoContato,
            String site, String tipoHospedagem, Endereco endereco) {
        
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.infoContato = infoContato;
        this.site = site;
        this.tipoHospedagem = tipoHospedagem;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
    
    public double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public String getInfoContato() {
        return this.infoContato;
    }
    
    public void setInfoContato(String infoContato) {
        this.infoContato = infoContato;
    }
    
    public String getSite() {
        return this.site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }
    
    public String getTipoHospedagem() {
        return this.tipoHospedagem;
    }
    
    public Endereco getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String getDescricao() {
        return "Nome do meio de hospedagem: " + this.nome
        + "\nLatitude: " + this.latitude
        + "\nLongitude: " + this.longitude
        + "\nInformações para contato: " + this.infoContato
        + "\nSite: " + this.site
        + "\nTipo de Hospedagem: " + this.tipoHospedagem
        + "\nLogradouro: " + this.endereco.getLogradouro()
        + "\nNúmero: " + this.endereco.getNumero()
        + "\nBairro: " + this.endereco.getBairro();
    }
    
}