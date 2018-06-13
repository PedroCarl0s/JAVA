package br.ufpb.turismo;
import exception.AtrativoJaExisteException;
import exception.AtrativoNaoExisteException;
import exception.HospedagemJaExisteException;
import java.util.ArrayList;
import java.util.List;


public class Municipio {
    
    private String nome;
    private int populacao;
    private List<AtrativoTuristico> atrativoTuristico;
    private double latitude;
    private double longitude;
    private List<MeioDeHospedagem> meiosDeHospedagem;
    private String estado;
    private String site;
    
    
    public Municipio(String nome, int populacao, List<AtrativoTuristico> atrativoTuristico, double latitude,
        double longitude, List<MeioDeHospedagem> meiosDeHospedagem, String estado, String site) {
        
        this.nome = nome;
        this.populacao = populacao;
        this.atrativoTuristico = atrativoTuristico;
        this.latitude = latitude;
        this.longitude = longitude;
        this.meiosDeHospedagem = meiosDeHospedagem;
        this.estado = estado;
        this.site = site;   
    }
     
    public Municipio(String nome, int populacao, double latitude, double longitude, String estado, String site) {
        this(nome, populacao, new ArrayList<AtrativoTuristico>(), latitude, longitude, new ArrayList<MeioDeHospedagem>(), estado, site);
    }
    
   
    // Getters and Setters
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getPopulacao() {
        return this.populacao;
    }
    
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
    
    public List<AtrativoTuristico> getAtrativosTuristicos() {
        return this.atrativoTuristico;
    }
    
    public void setAtrativoTuristico(List<AtrativoTuristico> atrativosTuristicos) {
        this.atrativoTuristico = atrativosTuristicos;
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
    
    public List<MeioDeHospedagem> getMeiosDeHospedagem() {
        return this.meiosDeHospedagem;
    }
    
    public void setMeiosDeHospedagem(List<MeioDeHospedagem> meiosDeHospedagem) {
        this.meiosDeHospedagem = meiosDeHospedagem;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    public String getSite() {
        return this.site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }
    
    public String getDescricao() {
        return "Cidade: " + this.nome + "\nNúmero de Habitantes: " + this.populacao 
            + "\nAtrativos Turísticos: " + this.atrativoTuristico + "\nLatitude: " + this.latitude 
            + "\nLongitude: " + this.longitude + "\nMeios de Hospedagem: " + this.meiosDeHospedagem 
            + "\nEstado: " + this.estado + "\nSite: " + this.site;
    }
    
    // Methods
    public void cadastrarAtrativoTuristico(AtrativoTuristico atrativo) throws AtrativoJaExisteException {
        for (AtrativoTuristico x: this.atrativoTuristico) {
           if (((x.getNome().toUpperCase()).equals(atrativo.getNome().toUpperCase()))) {
               throw new AtrativoJaExisteException("O Atrativo " + atrativo.getNome() + " já existe!");
           }
        }
        this.atrativoTuristico.add(atrativo);
        
    }
       
    
    
    public AtrativoTuristico pesquisarAtrativoTuristico(String nomeAtrativo) throws AtrativoNaoExisteException {
        for (AtrativoTuristico x: this.atrativoTuristico) {
            if ((x.getNome().toUpperCase()).equals(nomeAtrativo.toUpperCase())) {
                return x;
            }
        }
        throw new AtrativoNaoExisteException("O Atrativo " + nomeAtrativo + " não existe!");
    }
    
    public void cadastraMeioDeHospedagem(MeioDeHospedagem meioHospedagem) throws HospedagemJaExisteException {
        for (MeioDeHospedagem meio: this.meiosDeHospedagem) {
            if ((meio.getNome().toUpperCase()).equals(meioHospedagem.getNome().toUpperCase())) {
                this.meiosDeHospedagem.add(meioHospedagem);
            }
        }
        throw new HospedagemJaExisteException("A Hospedagem " + meioHospedagem.getNome() + " já existe!");    
    }
    
}