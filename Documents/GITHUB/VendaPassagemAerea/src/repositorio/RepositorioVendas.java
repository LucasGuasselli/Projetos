/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Venda;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.5
 * @since 19/04/2017
 * 
 */
public class RepositorioVendas {
    private List<Venda> vendas;
    
    //construtor ja instanciando um novo ArrayList
    public RepositorioVendas() {
        vendas = new ArrayList<Venda>();
    }//fecha construtor

    //metodos
    
    //adiciona venda no Array
    public boolean addVenda(Venda venda) {
        return (vendas.add(venda));
    }//fecha addPaciente

    //mostra as vendas cadastrados no Array
    public List<Venda> getListVendas() {
        return vendas;
    }//fecha get

    /*
    *Verifica se a venda existe por meio do cliente
    *Se o cliente tiver realizado uma compra, return TRUE, se não return FALSE;
    */
    /*
    public boolean VendaExist(Cliente cliente) {
        for (Venda venda : vendas) {
            if (venda.getCliente() == cliente) {
                return true;
            }//fecha if
        }//fecha for-each
        return false;
    }//fecha clienteExist

    /*
    *Procura vendas realizadas pelos clientes existentes no Array 
    *se a condicao for verdadeira, retorna o objeto VENDA, se nao retorna NULL
    */
    /*
    public boolean searchVendaByCliente(Cliente cliente) {
       
        for (Venda venda : vendas) {
          //  if (venda.getCliente() == cliente) {
                System.out.println("###################################\n");
                    System.out.println(String.format("%-10s", "CLIENTE") + "\t");
            //           System.out.println(String.format("%-10s", venda.getCliente()) + "\t" );
                            System.out.println(String.format("%-10s", "VOO") + "\t");
               //                System.out.println(String.format("%-10s", venda.getVoo()) + "\t" );
               //                     System.out.println(String.format("%-10s", "HORA DA COMPRA") + "\t"); 
                                        System.out.println(venda.getHoraCompra()); 
                       return true;
           }//fecha if
            
        }//fecha for
        return false;
      
    }//fecha searchCliente
*/
}//fecha classe
