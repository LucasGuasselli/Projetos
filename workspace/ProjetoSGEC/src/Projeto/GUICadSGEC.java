package Projeto;

import java.io.FileNotFoundException;
import com.senac.SimpleJava.Console;

public class GUICadSGEC {
	

	Parser<Funcionarios> parserFun = new FuncionariosParser();
	Parser<Projetos> parserProj = new ProjetosParser();
	Parser<Competencias> parserComp = new CompetenciasParser();
	Parser<Colaboradores> parserColab = new ColaboradoresParser();
	
	Vetor<Funcionarios> VetorFuncionarios = new Vetor<>();
	Vetor<Projetos> VetorProjetos = new Vetor<>();
	Vetor<Competencias> VetorCompetencias = new Vetor<>();
	Vetor<Colaboradores> VetorColaboradores = new Vetor<>();
	
	Funcionarios func = null;
	Projetos proj = null;
	Competencias comp = null;
	Colaboradores colab = null;
	
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
				
				verArquivo("\nRelação de Funcionários:\n","src/arquivos/funcionarios.csv", func, parserFun, VetorFuncionarios);
				VetorFuncionarios.getVetor();
				break;
			case 2:
				
				verArquivo("\nRelação de Projetos:\n","src/arquivos/projetos.csv", proj, parserProj, VetorProjetos);
				VetorProjetos.getVetor();
				break;
			case 3:
				
				verArquivo("\nRelação de Competencias:\n","src/arquivos/competencias.csv", comp, parserComp, VetorCompetencias);
				VetorCompetencias.getVetor();
				break;
			case 4:
				
				verArquivo("\nRelação de Colaboradores:\n","src/arquivos/colaboradores.csv", colab, parserColab, VetorColaboradores);
				VetorColaboradores.getVetor();
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
	
	private <V> void verArquivo(String texto,String arquivo, V objeto, Parser parser,Vetor<V> vetor) throws FileNotFoundException {
		//Parser<Object> parse = new ObjectParser();
		CSVReader<V> reader = new CSVReader<>(arquivo, parser);
		reader.skipLine(); //se houver cabeçalho cabecalho
		System.out.println(texto);
		while (reader.hasNext()) {
			objeto = reader.readObject();
			vetor.append(objeto);
		}//fecha while
		System.out.println("---------------------------------------\n\n");
		reader.close();
	}//fecha verArquivo
}//fecha classe