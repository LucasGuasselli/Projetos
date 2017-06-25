/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaPassagem;

import view.MenuUI;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            new MenuUI().executar();
	} catch (Exception e){
		System.err.println("Nao encontrou arquivo.");
		System.err.println(e.getMessage());
    }//fecha try-catch
    }//fecha main
}//fecha main
