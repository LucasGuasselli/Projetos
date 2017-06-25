/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import util.Opcao;
import util.Menu;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */

public class MenuUI {
    
    //atributos
   
    private int opcao;
    
    //construtor
    public MenuUI(){
            
    }//fecha construtor     
    
    public void executar(){      
        
        MenuClienteUI menuCliUI = new MenuClienteUI();
        MenuAviaoUI menuAviUI = new MenuAviaoUI();
        MenuVooUI menuVooUI = new MenuVooUI();
        MenuVendaUI menuVendaUI = new MenuVendaUI();
        
        //criando opcoes
        Opcao menuCliente = new Opcao("Acessar o menu de cliente");
        Opcao menuAviao = new Opcao("Acessar o menu de avioes");
        Opcao menuVoo = new Opcao("Acessar o menu de voos");
        Opcao menuVenda = new Opcao("Acessar o menu de vendas");

        Opcao sair = new Opcao("Sair");
        
        Menu menu = new Menu();
        menu.addOption(menuCliente);
        menu.addOption(menuAviao);
        menu.addOption(menuVoo);
        menu.addOption(menuVenda);
        menu.addOption(sair);
        
        try{
        do{
            //mostra opcoes adicionadas no menu
            menu.show();
            opcao = menu.getOption();
            switch(opcao){
                case 1:
                        menuCliUI.menuCliente();
                    break;
                case 2:
                        menuAviUI.menuAviao();
                    break;
                case 3:
                        menuVooUI.menuVoo();
                    break;
                case 4:
                        menuVendaUI.menuVenda();
                    break;
                case 0:
                    System.out.println("###################################");   
                    System.out.println("Aplicacao finalizada!!!");
                    break;
                default:
                    System.out.println("Digite uma opcao valida!!!");
                    break;
            }//fecha switch-case
            
        }while(opcao != 0);
            }catch (Exception e){
                System.out.println("USO SOMENTE DE NUMEROS INTEIROS PARA NAVEGAR NOS MENUS!");
            }//fecha try-catch
    
    }//fecha executar
}//fecha classe
