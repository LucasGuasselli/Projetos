/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import util.Menu;
import util.Opcao;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.5
 * @since 19/04/2017
 * 
 */
public class MenuVendaUI {
        Opcao cadVenda = new Opcao("Realizar venda");
        Opcao verVenda = new Opcao("Visualizar passageiros e seus assentos reservados");
        Opcao menuPrincipal = new Opcao("Voltar ao menu principal");
        
        int opcao;   
        Menu menu = new Menu();  
        VendaUI vendaUI = new VendaUI();
        
        //construtor
        public MenuVendaUI() {
           menu.addOption(cadVenda);
           menu.addOption(verVenda);
           menu.addOption(menuPrincipal);
        }//fecha construtor
        
        public void menuVenda(){
            try{
            do{
                 //mostra opcoes adicionadas no menu
                menu.show();
                opcao = menu.getOption();
                 switch(opcao){
                    case 1:
                        vendaUI.cadVenda();
                        break;
                    case 2:
                        vendaUI.mostrarVendas();
                        break;
                    case 0:
                        System.out.println("Retornando ao menu principal");
                        break;
                default:
                    System.out.println("Digite uma opcao valida!!!");
                        break;
            }//fecha switch-case            
        }while(opcao != 0);
            }catch (Exception e){
                System.out.println("USO SOMENTE DE NUMEROS INTEIROS PARA NAVEGAR NOS MENUS!");
            }//FECHA TRY-CATCH
        }//fecha metodo menuCliente
}//fecha classe
