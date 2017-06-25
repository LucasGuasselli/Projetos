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
 * @version 1.3
 * @since 13/04/2017
 * 
 */
public class MenuAviaoUI  {

    //atributos
    Opcao cadAvi = new Opcao("Cadastrar aviao");
    Opcao edtAvi = new Opcao("Editar aviao");  
    Opcao delAvi = new Opcao("Deletar aviao");
    Opcao pesquisarAviByCod = new Opcao("Pesquisar aviao pelo ID");
    Opcao pesquisarAviByNome = new Opcao("Pesquisa aviao pelo NOME");
    Opcao verAvi = new Opcao("Vizualizar todos avioes");       
    Opcao menuPrincipal = new Opcao("Voltar ao menu principal");
    

    Menu menu = new Menu();
    int opcao;    
    AviaoUI aviaoUI = new AviaoUI();
    
    public MenuAviaoUI() {
        menu.addOption(cadAvi);
        menu.addOption(edtAvi);
        menu.addOption(delAvi);
        menu.addOption(pesquisarAviByCod);
        menu.addOption(pesquisarAviByNome);
        menu.addOption(verAvi);
        menu.addOption(menuPrincipal);        
    }//fecha construtor    
    
    public void menuAviao(){ 
        try{   
        do{
                 //mostra opcoes adicionadas no menu
                menu.show();
                opcao = menu.getOption();
                switch(opcao){
                    case 1:
                        aviaoUI.cadAviao();
                        break;
                    case 2:
                        aviaoUI.editaAviao();
                        break;
                    case 3:
                        aviaoUI.deletaCliente();
                        break;
                    case 4:
                        aviaoUI.procurarAviaoPorCodigo();
                        break;
                    case 5:
                        aviaoUI.procurarAvioesPorNome();
                        break;                        
                    case 6:
                        aviaoUI.visualizarAvioes();
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
        }//fecha metodo menuaVIAO    
    
    
}//fecha classe
