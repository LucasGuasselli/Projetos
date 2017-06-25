/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.AviaoDAO;
import java.sql.SQLException;
import java.util.List;
import model.Aviao;
import util.Digita;

/**
 * 
 * @author Lucas Guasselli de Moraes
 * @version 1.3
 * @since 13/04/2017
 * 
 */
public class AviaoUI {
    AviaoDAO aDAO = new AviaoDAO();
    private Digita d = new Digita();
    //METODO DE CADASTRO DE AVIAO
    //@param ArrayList do tipo RepositorioAvioes

    public void cadAviao() throws ClassNotFoundException, SQLException{
        //variaveis locais
            
            int codigo;
            int limit = 200;
            int assentos = 0;
            
            codigo = (d.digitaCodigo("\n(Deve ser > 0 E < 999)\nDigite o codigo do Aviao: "));  
            if(aDAO.verificaAviaoByCod(codigo)){
                System.out.println("Aviao ja esta cadastrado");
            }else{                           
                String nome = (d.digitaNome("\n(min 3 e max 30 caracteres)\nDigite o nome do Aviao: "));       
                //variaveis locais
                    do{
                      assentos = Integer.parseInt(d.digita("\n(min 80 e max 200 assentos)"
                              + "\nDigite a quantidade de assentos do Aviao: "));                    
                    }while(assentos > limit || assentos <= 79);
                try{
                  aDAO.cadastrarAviao(new Aviao(codigo,nome, assentos));
                    System.out.println("\nAVIAO CADASTRADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar aviao");
              }//try-catch
             }//fecha if-else
    }//fecha cadCliente
    
     public void editaAviao() throws SQLException, ClassNotFoundException{
         //variaveis locais  
            Aviao avi;
            int limit = 200;
            int codigo;
            int novoQtdeAssentos;

                codigo = d.digitaCodigo("\n(Deve ser > 0 E < 999)\nDigite o ID do Aviao: "); 
            if(!aDAO.verificaAviaoByCod(codigo)){
                System.out.println("\nAviao nao esta cadastrado");                
            }else{
                avi = aDAO.retornaAviaoByCod(codigo);
                int novoCodigo = d.digitaCodigo("\n(Deve ser > 0 E < 999)\nDigite o NOVO codigo do Aviao: ");
                String novoNome = d.digitaNome("\nDigite o nome do aviao: ");
                    do{
                      novoQtdeAssentos = Integer.parseInt(d.digita("\n(min 80 e max 200 assentos)"
                              + "\nDigite a quantidade de assentos do Aviao: "));                    
                    }while(novoQtdeAssentos > limit || novoQtdeAssentos <= 0);
            try{
                  aDAO.editarAviao(new Aviao(avi.getId(), novoCodigo, novoNome, novoQtdeAssentos)); 
                    System.out.println("AVIAO EDITADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar cliente");
            }//try-catch
            }//fecha if-else        
    }//fecha editaAviao
   
    public void deletaCliente() throws ClassNotFoundException, SQLException {
                int codigo = (d.digitaCodigo("Digite o Codigo do aviao que deseja deletar: "));
            if(!aDAO.verificaAviaoByCod(codigo)){
                    System.out.println("\nAviao nao esta cadastrado");                
            }else{        
            try{
                Aviao avi = aDAO.retornaAviaoByCod(codigo);
                   aDAO.deletarAviao(avi);
            }catch(Exception e){
                   System.out.println("ERRO ao deletar aviao");
            }//try-catch
        }//if-else
    }//fecha deletaAviao

    public void procurarAviaoPorCodigo() throws ClassNotFoundException, SQLException{
        
      int codigo = (d.digitaCodigo("Digite o codigo do aviao que deseja visualizar: "));  
            if(!aDAO.verificaAviaoByCod(codigo)){
                System.out.println("\nAviao nao esta cadastrado");                
            }else{
            try{ 
                Aviao avi = aDAO.retornaAviaoByCod(codigo);
                   showAviao(avi);       
            }catch(Exception e){
                   System.out.println("ERRO ao visualizar aviao");
              }//try-catch
        }//if-else
    }//fecha método
    
    public void procurarAvioesPorNome() throws ClassNotFoundException, SQLException {
            String nome = (d.digitaNome("\nDigite o nome do Aviao: "));
            if(aDAO.verificaAviaoNome(nome)){
                System.out.println("\nAviao nao esta cadastrado");                
            }else{ 
                    List<Aviao> listaAviao = aDAO.retornaAviaoPorNome(nome);
                        mostrarAvioes(listaAviao);
        }//if-else
    }//fecha pesquisarClientesPorNome
        
    //METODO QUE MOSTRA TODOS AVIOES CADASTRADOS
    //@param Objeto do tipo Cliente
    public void showAviao(Aviao avi){
 
        System.out.println("###################################\n");           
           //formatacao para exibir aviao
           System.out.println(String.format("%-10s", "ID") + "\t"                    
                    + String.format("%-20s", "CODIGO") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-10s", "|QUANTIDADE DE ASSENTOS"));
        
            System.out.println(String.format("%-10s", avi.getId()) + "\t"
                    + String.format("%-20s", "|" + avi.getCodigo()) + "\t"
                    + String.format("%-20s", avi.getNome()) + "\t"
                    + String.format("%-10s", "|" + avi.getQtdeAssentos()));          
    }//fecha método

    void mostrarAvioes(List<Aviao> listaAvioes) {
        if (listaAvioes.isEmpty()) {
            System.out.println("\nAviao(oes) nao encontrado(s)!");
        } else {
            System.out.println("###################################\n");
           
            System.out.println(String.format("%-10s", "ID") + "\t"
                    + String.format("%-20s", "|CODIGO") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|QUANTIDADE DE ASSENTOS"));
            for (Aviao aviao : listaAvioes) {
                System.out.println(String.format("%-10s", aviao.getId()) + "\t"
                        + String.format("%-20s", "|" + aviao.getCodigo()) + "\t"
                        + String.format("%-20s", aviao.getNome()) + "\t"
                        + String.format("%-15s", "|" + aviao.getQtdeAssentos()));
            }//fea for
        }//fecha if-else 
    }//fecha mostrarClientes  
    
    public void visualizarAvioes() throws ClassNotFoundException, SQLException {
        List<Aviao> listaAvioes = aDAO.retornaListaAvioes();
                mostrarAvioes(listaAvioes);        
    }//fecha visualizarClientes
          
}//fecha classe
