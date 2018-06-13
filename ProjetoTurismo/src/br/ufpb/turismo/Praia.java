package br.ufpb.turismo;


public class Praia extends AtrativoNatural {
    
    private boolean perigoTubarao;
    private String tipoOnda;
    private boolean marAberto;
    private boolean propriaParaBanho;
    private String tipoDeOrla;
    
    public static final String TIPO_MAR_ABERTO = "Mar Aberto";
    public static final String TIPO_MAR_FECHADO = "Mar Fechado";
    public static final String TIPO_MAR_ABRIGADO = "Mar Abrigado";
    public static final String TIPO_PISCINAS_NATURAIS = "Piscinas Naturais";
    public static final String TIPO_ONDAS_FORTES = "Ondas Fortes";
    public static final String TIPO_ONDAS_MEDIAS = "Ondas Médias";
    public static final String TIPO_ONDAS_FRACAS = "Ondas Fracas";
    
     
    public Praia(String nome, double latitude, double longitude, String comoChegar, String site, String infoContato, 
            boolean perigoTubarao, String tipoOnda, boolean marAberto, boolean propriaParaBanho, String tipoOrla) {
        
        super(nome, latitude, longitude, comoChegar, site, infoContato);
        this.perigoTubarao = perigoTubarao;
        this.tipoOnda = tipoOnda;
        this.marAberto = marAberto;
        this.propriaParaBanho = propriaParaBanho;
        this.tipoDeOrla = tipoOrla;   
    }
    
    public boolean getPerigoTubarao() {
        return this.perigoTubarao;
    }
    
    public void setPerigoTubarao(boolean perigoTubarao) {
        this.perigoTubarao = perigoTubarao;
    }
    
    public String getTipoOnda() {
        return this.tipoOnda;
    }
    
    public void setTipoOnda(String tipoOnda) {
        this.tipoOnda = tipoOnda;
    }
    
    public boolean getMarAberto() {
        return this.marAberto;
    }
    
    public void setMarAberto(boolean marAberto) {
        this.marAberto = marAberto;
    }
    
    public boolean getPropriaParaBanho() {
        return this.propriaParaBanho;
    }
    
    public void setPropriaParaBanho(boolean propriaParaBanho) {    
        this.propriaParaBanho = propriaParaBanho;
    }
    
    public String getTipoDeOrla() {
        return this.tipoDeOrla;
    }
    
    public void setTipoDeOrla(String tipoDeOrla) {
        this.tipoDeOrla = tipoDeOrla;
    }
    
    
    public String BooleanToString(boolean valorVerdade) {
        if (valorVerdade == true) {
            return "Sim";
        
        } else {
            return "Não";
        } 
    }
    
    public String getDescricao() {
        return "Nome da Praia: " + super.getNome() 
            +"\nÉ própria para banho ? " + BooleanToString(propriaParaBanho)
            +"\nPossui riscos de tubarão ? " + BooleanToString(perigoTubarao)
            +"\nÉ de Mar Aberto ? " + BooleanToString(marAberto)
            +"\nTipo de Orla: " + this.getTipoDeOrla()
            +"\nTipo de Onda: " + this.getTipoOnda()
            +"\nLatitude " + super.getLatitude() 
            +"\nLongitude: " + super.getLongitude()
            +"\nComo chegar: " + super.getComoChegar() 
            +"\nSite: " + super.getSite() 
            +"\nInformações para contato: " + super.getInfoContato();    
    }
}
