/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import util.Digita;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.6
 * @since 20/05/2017
 * 
 */
public class ClienteUI {
    ClienteDAO cDAO = new ClienteDAO();
    private Digita d = new Digita();
    
    //@param Objeto do tipo Cliente
    public void cadCliente() throws ClassNotFoundException, SQLException{
        //variaveis locais
        
            String rg;
            int limit = 10;            
            
                rg = d.digitaRg("\n(min 4 e max 10 digitos)\nDigite o rg do(a) Cliente: ");
            if(cDAO.verificaClienteRg(rg)){
                System.out.println("\nCliente ja esta cadastrado(a)");                
            }else{       
                                 
               //variaveis locais
                String nome = d.digitaNome("\nDigite o nome do(a) Cliente: ");
                    String telefone = "(00)00000-0000";
                    limit = 14;
                        do{
                            telefone = d.digita("\n(min 8 e max 14 digitos)\nDigite "
                            + "o telefone do(a) Cliente: ");                    
                        }while(telefone.length() > limit || telefone.length() <= 7);
            try{
                  cDAO.cadastrarCliente(new Cliente(nome, rg, telefone)); 
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar cliente!");
              }//try-catch
            }//if-else   
        }//fecha if-else
    
    public void editaCliente() throws SQLException, ClassNotFoundException{
         //variaveis locais     
            int limit = 10;
            String rg = "0000000000";
            Cliente cli;
                rg = d.digitaRg("\n(min 4 e max 10 digitos)\nDigite o rg do(a) Cliente que deseja alterar: ");
            
            if(!cDAO.verificaClienteRg(rg)){
                System.out.println("\nCliente nao esta cadastrado");                
            }else{
            cli = (cDAO.retornaClientePorRg(rg));            
                limit = 14;
                String  novoRg = d.digitaRg("\n(min 4 e max 10 digitos)\nDigite o NOVO rg do(a) Cliente que deseja alterar: ");
                String nome = d.digitaNome("\nDigite o nome do(a) Cliente: ");
                String telefone = "(00)00000-0000";
                    do{
                      telefone = d.digita("\n(min 8 e max 14 digitos)\nDigite "
                            + "o telefone do(a) Cliente: ");                    
                    }while(telefone.length() > limit || telefone.length() <= 7);
            try{
                  cDAO.editarCliente(new Cliente(cli.getId(),nome, novoRg, telefone)); 
                    System.out.println("CLIENTE EDITADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar cliente");
            }//try-catch
            }//fecha if-else        
    }//fecha editaCliente
    
    public void deletaCliente() throws ClassNotFoundException, SQLException {
                String rg = (d.digita("Digite o RG do(a) cliente que deseja deletar: "));
            if(!cDAO.verificaClienteRg(rg)){
                    System.out.println("\nCliente nao esta cadastrado");                
            }else{        
            try{
                Cliente cli = cDAO.retornaClientePorRg(rg);
                   cDAO.deletarCliete(cli);
            }catch(Exception e){
                   System.out.println("ERRO ao deletar cliente");
            }//try-catch
        }//if-else
    }//fecha deletaCliente

    public void procurarPorRg() throws ClassNotFoundException, SQLException{
        
      String rg = (d.digita("Digite o RG do(a) cliente que deseja visualizar: "));  
            if(!cDAO.verificaClienteRg(rg)){
                System.out.println("\nCliente nao esta cadastrado");                
            }else{
            try{ 
                Cliente cli = cDAO.retornaClientePorRg(rg);
                   showCliente(cli);       
            }catch(Exception e){
                   System.out.println("ERRO ao visualizar cliente");
              }//try-catch
        }//if-else
    }//fecha método
    
    public void procurarClientesPorNome() throws ClassNotFoundException, SQLException {
            String nome = (d.digitaNome("\nDigite o nome do(a) Cliente: "));
            if(cDAO.verificaClienteNome(nome)){
                System.out.println("\nCliente nao esta cadastrado");                
            }else{ 
                    List<Cliente> listaCliente = cDAO.retornaClientePorNome(nome);
                        mostrarClientes(listaCliente);
        }//if-else
    }//fecha pesquisarClientesPorNome
        
    //METODO QUE MOSTRA TODOS CLIENTES CADASTRADOS
    //@param Objeto do tipo Cliente
    public void showCliente(Cliente cli){
 
        System.out.println("###################################\n");           
           //formatacao para exibir Clientes
           System.out.println(String.format("%-10s", "ID") + "\t"                    
                    + String.format("%-20s", "RG") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|TELEFONE"));
        
            System.out.println(String.format("%-10s", cli.getId()) + "\t"
                    + String.format("%-20s", "|" + cli.getNome()) + "\t"
                    + String.format("%-20s", cli.getRg()) + "\t"
                    + String.format("%-15s", "|" + cli.getTelefone()));          
    }//fecha método

    public void mostrarClientes(List<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("\nCliente(s) nao encontrado(s)!");
        } else {
            System.out.println("###################################\n");
           
            System.out.println(String.format("%-10s", "ID") + "\t"
                    + String.format("%-20s", "|RG") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|TELEFONE"));
            for (Cliente cliente : listaClientes) {
                System.out.println(String.format("%-10s", cliente.getId()) + "\t"
                        + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                        + String.format("%-20s", cliente.getRg()) + "\t"
                        + String.format("%-15s", "|" + cliente.getTelefone()));
            }//fea for
        }//fecha if-else 
    }//fecha mostrarClientes  
    
    public void visualizarClientes() throws ClassNotFoundException, SQLException {
        List<Cliente> listaClientes = cDAO.retornaListaClientes();
                mostrarClientes(listaClientes);        
    }//fecha visualizarClientes
          
}//fecha classe
