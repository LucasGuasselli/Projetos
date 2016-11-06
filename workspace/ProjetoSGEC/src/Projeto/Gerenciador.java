package Projeto;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import com.senac.SimpleJava.Console;

public class Gerenciador {
	
	public static void main(String[] args) {
		try {
			(new Gerenciador()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}//fecha try-catch
	}//fecha main
	
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

	private void run() throws FileNotFoundException {
		
		//importando informacoes dos arquivos csv
		importarArquivo("src/arquivos/funcionarios.csv", func, parserFun, VetorFuncionarios);
		importarArquivo("src/arquivos/projetos.csv", proj, parserProj, VetorProjetos);
		importarArquivo("src/arquivos/competencias.csv", comp, parserComp, VetorCompetencias);
		importarArquivo("src/arquivos/colaboradores.csv", colab, parserColab, VetorColaboradores);

		Console.println("GERENCIADOR DE PROJETOS\n\nMENU:");

		Menu menu = new Menu();

		Opcao verFunc = new Opcao("Ver Funcionarios");
		Opcao verProj = new Opcao("Ver Projetos");
		Opcao verComp = new Opcao("Ver Competencias");
		Opcao verColab = new Opcao("Ver Colaboradores");
		Opcao deletFunc = new Opcao("Deletar Funcionarios");
		Opcao deletProj = new Opcao("Deletar Projetos");
		Opcao deletComp = new Opcao("Deletar Competencias");
		Opcao cadFunc = new Opcao("Cadastrar Funcionario");
		Opcao cadProj = new Opcao("Cadastrar Projeto");
		Opcao cadComp = new Opcao("Cadastrar Competencia");
		Opcao sair = new Opcao("Sair");

		menu.addOption(verFunc);
		menu.addOption(verProj);
		menu.addOption(verComp);
		menu.addOption(verColab);
		menu.addOption(deletFunc);
		menu.addOption(deletProj);
		menu.addOption(deletComp);
		menu.addOption(cadFunc);
		menu.addOption(cadProj);
		menu.addOption(cadComp);
		menu.addOption(sair);

		do {
			menu.show();

		switch (menu.getOption()) {
			case 1:
					System.out.println("\nRelação de Funcionários:\n");
					VetorFuncionarios.getVetor();
				break;
			case 2:
					System.out.println("\nRelação de Projetos:\n");
					VetorProjetos.getVetor();
				break;
			case 3:
					System.out.println("\nRelação de Competencias:\n");
					VetorCompetencias.getVetor();
				break;
			case 4:
					System.out.println("\nRelação de Colaboradores:\n");
					VetorColaboradores.getVetor();
				break;
			case 5:
					VetorFuncionarios.remove(Integer.parseInt(digita("Digite um indice do funcionario "
						+ "que deseja remover")));
				break;
			case 6:
				VetorProjetos.remove(Integer.parseInt(digita("Digite um indice do projeto "
					+ "que deseja remover")));
			break;
			case 7:
				VetorCompetencias.remove(Integer.parseInt(digita("Digite um indice da competencia "
						+ "que deseja remover")));
				break;
			case 8:
				 cadastraFuncionario();
			break;	
			case 9:
				cadastraProjetos();
			break;	
			case 10:
				cadastraCompetencias();
				break;
			default:
				System.exit(0);
			}//fecha switch
		} while (true);
	}//fecha run
	
	private void cadastraCompetencias() {
		Competencias objeto = new Competencias(digita("Informe a competencia: "));
		
		VetorCompetencias.append(objeto);
	}//fecha cadastraCompetencias

	private void cadastraProjetos() {
		try{
			Projetos objeto = new Projetos (digita("Informe nome do projeto: "),LocalDate.parse(digita("Informe a data de inicio: ")),
					LocalDate.parse(digita("Informe a data do fim")), Integer.parseInt(digita("Informe a quantidade de competencias")));
			
			objeto.insereCompetencias();
			VetorProjetos.append(objeto);
		}catch(Exception e){
			System.out.println("\nERRO AO CADASTRAR PROJETO!!\n");
		}//fecha try-catch
		
	}//fecha cadastraProjetos

	private void cadastraFuncionario(){
		try{
		Funcionarios objeto =	new Funcionarios (digita("Informe o nome do funcionario: "), 
				Double.parseDouble(digita("Informe o salario do funcionario: ")),
				Integer.parseInt(digita("Informe a quantidade de competencias")));
				
		objeto.insereCompetencias();
		
		VetorFuncionarios.append(objeto);
		}catch(Exception e){
			System.out.println("\nERRO AO CADASTRAR FUNCIONARIO!!\n");
		}//fecha try-catch
	}//fecha classe
	
	private String digita(String texto){
		Scanner ler  = new Scanner(System.in);
		System.out.println(texto);
			return ler.next();
	}//fecha digita
	
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
	
	private <V> void importarArquivo(String arquivo, V objeto, Parser parser,Vetor<V> vetor) throws FileNotFoundException {
		//Parser<Object> parse = new ObjectParser();
		CSVReader<V> reader = new CSVReader<>(arquivo, parser);
		reader.skipLine(); //se houver cabeçalho cabecalho
		
		while (reader.hasNext()) {
			objeto = reader.readObject();
			vetor.append(objeto);
		}//fecha while
		
		reader.close();
	}//fecha verArquivo
}//fecha classe