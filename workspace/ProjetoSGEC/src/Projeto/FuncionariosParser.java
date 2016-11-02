package Projeto;

import java.util.Scanner;

public class FuncionariosParser implements Parser<Funcionarios> {
	
	public Funcionarios parse(String dados) {
		
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome = arquivo.next();
		String salario = arquivo.next();
		int num_competencias = Integer.parseInt(arquivo.next());
		
				Funcionarios f = new Funcionarios(nome, salario, num_competencias);
		
		for(int i = 0; i < num_competencias; i++){
			String comp = arquivo.next();
			f.ArmazenaCompetencias(i,comp);
		}//fecha for
		arquivo.close();
		return f;
	}//fecha funcionarios parse	
	
}//fecha classe
