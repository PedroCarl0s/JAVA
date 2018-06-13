package br.ufpb.turismo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GravadorMunicipio {
    /**
     * Recupera o texto que está no arquivo chamado "nomeArquivo"
     * e retorna o texto como uma lista de Strings, onde 
    * cada elemento da lista é uma linha do arquivo.
     * 
     * @param nomeArquivo é o nome do arquivo a ser lido.
     * @return uma linha de Strings com o conteúdo do arquivo lido.
     * @throws IOException se houver algum problema na leitura.
     */
    
    public List<Municipio> recuperaMunicipios(String nomeArquivo) throws IOException {
        
        BufferedReader leitor = null;
        List<Municipio> municipios = new ArrayList<Municipio>();
        
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;
            
            do {
                texto = leitor.readLine(); // Lê a próxima linha do arquivo
                if (texto != null) {
                    int quantidadeMunicipios = Integer.parseInt(texto);
                    for (int k = 0; k < quantidadeMunicipios; k++) {
                        String nome = leitor.readLine();
                        int populacao = Integer.parseInt(leitor.readLine());
                        double latitude = Double.parseDouble(leitor.readLine());
                        double longitude = Double.parseDouble(leitor.readLine());
                        String estado = leitor.readLine();
                        String site = leitor.readLine();
                        
                        Municipio novoMunicipio = new Municipio(nome, populacao, latitude, longitude, estado, site);
                        municipios.add(novoMunicipio);
                        
                    }
                            
                }
                
            } while (texto != null); // vai ser null quando chegar no fim do arquivo
        
        } finally {
            if (leitor != null) {
                leitor.close(); // fecha o stream(fluxo) de leitura
            }
        }
        return municipios;
        
    }
    
    
    /**
     * Grava um certo texto passado como parâmetro em um arquivo.
     *
     * @param texto Uma lista de Strings que serão gravadas no arquivo uma por linha.
     *
     * @param nomeArquivo O nome do arquivo onde vou gravar o texto
     * @throws IOException se houver algum problema na gravação.
     */
    public void gravaMunicipios(List<Municipio> municipios, String nomeArquivo) throws IOException {
        BufferedWriter gravador = null;
        System.out.println("LENGTH = " + municipios.size());
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            gravador.write(municipios.size() + "\n");
            for (Municipio mun: municipios) {
                gravador.write(mun.getNome() + "\n");
                gravador.write(mun.getPopulacao() + "\n");
                gravador.write(mun.getLatitude() + "\n");
                gravador.write(mun.getLongitude() + "\n");
                gravador.write(mun.getEstado() + "\n");
                gravador.write(mun.getSite() + "\n");
            }
            
        } finally {
            if (gravador != null) {
                gravador.close(); //fecha o stream(fluxo) de escrita
            }
        }
    }
    
}
