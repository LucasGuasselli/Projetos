package Projeto;
import com.senac.SimpleJava.Console;

public class Menu {

	Opcao[] opcoes = new Opcao[5];

	int numOpcoes = 0;

	public void addOption(Opcao opcao) {

		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}

	public void show() {		
		for (int i = 0; i < numOpcoes; i++) {
			Console.println("[", i+1 , "] ",opcoes[i].getTexto());
		}
		Console.println("ESCOLHA UMA OPÇÃO: ");
	}

	public int getOption() {
		int opcao = Console.readInt();
		return opcao;		
	}

}
