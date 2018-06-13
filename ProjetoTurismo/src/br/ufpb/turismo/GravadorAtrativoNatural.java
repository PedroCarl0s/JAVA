package br.ufpb.turismo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GravadorAtrativoNatural {
    
    /**
     * Recupera o texto que está no arquivo chamado "nomeArquivo"
     * e retorna o texto como uma lista de Strings, onde 
     * cada elemento da lista é uma linha do arquivo.
     * 
     * @param nomeArquivo é o nome do arquivo a ser lido.
     * @return uma linha de Strings com o conteúdo do arquivo lido.
     * @throws IOException se houver algum problema na leitura.
     */
    public List<AtrativoNatural> recuperaAtrativosNaturais(String nomeArquivo) 
            throws IOException {
        
        BufferedReader leitor = null;
        List<AtrativoNatural> atrativos = new ArrayList<AtrativoNatural>();
        
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;
            
            do {
                texto = leitor.readLine(); // Lê a próxima linha do arquivo
                if (texto != null) {
                    int quantidadeAtrativos = Integer.parseInt(texto);
                    for (int k = 0; k < quantidadeAtrativos; k++) {
                        String nome = leitor.readLine();
                        double latitude = Double.parseDouble(leitor.readLine());
                        double longitude = Double.parseDouble(leitor.readLine());
                        String comoChegar = leitor.readLine();
                        String site = leitor.readLine();
                        String infoContato = leitor.readLine();
                        
                        AtrativoNatural atrativoNat = new AtrativoNatural(nome, latitude, longitude, comoChegar, site, infoContato);
                        atrativos.add(atrativoNat);
                    }
                }
                
            } while (texto != null); // vai ser null quando chegar no fim do arquivo
        
        } finally {
            if (leitor != null) {
                leitor.close(); // fecha o stream(fluxo) de leitura
            }
        }
        return atrativos;
        
    }
    
    
    /**
     * Grava um certo texto passado como parâmetro em um arquivo.
     *
     * @param atrativos - Lista contendo os atrativos de um município
     * @param nomeArquivo - O nome do arquivo onde vou gravar o texto
     * @throws IOException -  Caso ocorra algum problema na gravação
     */
    public void gravaAtrativoNatural(List<AtrativoTuristico> atrativos, String nomeArquivo)
            throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            gravador.write(atrativos.size() + "\n");
            for (AtrativoTuristico atn : atrativos) {
                if (atn instanceof AtrativoNatural){
                    gravador.write(atn.getNome() + "\n");
                    gravador.write(atn.getLatitude() + "\n");
                    gravador.write(atn.getLongitude() + "\n");
                    gravador.write(atn.getComoChegar() + "\n");
                    gravador.write(atn.getSite() + "\n");
                    gravador.write(atn.getInfoContato() + "\n");
                
                } else if (atn instanceof Praia) {
                    gravador.write(atn.getDescricao());
                    //gra
                
                }
            }
            
        } finally {
            if (gravador != null) {
                gravador.close(); //fecha o stream(fluxo) de escrita
            }
        }
    }
    
    
}