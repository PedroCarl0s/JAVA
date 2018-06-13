package br.ufpb.turismo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorAtrativoArtificial {
    /*
    nome, latitude, longitudee, rota, site, infoContato, 
    dataInicio, dataFinal, tipoEvento, logradouro, numero logradouro, bairro
    */
    
    /**
     * Recupera o texto que está no arquivo chamado "nomeArquivo"
     * e retorna o texto como uma lista de Strings, onde 
     * cada elemento da lista é uma linha do arquivo.
     * 
     * @param nomeArquivo
     * @return uma linha de Strings com o conteúdo do arquivo lido.
     * @throws IOException se houver algum problema na leitura.
     */
    public List<AtrativoArtificial> recuperaAtrativosArtificiais(String nomeArquivo)
            throws IOException {
    
        BufferedReader leitor = null;
        List<AtrativoArtificial> atrativos = new ArrayList<AtrativoArtificial>();
        
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
                        
                        AtrativoArtificial atrativoArt = new AtrativoArtificial(nome, latitude, longitude, comoChegar, site, infoContato);
                        atrativos.add(atrativoArt);
                    }
                }
            
            } while (texto != null); // Será nulo ao chegar no fim do arquivo
            
        } finally {
            if (leitor != null) {
                leitor.close(); // Fecha o stream(fluxo) de leitura
            }
        
        }
        return atrativos;
        
    }
    
    
      /**
     * Grava um certo texto passado como parâmetro em um arquivo.
     *
     *
     * @param atrativos - Lista contendo os atrativos de um município
     * @param nomeArquivo - O nome do arquivo será gravado o texto
     * @throws IOException - Caso ocorra algum problema na gravação.
     */
    public void gravaAtrativoArtificial(List<AtrativoTuristico> atrativos, String nomeArquivo)
            throws IOException {
    
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            gravador.write(atrativos.size() + "\n");
            for (AtrativoTuristico at: atrativos) {
                if (at instanceof AtrativoArtificial) {
                    gravador.write(at.getNome() + "\n");
                    gravador.write(at.getLatitude() + "\n");
                    gravador.write(at.getLongitude() + "\n");
                    gravador.write(at.getComoChegar() + "\n");
                    gravador.write(at.getSite() + "\n");
                    gravador.write(at.getInfoContato() + "\n");
                }
            }
            
        } finally {
            if (gravador != null) {
                gravador.close(); // fecha o stream(fluxo) de escrita
            }
        }
    }
            
}
