package Projeto;
import com.senac.SimpleJava.Console;

public class Menu {

	Opcao[] opcoes = new Opcao[15];

	int numOpcoes = 0;

	public void addOption(Opcao opcao) {

		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}//fecha addOption

	public void show() {		
		for (int i = 0; i < numOpcoes; i++) {
			
				if(i==numOpcoes-1){
					Console.println("[", "0" , "] ",opcoes[i].getTexto());
				}else{
					Console.println("[", i+1 , "] ",opcoes[i].getTexto());
				}//fecha if-else
		}//fecha for
		Console.println("ESCOLHA UMA OPÇÃO: ");
	}//fecha show

	public int getOption() {
		int opcao = Console.readInt();
		return opcao;		
	}//fecha getOption

}//fecha classe
