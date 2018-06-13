package br.ufpb.turismo;

import exception.AtrativoJaExisteException;
import exception.MunicipioJaExisteException;
import exception.MunicipioNaoExisteException;
import java.util.ArrayList;
import java.util.List;

public class AreaDeInteresseTuristico {
    
    private List<Municipio> municipios;
    private String nome;
    
    public AreaDeInteresseTuristico(String nome, List<Municipio> municipios) {
        this.nome = nome;
        this.municipios = municipios;
    }
    
    public AreaDeInteresseTuristico(String nome) {
        this(nome, new ArrayList<Municipio>());
    }
    
    public String getNome() {
        return this.nome;
    }
    
    
    public void cadastrarMunicipio(Municipio municipio) throws MunicipioJaExisteException, MunicipioNaoExisteException {
        boolean existe = false;
        
        for (Municipio m: this.municipios) {
            if ((m.getNome().toUpperCase()).equals(municipio.getNome().toUpperCase())) {
                existe = true;
                break;
            } 
        }
        
        if (!existe) {
            this.municipios.add(municipio);
        
        } else {
            throw new MunicipioJaExisteException("Já existe um município com o nome " + municipio + "!");
            
        }
       
    }
    
    public List<Municipio> getMunicipios() {
        return this.municipios;
    }
    
    public Municipio pesquisarMunicipio(String nomeMunicipio) throws MunicipioNaoExisteException {
        for (Municipio x: this.municipios) {
            if ((x.getNome().toUpperCase()).equals(nomeMunicipio.toUpperCase())) {
                return x;
            }
        }
        throw new MunicipioNaoExisteException("O Município " + nomeMunicipio + " não existe!");
    }
    
    public void cadastrarAtrativoTuristico(AtrativoTuristico atrativo, String nomeMunicipio, 
            String estadoMunicipio) throws MunicipioNaoExisteException, AtrativoJaExisteException {
        
        boolean cadastrou = false;
        for (Municipio x: municipios) {
            if ((nomeMunicipio.toUpperCase().equals(x.getNome().toUpperCase())) && (estadoMunicipio.toUpperCase().equals(x.getEstado().toUpperCase()))) {
                x.cadastrarAtrativoTuristico(atrativo);
                cadastrou = true;
            }
            
        }
        if (!cadastrou) {
            throw new MunicipioNaoExisteException("O Município " + nomeMunicipio + " não existe");
        }
        
        
    }
    
    public List<AtrativoTuristico> getAtrativosTuristicosDoMunicipio(String nomeMunicipio, String estadoMunicipio) throws MunicipioNaoExisteException {
        for (Municipio x: this.municipios) {
            if (nomeMunicipio.toUpperCase().equals(x.getNome().toUpperCase()) && estadoMunicipio.toUpperCase().equals(x.getEstado().toUpperCase())){
                return x.getAtrativosTuristicos();
            }
        }
        throw new MunicipioNaoExisteException();
    }
        
}
    

