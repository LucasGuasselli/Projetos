package view;

import java.io.File;
import java.util.Scanner;

import model.Matrizes;
import util.Menu;
import util.Opcao;

public class GerenciadorUI {

		
		private static int x,y = 0;
		
		
	public static void main(String[] args) {

		Menu menu = new Menu();
		
		Opcao val1 = new Opcao("Mudar valor 1 para 2");
		Opcao val2 = new Opcao("Mudar valores 2 para 0");
		Opcao sair = new Opcao("Sair");
		
		menu.addOption(val1);
		menu.addOption(val2);
		menu.addOption(sair);
		
		int[][] matriz1 = new int[11][11];
		int[][] matriz2 = new int[11][11];
		int[][] matriz3 = new int[11][11];
		
		lerArquivo(matriz1, matriz2 , matriz3);
		verMatriz(matriz1);
		
		do{
		menu.show();
			
		switch(menu.getOption()){
			case 1:
					verMatriz(matriz2);
				break;
			case 2:
					verMatriz(matriz3);
				break;
			default:
					System.exit(0);
				break;
			
		}//fecha switch-case
		
		}while(true);
	}//fecha main


	private static void lerArquivo(int[][] matriz1,int[][] matriz2,int[][]matriz3 ) {
			
		int a = 0;
		int b = 0;	
		String linha;
			
		try {
			Scanner arquivo = new Scanner(new File("src/arquivos/example_3.txt")); 
				x = arquivo.nextInt(); 
				y = arquivo.nextInt();
				linha = arquivo.nextLine();
			while (arquivo.hasNext()) {
				for (int i = 0; i < y; i++) {
					linha = arquivo.nextLine(); 
					a = 0;
					b = 1;
					for (int k = 0; k < x; k++) {
						int valor = Integer.parseInt(linha.substring(a, b));
							matriz1[i][k] = valor;
						if (valor == 1) {
							matriz2[i][k] = 2; 
						}//fecha if
						if (valor == 0) {
							matriz3[i][k] = 2; 
						}//fecha if
						a++;
						b++;
					}//fecha for
				}//fecha for
			}//fecha while
			arquivo.close();
		}catch(Exception e){
			System.out.println("ERRO!");
		}//fecha-try-catch
		
	}//fecha metodo
	
	public static void verMatriz(int[][] vetor) {
			for (int i = 0; i < y; i++) {
				for (int k = 0; k < x; k++) {				
					System.out.print("|" + vetor[i][k] + "|");
			}//fecha for
			System.out.print("\n");
		}//fecha for
	}//fecha verMatriz

}//fecha classe