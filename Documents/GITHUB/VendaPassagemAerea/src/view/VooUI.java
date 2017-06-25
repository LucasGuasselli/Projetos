/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.AssentosDAO;
import DAO.AviaoDAO;
import DAO.VooDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aviao;
import model.Voo;
import model.Assento;
import util.Digita;
import util.VerificaDatas;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.4
 * @since 16/04/2017
 * 
 */
public class VooUI {
    //atributos
    private VooDAO vDAO = new VooDAO();
    private AssentosDAO assDAO = new AssentosDAO();
    private AviaoDAO aDAO = new AviaoDAO();
    private Digita d = new Digita();
    private VerificaDatas verifica = new VerificaDatas();
    
    //METODO QUE CADASTRA VOO
    public void cadVoo() throws SQLException, ClassNotFoundException{
             //variaveis locais
        if(aDAO.verificaExistAviao() == true){
            int limit = 30;
            String origem,destino,dataVoo = "";
            Aviao aviao = null ;
            Voo voo = null;
            int codigoAviao = 0;
    
            origem = d.digitaNome("\n(min 3 e max 30 digitos)\nDigite o origem do voo: ");
            destino = d.digitaNome("\n(min 3 e max 30 digitos)\nDigite o destino do voo: ");
        do{
            do{
                dataVoo = d.digitaData("\nDigite a data do voo no formato (dd/mm/aaaa):");
                    if(verifica.verificaDataAnterior(dataVoo) == true){
                        System.out.println("\nDigite uma data igual ou a partir da data atual");
                    }//fecha if
        }while(dataVoo.length() != 10 || verifica.verificaDataAnterior(dataVoo) == true);
            
            codigoAviao = (d.digitaCodigo("\nInforme o codigo do aviao:"));
         
        if(aDAO.verificaAviaoByCod(codigoAviao) == true){
            if( vDAO.verificaDataAviao(codigoAviao,dataVoo) == false){
                aviao = (aDAO.retornaAviaoByCod(codigoAviao));
            }else{
                System.out.println("Aviao ja possui um voo nessa data");
            }
        }else{
            System.out.println("Aviao nao cadastrado!!");
        } 
        }while(aviao == null);
               
        try{
            vDAO.cadastrarVoo (new Voo(origem, destino, dataVoo, aviao));
                    System.out.println("VOO CADASTRADO COM SUCESSO!!!");
                    voo = vDAO.retornaVoo(dataVoo, origem, destino);
            for(int i = 0;i<aviao.getQtdeAssentos();i++){
                assDAO.cadastrarAssento(voo, (i+1));
            }//fecha for
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar voo");
                }//try-catch        
        }else{
                System.out.println("So e permitido o cadastro de voo quando tiver pelo menos"
                + " um aviao cadastrado");
        }//fecha if-else    
    }//fecha cadVoo
    
    public void visualizarVoos() throws ClassNotFoundException, SQLException {
        List<Voo> listaVoos = vDAO.retornaListaVoos();
                mostrarVoos(listaVoos);        
    }//fecha visualizarVoos

    public void pesquisaVooPorAviao(AviaoUI aviaoui) throws SQLException, ClassNotFoundException {
        if(aDAO.verificaExistAviao() == true){
            List<Aviao> listaAvioes = aDAO.retornaListaAvioes();
                aviaoui.mostrarAvioes(listaAvioes);
                int id = Integer.parseInt(d.digita("\nInforme o ID do aviao: "));
               List<Voo> listaVoos = vDAO.retornalistarVoos(id);
                    mostrarVoos(listaVoos);
        }else{
                System.out.println("So e permitido a pesquisa de voo quando tiver pelo menos"
                + "um aviao cadastrado");
        }//fecha if-else
    }//fecha pesquisaVooPorAviao
    
     //METODO QUE VERIFICA MOSTRA TODOS OS ASSENTOS DO VOO   
    public void verAssentos() throws SQLException, ClassNotFoundException {
        int idVoo;
        String dataVoo;
        Voo voo = null;
        Aviao aviao = null;
        List<Assento> listaAssentos = new ArrayList<>();

        if(vDAO.verificaExistVoo() == true){
            try{
            vDAO.retornaListaVoos();
            idVoo = (d.digitaCodigo("\nInforme o id do voo: "));
            
                if(vDAO.verificaExistVoo(idVoo) == true){
                    voo = vDAO.retornaVoo(idVoo);
                    aviao = aDAO.retornaAviaoByCod(voo.getIdAviao());                        
                    
                    for(int i = 0;i<aviao.getQtdeAssentos();i++){                            
                        listaAssentos.add(assDAO.retornaAssento(voo, (i+1)));
                        }//fecha for
                   mostrarAssentos(listaAssentos);
                }else{
                        System.out.println("Voo nao cadastrado!!"); 
                }//fecha if-else
                } catch (Exception e){
                    System.out.println("ERRO ao ver assentos");
                }//try-catch
        }else{
                System.out.println("So e permitido o cadastro de voo quando tiver pelo menos"
                + "um aviao cadastrado");
        }//fecha if-else
    }//fecha metodo
    
    public void mostrarVoos(List<Voo> listaVoos) {
        if (listaVoos.isEmpty()) {
            System.out.println("\nVoo(s) nao encontrado(s)!");
        } else {
            System.out.println("###################################\n");
           
            System.out.println(String.format("%-10s", "ORIGEM") + "\t"
                    + String.format("%-20s", "|DESTINO") + "\t"
                    + String.format("%-20s", "|DATA") + "\t"
                    + String.format("%-15s", "|ID DO AVIAO"));
            for (Voo voo : listaVoos) {
                System.out.println(String.format("%-10s", voo.getOrigem()) + "\t"
                        + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                        + String.format("%-20s", voo.getDataVoo()) + "\t"
                        + String.format("%-15s", "|" + voo.getIdAviao()));
            }//fea for
        }//fecha if-else 
    }//fecha mostrarVoos
    
    public void mostrarVoo(Voo voo){
 
        System.out.println("###################################\n");           
           //formatacao para exibir voos
           System.out.println(String.format("%-10s", "ORIGEM") + "\t"                    
                    + String.format("%-20s", "DESTINO") + "\t"
                    + String.format("%-20s", "|DATA DO VOO") + "\t"
                    );
        
            System.out.println(String.format("%-10s", voo.getOrigem()) + "\t"
                    + String.format("%-20s", "|" + voo.getDestino() + "\t"
                    + String.format("%-20s", voo.getDataVoo()) + "\t"));          
    }//fecha método
    
    public void mostrarAssentos(List<Assento> listaAssentos) {
        if (listaAssentos.isEmpty()) {
            System.out.println("\nAssento(s) nao encontrado(s)!");
        } else {
            System.out.println("###################################\n");
           
            System.out.println(String.format("%-10s", "IDVOO") + "\t"
                    + String.format("%-10s", "|NUMERO ASSENTO") + "\t"
                    + String.format("%-20s", "|DISPONIBILIDADE") + "\t");       
            
            for (Assento assento : listaAssentos) {
                System.out.println(String.format("%-10s",assento.getIdVoo()) + "\t"
                        + String.format("%-10s", "|" + assento.getNumAssento() + "\t"
                        + String.format("%-25s", assento.getTextoDisponibilidade())) + "\t");
            }//fecha for
        }//fecha if-else 
    }//fecha mostrarVoos 
    
    
}//fecha classe
