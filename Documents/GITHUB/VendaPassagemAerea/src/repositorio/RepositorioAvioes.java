/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Aviao;


 /*
 * @author Lucas Guasselli de Moraes
 * @version 1.3
 * @since 13/04/2017
 * 
 */
public class RepositorioAvioes {
     private List<Aviao> avioes;
    
    //construtor ja instanciando um novo ArrayList
    public RepositorioAvioes() {
        avioes = new ArrayList<Aviao>();
    }//fecha construtor

    //metodos
    
    //adiciona aviao no Array
    public boolean addAviao(Aviao aviao) {
        return (avioes.add(aviao));
    }//fecha addPaciente

    //mostra os avioes cadastrados no Array
    public List<Aviao> getListAvioes() {
        return avioes;
    }//fecha get
    
    /*
    *Verifica se o aviao existe por meio do atributo codigo
    *Se o aviao ja existir, return TRUE, se não return FALSE;
    */
 
    public boolean AviaoExistByName(String nome) {
        for (Aviao aviao : avioes) {
            if (aviao.getNome().equals(nome)) {
                return true;
            }//fecha if
        }//fecha for-each
        return false;
    }//fecha clienteExist
    
    public boolean AviaoExistByCod(int codigo) {
        for (Aviao aviao : avioes) {
            if (aviao.getCodigo() == codigo) {
                return true;
            }//fecha if
        }//fecha for-each
        return false;
    }//fecha clienteExist
    /*
    *Procura clientes existentes no Array pelo seu rg
    *se a condicao for verdadeira, retorna o objeto AVIAO, se nao retorna NULL
    */
  
    public boolean searchAviaoByCodigo(int codigo) {
        for (Aviao aviao : avioes) {       
             if (aviao.getCodigo() == codigo) {
                System.out.println("###################################\n");
                System.out.println(String.format("%-10s", "CODIGO") + "\t"                    
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|QUANTIDADE DE ASSENTOS"));
            
                System.out.println(String.format("%-10s", aviao.getCodigo()) + "\t"
                       + String.format("%-20s", "|" + aviao.getNome()) + "\t"                       
                        + String.format("%-15s", "|" + aviao.getQtdeAssentos()));
               return true;
          }//fecha if
            
        }//fecha for
        return false;
      
    }//fecha searchCliente
    
    public Aviao retornaAviao(int codigo){
        for(Aviao aviao : avioes){
            if(aviao.getCodigo() == codigo){
                return aviao;
            }//fecha if
           }//fecha for
        //RETORNO CRIADO APENAS PARA PODER RETORNAR O OBJETO AVIAO
        //CODIGO NAO DEVE CHEGAR NESTE RETORNO
        
            Aviao Aviao = null;
        return Aviao;
    }//fecha classe
}//fecha classe
