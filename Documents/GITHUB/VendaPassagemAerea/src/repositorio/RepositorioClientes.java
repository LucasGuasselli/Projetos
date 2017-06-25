
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Aviao;
import model.Cliente;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */
public class RepositorioClientes {
    
    private List<Cliente> clientes;
    
    //construtor ja instanciando um novo ArrayList
    public RepositorioClientes() {
        clientes = new ArrayList<Cliente>();
    }//fecha construtor

    //metodos
    
    //adiciona cliente no Array
    public boolean addCliente(Cliente cliente) {
        return (clientes.add(cliente));
    }//fecha addPaciente

    //mostra os clientes cadastrados no Array
    public List<Cliente> getListClientes() {
        return clientes;
    }//fecha get

    /*
    *Verifica se o cliente existe por meio do atributo RG
    *Se o cliente ja existir, return TRUE, se não return FALSE;
    */
    public boolean clienteExist(String rg) {
        for (Cliente cliente : clientes) {
            if (cliente.getRg().equals(rg)) {
                return true;
            }//fecha if
        }//fecha for-each
        return false;
    }//fecha clienteExist

    /*
    *Procura clientes existentes no Array pelo seu rg
    *se a condicao for verdadeira, retorna o objeto CLIENTE, se nao retorna NULL
    */
    public boolean searchClienteByRg(String rg) {
       
        for (Cliente cliente : clientes) {
            if (cliente.getRg().equals(rg)) {
                System.out.println("###################################\n");
                System.out.println(String.format("%-10s", "RG") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|TELEFONE"));
            
                System.out.println(String.format("%-10s", cliente.getRg()) + "\t"
                        + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                        + String.format("%-15s", "|" + cliente.getTelefone()));
                return true;
           }//fecha if
            
        }//fecha for
        return false;
      
    }//fecha searchCliente
    
    public Cliente retornaCliente(String rg){
        for(Cliente cliente : clientes){
            if(cliente.getRg().equals(rg)){
                return cliente;
            }//fecha if
           }//fecha for
        //RETORNO CRIADO APENAS PARA PODER RETORNAR O OBJETO CLIENTE
        //CODIGO NAO DEVE CHEGAR NESTE RETORNO
        
            Cliente cliente = null;
        return cliente;
    }//fecha classe
}//fecha classe

