package Projeto;

import java.io.FileNotFoundException;
import com.senac.SimpleJava.Console;

public class GUICadSGEC {
	
	Parser<Funcionarios> parserFun = new FuncionariosParser();
	Parser<Projetos> parserProj = new ProjetosParser();
	Parser<Competencias> parserComp = new CompetenciasParser();
	Parser<Colaboradores> parserColab = new ColaboradoresParser();
	
	public static void main(String[] args) {
		try {
			(new GUICadSGEC()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}//fecha try-catch
	}//fecha main

	private void run() throws FileNotFoundException {
		Console.println("GERENCIADOR DE PROJETOS\n\nMENU:");

		Menu menu = new Menu();

		Opcao verFunc = new Opcao("Ver Funcionarios");
		Opcao verProj = new Opcao("Ver Projetos");
		Opcao verComp = new Opcao("Ver Competencias");
		Opcao verColab = new Opcao("Ver Colaboradores");
		Opcao sair = new Opcao("Sair");

		menu.addOption(verFunc);
		menu.addOption(verProj);
		menu.addOption(verComp);
		menu.addOption(verColab);
		menu.addOption(sair);

		do {
			menu.show();

			switch (menu.getOption()) {
			case 1:
				Funcionarios func = null;
				verArquivo("\nRelação de Funcionários:\n","src/arquivos/funcionarios.csv", func, parserFun);
				break;
			case 2:
				Projetos proj = null;
				verArquivo("\nRelação de Projetos:\n","src/arquivos/projetos.csv", proj, parserProj);
				System.out.print("chegou aqui");
				break;
			case 3:
				Competencias comp = null;
				verArquivo("\nRelação de Competencias:\n","src/arquivos/competencias.csv", comp, parserComp);
				break;
			case 4:
				Colaboradores colab = null;
				verArquivo("\nRelação de Colaboradores:\n","src/arquivos/colaboradores.csv", colab, parserColab);
			default:
				System.exit(0);
			}//fecha switch
		} while (true);
	}//fecha run

	
	//VETOR
	/*//saber lugar do vetor
	 * En = E0 + i * T
	 * public class Vetor <T extends Comparable<T>>
	public void insetOrdenado (T valor){
		append(valor);
		
		for(int i = numElementos-1; i>0;i--){
			if(dados[i] < dados[i-1]){
				T troca = dados[i];
				dados[i] = dados[i-1];
				dados[i-1] = troca;
			}
		}
	}	
		*/
	
	private <T> void verArquivo(String texto,String arquivo, Object objeto, Parser parser) throws FileNotFoundException {
		//Parser<Object> parse = new ObjectParser();
		CSVReader<T> reader = new CSVReader<>(arquivo, parser);
		reader.skipLine(); //se houver cabeçalho cabecalho
		System.out.println(texto);
		while (reader.hasNext()) {
			objeto = reader.readObject();
			System.out.println(objeto);
		}//fecha while
		System.out.println("---------------------------------------\n\n");
		reader.close();
	}//fecha verArquivo
}//fecha classe