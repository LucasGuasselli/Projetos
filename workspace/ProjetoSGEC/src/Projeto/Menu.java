package Projeto;
import com.senac.SimpleJava.Console;

public class Menu {

	Opcao[] opcoes = new Opcao[10];

	int numOpcoes = 0;

	public void addOption(Opcao opcao) {

		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}//fecha addOption

	public void show() {		
		for (int i = 0; i < numOpcoes; i++) {
			Console.println("[", i+1 , "] ",opcoes[i].getTexto());
				if(i==numOpcoes-1){
					Console.println("[", "0" , "] ",opcoes[i].getTexto());
				}//fecha if
		}//fecha for
		Console.println("ESCOLHA UMA OP��O: ");
	}//fecha show

	public int getOption() {
		int opcao = Console.readInt();
		return opcao;		
	}//fecha getOption

}//fecha classe
