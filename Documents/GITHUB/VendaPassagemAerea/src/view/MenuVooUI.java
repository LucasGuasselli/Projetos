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
 * @version 1.4
 * @since 16/04/2017
 * 
 */
public class MenuVooUI {
        Opcao cadVoo = new Opcao("Cadastrar voo");
        Opcao verVoo = new Opcao("Vizualizar voos");
        Opcao pesquisaVooByAviao = new Opcao("Pesquisa voo pelo aviao");
        Opcao verAssentos = new Opcao("Ver disponibilidade de assentos");

        Opcao menuPrincipal = new Opcao("Voltar ao menu principal");
        
        Menu menu = new Menu();      
        int opcao;       
        VooUI VooUI = new VooUI();
        AviaoUI AviaoUI = new AviaoUI();
        
        //construtor
        public MenuVooUI() {
            menu.addOption(cadVoo);
            menu.addOption(verVoo);
            menu.addOption(pesquisaVooByAviao);
            menu.addOption(verAssentos);
            menu.addOption(menuPrincipal);
        }//fecha construtor
        
        public void menuVoo(){
            try{
            do{
                 //mostra opcoes adicionadas no menu
                menu.show();
                opcao = menu.getOption();
                 switch(opcao){
                    case 1:
                        VooUI.cadVoo();
                        break;
                    case 2:
                        VooUI.visualizarVoos();
                        break;
                    case 3:
                        VooUI.pesquisaVooPorAviao(AviaoUI);
                        break;
                    case 4:
                        VooUI.verAssentos();
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
