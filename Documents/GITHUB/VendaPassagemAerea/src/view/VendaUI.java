/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.AssentosDAO;
import DAO.AviaoDAO;
import DAO.ClienteDAO;
import DAO.VendaDAO;
import DAO.VooDAO;
import java.sql.SQLException;
import java.util.List;
import model.Assento;
import model.Aviao;
import model.Cliente;
import model.Venda;
import model.Voo;
import util.Digita;
import util.VerificaDatas;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.5
 * @since 19/04/2017
 * 
 */
public class VendaUI {

    //atributos
    private Digita d = new Digita();
    private VerificaDatas verifica = new VerificaDatas();
    private ClienteDAO cDAO = new ClienteDAO();
    private VooDAO vDAO = new VooDAO();
    private AviaoDAO aDAO = new AviaoDAO();
    private VendaDAO vendDAO = new VendaDAO();
    private AssentosDAO assDAO = new AssentosDAO();
    private ClienteUI  cliUI = new ClienteUI();
    private VooUI vooUI = new VooUI();
    private AviaoUI aviUI = new AviaoUI();
    
   //METODO QUE REALIZA O CADASTRO DA VENDA 
    public void cadVenda() throws SQLException, ClassNotFoundException{      
        
        if(cDAO.verificaExistCliente() == true || vDAO.verificaExistVoo() == true ){
            //variaveis locais
            Cliente cliente = null;
            Assento assento = null;
            int numAssento = 0;
            Voo voo = null;
            String rg = "";
            String dataVoo = "";
            int codigoAviao = 0;
        
            System.out.println("\nClientes cadastrados:\n");
                    List<Cliente> listaCliente = cDAO.retornaListaClientes();
                        cliUI.mostrarClientes(listaCliente);
            System.out.println("\nVoos cadastrados:\n");
                    List<Voo> listaVoo = vDAO.retornaListaVoos();
                        vooUI.mostrarVoos(listaVoo);
            
            do{
                rg = d.digitaRg("\n(min 4 e max 10 digitos)\nInforme o rg do cliente que deseja realizar uma compra: ");
                
                if(cDAO.verificaClienteRg(rg) == true){
                    cliente = cDAO.retornaClientePorRg(rg);
                }else{
                    System.out.println("O rg digitado é nao corresponde a nenhum cliente!");   
                }//fecha if-else
            }while(cliente == null);
            
            do{
                List<Aviao> listaAviao = aDAO.retornaListaAvioes();
                        aviUI.mostrarAvioes(listaAviao);
            codigoAviao = Integer.parseInt(d.digita("\nInforme o ID do aviao:"));
            dataVoo = d.digitaData("Informe a data do voo: ");
             
                if(aDAO.verificaAviaoByCod(codigoAviao) == true){
                    if(vDAO.verificaDataAviao(codigoAviao,dataVoo) == true){
                        voo = vDAO.retornaVoo(codigoAviao);
                    }else{
                        System.out.println("Aviao nao possui voo para esta data!"); 
                    }//fecha if-else                                           
                }else{
                    System.out.println("AVIAO NAO EXISTE");
                }//fecha-if-else
               }while(voo == null);  
        
            vooUI.mostrarAssentos(assDAO.retornaListaAssentos(voo));
            do{
                numAssento = Integer.parseInt(d.digita("\nInforme o numero do assento disponivel que voce deseja: "));
            }while(assDAO.verificaDisponibilidadeAssento(numAssento) == false);
            
            assento = assDAO.retornaAssento(voo,numAssento);
            
        try{
                vendDAO.cadastrarVenda(new Venda(cliente, voo, assento));
                    System.out.println("VENDA CADASTRADA COM SUCESSO!!!");
                assDAO.editarDisponibilidadeAssento(assento,numAssento);   
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar venda");
                }//try-catch   
        }else{
                System.out.println("So e permitido realizar uma venda quando tiver pelo menos"
                        + " um cliente e um voo cadastrado!");
        }//fecha if-else
    
    }//fecha cadVoo
    //METODO QUE MOSTRA TODAS AS VENDAS REALIZADAS 
    public void mostrarVendas() throws SQLException, ClassNotFoundException {
        Cliente cliente = null;
        Voo voo = null;
        if (vendDAO.verificaExistVenda() == false) {
            System.out.println("\nVenda(s) nao encontrada(s)!");
        } else {
          List<Venda> listaVenda = vendDAO.retornaListaVenda();
            for (Venda venda : listaVenda){
                cliente = cDAO.retornaClientePorId(venda.getIdCliente());
                voo = vDAO.retornaVoo(venda.getIdVoo());            
                System.out.println("###################################\n");

            System.out.println(String.format("%-10s", "CLIENTE") + "\t");
                System.out.println(String.format("%-10s", cliente.toString()) + "\t" );
                    System.out.println(String.format("%-10s", "VOO") + "\t");
                        System.out.println(String.format("%-10s", voo.toString()) + "\t" );
                            System.out.println(String.format("%-10s", "DATA DA COMPRA") + "\t"); 
                                System.out.println(venda.getHoraCompra());
            }//fecha for
        }//fecha if-else 
    }//fecha mostrarVendas
    
}//fecha classe
