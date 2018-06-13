package br.ufpb.turismo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
public class TestaArquivo {
    public static void main(String[] args) {
        Gravador meuGravador = new Gravador();
        
        List<String> municipiosJaCadastrados = new ArrayList<String>();
        try {
            municipiosJaCadastrados = meuGravador.recuperaTextoDeArquivo("municipiosTeste.txt");
            JOptionPane.showMessageDialog(null, municipiosJaCadastrados.size() +  " Municipios recuperados com sucesso!");
        } catch (IOException erro) {
            
        }
                
        List<String> texto = new ArrayList<String>();
        texto.addAll(municipiosJaCadastrados);
        int numeroMunicipios = Integer.parseInt(JOptionPane.showInputDialog ("Deseja cadastrar quantos municípios ?"));
        
        for (int k = 0; k < numeroMunicipios; k++) {
            String nomeMunicipio = JOptionPane.showInputDialog ("Digite o nome do município");
            texto.add(nomeMunicipio);
        }
        
        try {
            meuGravador.gravaTextoEmArquivo(texto, "municipiosTeste.txt");
            JOptionPane.showMessageDialog(null, "Texto Gravado com sucesso!");
            
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        
    }
    
}
*/