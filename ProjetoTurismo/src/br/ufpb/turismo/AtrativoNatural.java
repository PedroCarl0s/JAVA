package br.ufpb.turismo;

public class AtrativoNatural extends AtrativoTuristico {
    
    public AtrativoNatural (String nome, double latitude, double longitude,String comoChegar, String site, String infoContato) {
        super(nome, latitude, longitude, comoChegar, site, infoContato);    
    }
    
    public String getDescricao() {
        return "Nome do Atrativo Natural: " + super.getNome() + 
            "\nLatitude: " + super.getLatitude() + "\nLongitude: " + super.getLongitude() +
            "\nComo chegar: " + super.getComoChegar() + 
            "\nSite: " + super.getSite() + "\nInformações para contato: " + super.getSite(); 
        
    }
}
