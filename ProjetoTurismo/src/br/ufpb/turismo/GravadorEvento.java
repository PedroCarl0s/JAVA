package br.ufpb.turismo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GravadorEvento {
    
    public List<EventoProgramado> recuperaEventoProgramado(String nomeArquivo) throws IOException {
    
        BufferedReader leitor = null;
        List<EventoProgramado> eventos = new ArrayList<EventoProgramado>();
        
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;
            
            do {
                texto = leitor.readLine();
                if (texto != null) {
                    int quantidadeAtrativos = Integer.parseInt(texto);
                    for (int k = 0; k < quantidadeAtrativos; k++) {
                        String nome = leitor.readLine();
                        String rota = leitor.readLine();
                        String site = leitor.readLine();
                        String infoContato = leitor.readLine();
                        String dataInicio = leitor.readLine();
                        String dataFinal = leitor.readLine();
                        String tipoEvento = leitor.readLine();
                        String logradouro = leitor.readLine();
                        String numeroLogradouro = leitor.readLine();
                        String bairro = leitor.readLine();
                        Endereco endereco = new Endereco(logradouro, numeroLogradouro, bairro);
                        
                        EventoProgramado novoEvento = new EventoProgramado(nome, rota, site, infoContato, dataInicio, dataFinal, tipoEvento, endereco);
                        
                        eventos.add(novoEvento);
                        
                    }
                }
            
            } while (texto != null); // Será nulo ao chegar no fim do arquivo
            
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    return eventos;
    }
    
    
    public void gravaEventoProgramado(List<AtrativoTuristico> atrativos, String nomeArquivo) 
            throws IOException {
    
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            gravador.write(atrativos.size() + "\n");
            for (AtrativoTuristico evento: atrativos) {
                if (evento instanceof EventoProgramado) {
                    EventoProgramado eventoProg = (EventoProgramado) evento;
                    gravador.write(eventoProg.getNome() + "\n");
                    gravador.write(eventoProg.getComoChegar() + "\n");
                    gravador.write(eventoProg.getSite() + "\n");
                    gravador.write(eventoProg.getInfoContato() + "\n");
                    gravador.write(eventoProg.getDataInicio() + "\n");
                    gravador.write(eventoProg.getDataFim() + "\n");
                    gravador.write(eventoProg.getTipo() + "\n");
                    gravador.write(eventoProg.getLogradouro() + "\n");
                    gravador.write(eventoProg.getNumeroLogradouro() + "\n");
                    gravador.write(eventoProg.getBairro() + "\n");
                }
            }
            
        } finally {
            if (gravador != null) {
                gravador.close(); // fecha o stream(fluxo) de escrita
            }
        }
        
    }
    
}
