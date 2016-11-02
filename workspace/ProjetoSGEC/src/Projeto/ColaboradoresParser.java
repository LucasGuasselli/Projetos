package Projeto;

import java.util.Scanner;

public class ColaboradoresParser implements Parser<Colaboradores> {

	public Colaboradores parse(String dados) {
		
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome = arquivo.next();
		String funcionario = arquivo.next();
		String competencia  = arquivo.next();
			
		Colaboradores colab = new Colaboradores(nome, funcionario, competencia);
		
			arquivo.close();
			return colab;
	}//fecha funcionarios parse	
}//fecha classe
