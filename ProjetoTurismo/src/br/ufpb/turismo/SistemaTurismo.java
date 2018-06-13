package br.ufpb.turismo;

import static br.ufpb.turismo.Biblioteca.MensagemErro;
import static br.ufpb.turismo.Biblioteca.conversaoDouble;
import static br.ufpb.turismo.Biblioteca.conversaoInteira;
import static br.ufpb.turismo.Biblioteca.corrigeCampoVazio;
import static br.ufpb.turismo.Biblioteca.retornaMunicipios;
import exception.AtrativoJaExisteException;
import exception.AtrativoNaoExisteException;
import exception.HospedagemJaExisteException;
import exception.MunicipioJaExisteException;
import exception.MunicipioNaoExisteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import static br.ufpb.turismo.Biblioteca.selecaoComboBox;


public class SistemaTurismo {
    
    public static void main(String[] args) throws MunicipioJaExisteException, MunicipioNaoExisteException, AtrativoJaExisteException, AtrativoNaoExisteException, HospedagemJaExisteException {
        boolean sair = false;
        AreaDeInteresseTuristico litoralNorte = new AreaDeInteresseTuristico("LITORAL NORTE");
        String nome, estado, rota, site, infoContato;
        int populacao;
        double latitude, longitude;
        List<Municipio> municipios = new ArrayList<>();
        GravadorMunicipio meuGravadorMun = new GravadorMunicipio();
        
        final String ARQUIVO_MUNICIPIOS = "municipios.txt";
                
       
            
            try {
                
                while (!sair) {
                    String opcao = JOptionPane.showInputDialog("SISTEMA LITORAL NORTE"
                        + "\n1. Cadastrar Município" 
                        + "\n2. Cadastrar Atrativo Turístico"
                        + "\n3. Listar Municípios"
                        + "\n4. Listar Atrativos de determinado Município" 
                        + "\n5. Cadastrar Hospedagem" 
                        + "\n6. Listar Hospedagens de por Município" 
                        + "\n7. Sair");
                
                    switch (opcao) {
                        case "1":

                            // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                            nome = corrigeCampoVazio("Insira o nome do município a cadastrar");

                            // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser do tipo inteiro
                            populacao = conversaoInteira("Insira a população do município a cadastrar");

                            // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                            latitude = conversaoDouble("Insira a latitude do município a cadastrar");

                            // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                            longitude = conversaoDouble("Insira a longitude do município a cadastrar");

                            // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                            estado = corrigeCampoVazio("Insira o estado do município a cadastrar");

                            // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                            site = corrigeCampoVazio("Insira o site do município a cadastrar");

                            Municipio novoMunicipio = new Municipio(nome, populacao, latitude, longitude, estado, site);

                            try {
                                municipios = meuGravadorMun.recuperaMunicipios(ARQUIVO_MUNICIPIOS);
                                for (Municipio mun: municipios) {
                                    litoralNorte.cadastrarMunicipio(mun);
                                }

                            } catch (IOException e) {

                            } catch (MunicipioJaExisteException e) {

                            }

                            try {
                                litoralNorte.cadastrarMunicipio(novoMunicipio);
                                JOptionPane.showMessageDialog(null, "Município " + nome + " cadastrado com sucesso!");
                                meuGravadorMun.gravaMunicipios(litoralNorte.getMunicipios(), ARQUIVO_MUNICIPIOS);

                            } catch (MunicipioJaExisteException e) {
                                JOptionPane.showMessageDialog(null, "Já existe um município com o nome " + nome + "!");

                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "Erro ao gravar o município!");
                            }
                             break;


                        case "2":
                            boolean cadastrou = false;

                            try {
                                municipios = meuGravadorMun.recuperaMunicipios(ARQUIVO_MUNICIPIOS);
                                for (Municipio mun: municipios) {
                                    litoralNorte.cadastrarMunicipio(mun);
                                }
                                    
                            } catch (IOException e) {
                            
                            } catch (MunicipioJaExisteException e) {
                            
                            }

                            if (municipios.isEmpty()) {
                                MensagemErro();

                            } else {

                                JFrame frame = new JFrame();
                                String[] lista = new String[municipios.size()+1];
                                lista[0] = "SELECIONE";

                                int contador = 1;
                                for (Municipio m: municipios) {
                                    lista[contador] = m.getNome();
                                    contador++;
                                }

                                //lista = retornaMunicipios(litoralNorte);

                                // Recebe a opção selecionada, e caso não exista, o método pede outra opção até o usuário selecionar
                                String nomeMunicipio = selecaoComboBox(frame, "Você não selecionou nenhum município!", 
                                    "Cadastrar Atrativo", "Selecione um município", lista);
                                
                                
                                String[] opcoes = {"SELECIONE", "Atrativo Natural", "Atrativo Artificial", "Evento Programado"};
                                for (Municipio m: litoralNorte.getMunicipios()) { 
                                    if ((m.getNome().toUpperCase()).equals(nomeMunicipio.toUpperCase())) {

                                        // Pede uma opção, e caso o usuário não selecione, irá pedir uma nova opção
                                        String escolha = selecaoComboBox(frame, "Você não selecionou nenhum tipo de atrativo!", 
                                            "Cadastrar Atrativo", "Selecione um tipo de Atrativo", opcoes);

                                        switch (escolha) {
                                            case "Atrativo Natural":
                                                String[] tipo = {"SELECIONE", "Praia", "Atrativo Genérico"};

                                                // Pede uma opção, e caso o usuário não selecione, irá pedir uma nova opção
                                                String tipoNatural = selecaoComboBox(frame,"Você não selecionou nenhum atrativo natural!", 
                                                    "Cadastrar Atrativo Natural", "Selecione um Atrativo natural", tipo);


                                                if (tipoNatural.equals("Praia")) {
                                                    // Pede uma entrada, e caso seja vazia, o método irá pedir uma nova entrada
                                                    nome = corrigeCampoVazio("Insira o nome da Praia");

                                                   
                                                        // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                                        latitude = conversaoDouble("Latitude da Praia");

                                                        // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                                        longitude = conversaoDouble("Longitude da Praia");

                                                        // Recebe uma entrada, e caso seja vazia, o método pede outra entrada até ser válida
                                                        rota = corrigeCampoVazio("Como chegar a Praia ?");

                                                        // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                        site = corrigeCampoVazio("Site da Praia: ");

                                                        // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                        infoContato = corrigeCampoVazio("Informações para contato");

                                                        // A caixa de diálogo de opção retorna um valor inteiro, começando de 0(zero)
                                                        final int SIM = 0;
                                                        final int NAO = 1;
                                                        boolean perigoTubarao = false;
                                                        String[] simOuNao = {"Sim", "Não"};

                                                        int resposta = JOptionPane.showOptionDialog(frame, "Há perigo de tubarão ?", "Perigo de Tubarão", 
                                                                 JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, simOuNao, simOuNao[0]);

                                                        if (resposta == SIM) {
                                                            perigoTubarao = true;   
                                                        }

                                                        // A caixa de diálogo de opção retorna um valor inteiro, começando de 0(zero)
                                                        final int PEQUENAS = 0;
                                                        final int MEDIAS = 1;
                                                        final int GRANDES = 2;
                                                        String[] tamanhoOnda = {"Pequenas", "Médias", "Grandes"};
                                                        String tipoOnda = "";


                                                        resposta = JOptionPane.showOptionDialog(frame, "A praia possui qual tipo de onda ?", "Tipos de Onda", 
                                                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tamanhoOnda, tamanhoOnda[0]);

                                                        switch (resposta) {
                                                            case PEQUENAS:
                                                                tipoOnda = "Pequenas";
                                                                break;

                                                            case MEDIAS:
                                                                tipoOnda = "Médias";
                                                                break;

                                                            default:
                                                                tipoOnda = "Grandes";
                                                                break;
                                                        }


                                                        boolean marAberto = false;
                                                        resposta = JOptionPane.showOptionDialog(frame, "Possui mar aberto ?", "Mar Aberto", 
                                                                 JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, simOuNao, simOuNao[0]);

                                                        if (resposta == SIM) {
                                                            marAberto = true;
                                                        }

                                                        boolean propriaParaBanho = false;
                                                        resposta = JOptionPane.showOptionDialog(frame, "É própria para banho ?", "Própria para banho", 
                                                                 JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, simOuNao, simOuNao[0]);

                                                        if (resposta == SIM) {
                                                            propriaParaBanho = true;
                                                        }

                                                        // Recebe uma entrada, e caso seja vazia, o método pede outra entrada até ser válida
                                                        String tipoDeOrla = corrigeCampoVazio("Tipo de Orla");

                                                        Praia novaPraia = new Praia(nome, latitude, longitude, rota, site, infoContato, perigoTubarao,
                                                                tipoOnda, marAberto, propriaParaBanho, tipoDeOrla);
                                                        //m.cadastrarAtrativoTuristico(novaPraia);
                                                        
                                                        
                                                            
                                                        GravadorAtrativoNatural meuGravadorAtrativoNat = new GravadorAtrativoNatural();
                                                        Municipio municipioPesq = litoralNorte.pesquisarMunicipio(nomeMunicipio);
                                                        
                                                        // Faz uma busca do municipio selecionado, e adiciona na área de interesse seus respectivos atrativos
                                                        try {
                                                            
                                                            List<AtrativoNatural> atrativosMun = meuGravadorAtrativoNat.recuperaAtrativosNaturais("atrativos" + municipioPesq.getNome() + ".txt");
                                                            for (AtrativoTuristico atrativoTur: atrativosMun) {
                                                                litoralNorte.cadastrarAtrativoTuristico(atrativoTur, municipioPesq.getNome(), municipioPesq.getEstado());
                                                            }
                                                            
                                                            JOptionPane.showMessageDialog(null, "Atrativos recuperados com sucesso!");
                                                            
                                                        } catch (MunicipioNaoExisteException e) {

                                                        } catch (IOException e) {
                                                            
                                                        } catch (AtrativoJaExisteException e) {
                                                        
                                                        }
                                                        
                                                        
                                                        try {
                                                            litoralNorte.cadastrarAtrativoTuristico(novaPraia, municipioPesq.getNome(), municipioPesq.getEstado());
                                                            JOptionPane.showMessageDialog(null, "O Atrativo " + novaPraia.getNome() + " foi cadastrado com sucesso!");
                                                        
                                                        } catch (AtrativoJaExisteException e) {
                                                            
                                                        }
                                                       
                                                        try {
                                                            meuGravadorAtrativoNat.gravaAtrativoNatural(municipioPesq.getAtrativosTuristicos(), "atrativos" + nomeMunicipio + ".txt");
                                                            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");

                                                        } catch (IOException e) {
                                                            JOptionPane.showMessageDialog(null, e.getMessage());

                                                        }
                                                        break;

                                                } else if (tipoNatural.equals("Atrativo Genérico")) {

                                                    
                                                        // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                        nome = corrigeCampoVazio("Nome do Atrativo Natural");

                                                        // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                                        latitude = conversaoDouble("Latitude do Atrativo Natural");

                                                        // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                                        longitude = conversaoDouble("Longitude do Atrativo Natural");

                                                        // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                        rota = corrigeCampoVazio("Como chegar ao Atrativo " + nome + "?");

                                                        // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                        site = corrigeCampoVazio("Site do Atrativo Natural");

                                                        // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                        infoContato = corrigeCampoVazio("Informações para contato");

                                                        AtrativoNatural novoGenerico = new AtrativoNatural(nome, latitude, longitude, rota, site, infoContato);
                                                        
                                                        GravadorAtrativoNatural meuGravadorAtrativoNat = new GravadorAtrativoNatural();
                                                        Municipio municipioPesq = litoralNorte.pesquisarMunicipio(nomeMunicipio);
                                                        
                                                        // Faz uma busca do município selecionado, e adiciona na área de interesse seus respectivos atrativos
                                                        try {
                                                            List<AtrativoNatural> atrativosMun = meuGravadorAtrativoNat.recuperaAtrativosNaturais("atrativos" + municipioPesq.getNome() + ".txt");
                                                            for (AtrativoTuristico atrativoTur: atrativosMun) {
                                                                litoralNorte.cadastrarAtrativoTuristico(atrativoTur, municipioPesq.getNome(), municipioPesq.getEstado());
                                                            }
                                                            JOptionPane.showMessageDialog(null, "Atrativos recuperados com sucesso!");
                                                        
                                                        } catch (MunicipioNaoExisteException e) {
                                                        
                                                        } catch (AtrativoJaExisteException e) {
                                                        
                                                        } catch (IOException e) {
                                                        
                                                        }
                                                        
                                                        try {
                                                            litoralNorte.cadastrarAtrativoTuristico(novoGenerico, municipioPesq.getNome(), municipioPesq.getEstado());
                                                            JOptionPane.showMessageDialog(null, "O Atrativo " + novoGenerico.getNome() + " foi cadastrado com sucesso!");
                                                        
                                                        } catch (AtrativoJaExisteException e) {
                                                        
                                                        }
                                                        
                                                        try {
                                                            meuGravadorAtrativoNat.gravaAtrativoNatural(municipioPesq.getAtrativosTuristicos(), "atrativos" + municipioPesq.getNome() + ".txt");
                                                            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
                                                        
                                                        } catch (IOException e) {
                                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                                        }
                                                        break;

                                                }
                                                break;

                                            case "Atrativo Artificial":
                                               
                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    nome = corrigeCampoVazio("Nome do Atrativo Artificial");

                                                    // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                                    latitude = conversaoDouble("Insira a latitude do Atrativo Artificial");

                                                    // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                                    longitude = conversaoDouble("Insira a longitude do Atrativo Artificial");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    rota = corrigeCampoVazio("Como chegar ao Atrativo Artificial ?");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    site = corrigeCampoVazio("Insira o nome do site do Atrativo Artificial");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    infoContato = corrigeCampoVazio("Insira informações para contato");

                                                    AtrativoArtificial novoArtificial = new AtrativoArtificial(nome, latitude, longitude, rota, site, infoContato);
                                                    GravadorAtrativoArtificial meuGravadorAtrativoArt = new GravadorAtrativoArtificial();
                                                    Municipio municipioPesq = litoralNorte.pesquisarMunicipio(nomeMunicipio);
                                                    
                                                    // Faz uma busca do município selecionado, e adiciona na área de interesse seus respectivos atrativos
                                                    try {
                                                        List<AtrativoArtificial> atrativosMun = meuGravadorAtrativoArt.recuperaAtrativosArtificiais("atrativos" + municipioPesq.getNome() + ".txt");
                                                        for (AtrativoTuristico atrativoTur: atrativosMun) {
                                                            litoralNorte.cadastrarAtrativoTuristico(atrativoTur, municipioPesq.getNome(), municipioPesq.getEstado());
                                                        }
                                                        JOptionPane.showMessageDialog(null, "Atrativos Recuperados com sucesso!");
                                                    
                                                    } catch (MunicipioNaoExisteException e) { 
                                                    
                                                    } catch (AtrativoJaExisteException e) {
                                                    
                                                    } catch (IOException e) {
                                                        
                                                    }
                                                    
                                                    try {
                                                        litoralNorte.cadastrarAtrativoTuristico(novoArtificial, municipioPesq.getNome(), municipioPesq.getEstado());
                                                        JOptionPane.showMessageDialog(null, "O Atrativo " + novoArtificial.getNome() + " foi cadastrado com sucesso!");
                                                    
                                                    } catch (AtrativoJaExisteException e) {
                                                    
                                                    }
                                                    
                                                    try {
                                                        meuGravadorAtrativoArt.gravaAtrativoArtificial(municipioPesq.getAtrativosTuristicos(), "atrativos" + municipioPesq.getNome() + ".txt");
                                                        JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
                                                    
                                                    } catch (IOException e) {
                                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                                    } 
                                                    
                                                    cadastrou = true;                       
                                                    
                                                break;

                                            case "Evento Programado":
                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    nome = corrigeCampoVazio("Nome do Evento");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    rota = corrigeCampoVazio("Como chegar no Evento ?");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    site = corrigeCampoVazio("Site do Evento");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    infoContato = corrigeCampoVazio("Informações para contato");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    String dataInicio = corrigeCampoVazio("Data Inicial do Evento: ");

                                                    // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                                    String dataFinal = corrigeCampoVazio("Data Final do Evento: ");

                                                    String[] tipoEvento = {"SELECIONE", "Festa", "Feira Gastronômica"};

                                                    // Pede uma opção, e caso o usuário não selecione, irá pedir uma nova opção
                                                    String eventoSelecionado  = selecaoComboBox(frame, "Você não selecionou nenhum tipo de evento!", 
                                                        "Cadastrar Evento", "Selecione um tipo de evento", tipoEvento);


                                                    String logradouro = corrigeCampoVazio("Logradouro do Evento");
                                                    String numero = corrigeCampoVazio("Número do logradouro");
                                                    String bairro = corrigeCampoVazio("Bairro do Evento");
                                                    
                                                    Endereco novoEndereco = new Endereco(logradouro, numero, bairro);
                                                    
                                                    EventoProgramado novoEvento = new EventoProgramado(nome, rota, site, infoContato, 
                                                    dataInicio, dataFinal, eventoSelecionado, novoEndereco);
                                                    
                                                    GravadorEvento meuGravadorEvento = new GravadorEvento();
                                                    municipioPesq = litoralNorte.pesquisarMunicipio(nomeMunicipio);
                                                    
                                                    try {
                                                        List<EventoProgramado> atrativosMun = meuGravadorEvento.recuperaEventoProgramado("eventos" + municipioPesq.getNome() + ".txt");
                                                        for (AtrativoTuristico atrativoTur: atrativosMun) {
                                                            litoralNorte.cadastrarAtrativoTuristico(atrativoTur, municipioPesq.getNome(), municipioPesq.getEstado());                                                            
                                                        }
                                                        JOptionPane.showMessageDialog(null, "Atrativos recuperados com sucesso!");
                                                    
                                                    } catch (MunicipioNaoExisteException e) {
                                                    
                                                    } catch (AtrativoJaExisteException e) {
                                                    
                                                    } catch (IOException e) {
                                                        
                                                    }
                                                    
                                                    try {
                                                        litoralNorte.cadastrarAtrativoTuristico(novoEvento, municipioPesq.getNome(), municipioPesq.getEstado());
                                                        JOptionPane.showMessageDialog(null, "O Evento " + novoEvento.getNome() + " foi cadastrado com sucesso!");                                                        
                                                    
                                                    } catch (AtrativoJaExisteException e) {
                                                        JOptionPane.showMessageDialog(null, "O Evento " + novoEvento.getNome() + " já existe!");
                                                    }
                                                    
                                                    try {
                                                        meuGravadorEvento.gravaEventoProgramado(municipioPesq.getAtrativosTuristicos(), "eventos" + municipioPesq.getNome() + ".txt");
                                                        JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
                                                    } catch (IOException e) {
                                                    
                                                    }
                                                    
                                                    
                                                    cadastrou = true;

                                               
                                                break;
                                            }
                                    } 
                                }
                            }

                            break;


                        case "3":
                            try {
                                municipios = meuGravadorMun.recuperaMunicipios(ARQUIVO_MUNICIPIOS);
                            } catch (IOException e) {

                            }


                            try {
                                int contador = 0;
                                for (Municipio mun: municipios) {
                                    litoralNorte.cadastrarMunicipio(mun);
                                    contador++;
                                }

                            } catch (MunicipioJaExisteException e) {
                                
                            } 


                            if (municipios.isEmpty()) {
                                MensagemErro();

                            } else {
                                List<Municipio> listaMunicipio = litoralNorte.getMunicipios();
                                String listaString = "Municípios da área " + litoralNorte.getNome() + "\n";

                                for (Municipio m : listaMunicipio) {
                                    listaString += "- " + m.getNome() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, listaString);
                            }
                            break;


                        case "4":
                            
                            try {
                                municipios = meuGravadorMun.recuperaMunicipios(ARQUIVO_MUNICIPIOS);
                                for (Municipio mun: municipios) {
                                    litoralNorte.cadastrarMunicipio(mun);
                                }

                            } catch (IOException e) {

                            } catch (MunicipioJaExisteException e) {

                            }
                            
                            
                            if (municipios.isEmpty()) {
                                MensagemErro();

                            } else {
                                JFrame frame = new JFrame();
                                String[] lista = new String[litoralNorte.getMunicipios().size()+1];
                                
                                lista = retornaMunicipios(litoralNorte);
                                

                                // Recebe a opção selecionada, e caso não exista, o método pede outra opção até o usuário selecionar
                                String municipioAPesquisar = selecaoComboBox(frame, "Você não selecionou nenhum município!", 
                                    "Listar Atrativos", "Selecione um município", lista);

                                // Recupera atrativos naturais                                
                                String atrativosNaturais = null;
                                GravadorAtrativoNatural meuGravadorAtrativoNat = new GravadorAtrativoNatural();
                                try {
                                    List<AtrativoNatural> atrativosMun = meuGravadorAtrativoNat.recuperaAtrativosNaturais("atrativos" + municipioAPesquisar + ".txt");
                                    
                                    atrativosNaturais = "Listando atrativos naturais de " + municipioAPesquisar + "\n\n";
                                    for (AtrativoTuristico atrativoTur: atrativosMun) {
                                        atrativosNaturais += atrativoTur.getDescricao() + "\n\n";
                                    }
                                    JOptionPane.showMessageDialog(null, atrativosNaturais);
                                
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Não encontramos atrativos naturais de " + municipioAPesquisar );
                                    
                                }
                                
                                
                                // Recupera eventos
                                String eventos = null;
                                GravadorEvento meuGravadorEvento = new GravadorEvento();
                                try {
                                    List<EventoProgramado> eventosMun = meuGravadorEvento.recuperaEventoProgramado("eventos" + municipioAPesquisar + ".txt");

                                    eventos = "Listando Eventos de " + municipioAPesquisar + "\n\n";
                                    for (AtrativoTuristico atrativoTur: eventosMun) {
                                        eventos += atrativoTur.getDescricao() + "\n\n";
                                    }
                                    JOptionPane.showMessageDialog(null, eventos);
                                    
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Não encontramos eventos cadastrados de " + municipioAPesquisar);
                                    
                                }
                            }
                            
                        break;
                        
                        case "5":
                            if (litoralNorte.getMunicipios().isEmpty()) {
                                MensagemErro();

                            } else {
                                JFrame frame = new JFrame();
                                String[] lista = new String[litoralNorte.getMunicipios().size()+1];
                                lista = retornaMunicipios(litoralNorte);

                                // Recebe a opção selecionada, e caso não exista, o método pede outra opção até o usuário selecionar
                                String nomeCidade = selecaoComboBox(frame, "Você não selecionou nenhum município!", 
                                    "Cadastrar Hospedagem", "Selecione um município", lista);

                                for (Municipio m : litoralNorte.getMunicipios()) {
                                    if ((m.getNome().toUpperCase()).equals(nomeCidade.toUpperCase())) {
                                        nome = JOptionPane.showInputDialog("Nome do meio de hospedagem");

                                        try {
                                            // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                            latitude = conversaoDouble("Latitude do meio de hospedagem");

                                            // Recebe uma entrada e caso seja vazia, o método pede outra entrada até ser válida e depois converte em double
                                            longitude = conversaoDouble("Longitude do meio de hospedagem");

                                            // Recebe uma entrada, e caso seja vazia, o método pede outra entrada até ser válida
                                            infoContato = corrigeCampoVazio("Informações para contato");

                                            // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                            site = corrigeCampoVazio("Site do meio de hospedagem");

                                            String[] opcoes = {"SELECIONE", "Hotel", "Pousada", "Albergue"};

                                            // Pede uma opção, e caso o usuário não selecione, irá pedir uma nova opção
                                            String tipoHospedagem = selecaoComboBox(frame,"Você não selecionou nenhum tipo de hospedagem!", 
                                                    "Cadastrar Hospedagem", "Selecione um tipo de Hospedagem", opcoes);

                                            // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                            String logradouro = corrigeCampoVazio("Logradouro do " + tipoHospedagem);

                                            // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                            String numero = corrigeCampoVazio("Número do " + tipoHospedagem);

                                            // Recebe uma entrada, e caso o seja vazia, o método pede outra entrada até ser válida
                                            String bairro = corrigeCampoVazio("Bairro do " + tipoHospedagem);

                                            Endereco novoEndereco = new Endereco(logradouro, numero, bairro);

                                            MeioDeHospedagem novoMeio = new MeioDeHospedagem(nome, latitude, longitude, infoContato, site, tipoHospedagem, novoEndereco);
                                            m.cadastraMeioDeHospedagem(novoMeio);
                                            cadastrou = true;
                                            JOptionPane.showMessageDialog(null, "Hospedagem cadastrada com sucesso!");

                                        } catch (NumberFormatException erro) {
                                            JOptionPane.showMessageDialog(null, "Insira somente números!");

                                        } catch (HospedagemJaExisteException erro) {
                                            JOptionPane.showMessageDialog(null, erro.getMessage());
                                        } 

                                    }
                                }

                            }
                            break;

                        case "6":
                            if (litoralNorte.getMunicipios().isEmpty()) {
                                MensagemErro();

                            } else {
                                JFrame frame = new JFrame();
                                String[] listaMunicipios = new String[litoralNorte.getMunicipios().size()+1];
                                listaMunicipios = retornaMunicipios(litoralNorte);
                                // Recebe a opção selecionada, e caso não exista, o método pede outra opção até o usuário selecionar
                                String nomeMunicipio = selecaoComboBox(frame, "Você não selecionou nenhum município!", 
                                    "Listar Hospedagens", "Selecione um município", listaMunicipios);

                                String listaString = "";
                                boolean cidadeExiste = false;
                                List<MeioDeHospedagem> lista = new ArrayList<>();
                                for (Municipio m: litoralNorte.getMunicipios()) {
                                    if ((m.getNome().toUpperCase()).equals(nomeMunicipio.toUpperCase())) {
                                        lista = m.getMeiosDeHospedagem();
                                        break;
                                    }
                                }

                                for (MeioDeHospedagem m: lista) {
                                    listaString += m.getDescricao() + "\n\n";
                                }

                                if (listaString.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "O município " + nomeMunicipio + " não possui hospedagens cadastradas!" );

                                } else {
                                    JOptionPane.showMessageDialog(null, "Listando Hospedagens do município " + nomeMunicipio + "\n" + listaString);
                                }    

                            }
                            break;

                        case "7":
                            JOptionPane.showMessageDialog(null, "Programa finalizado com sucesso!");
                            sair = true;
                            break;
                            

                        default:
                            JOptionPane.showMessageDialog(null, "Entrada Inválida!");
                            break;
                
                    }
                } 
            
            } catch (NullPointerException erro) {
                JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!");
                System.exit(0);
            }

        
    } 
}