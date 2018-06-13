package br.ufpb.turismo;

public class AtrativoArtificial extends AtrativoTuristico {
    
    
    public AtrativoArtificial(String nome, double latitude, double longitude, String comoChegar, String site, String infoContato) {
        super(nome, latitude, longitude, comoChegar, site, infoContato);
    }
   
   public String getDescricao() {
        return "Atrativo Artificial: " + super.getNome()
            +"\nLatitude " + super.getLatitude() 
            +"\nLongitude: " + super.getLongitude()
            +"\nRota: " + super.getComoChegar()
            +"\nSite: " + super.getSite() 
            +"\nInformações para contato: " + super.getSite();   
    }
}