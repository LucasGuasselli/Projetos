package Projeto;

import java.util.Scanner;

public class FuncionariosParser implements Parser<Funcionarios> {
	
	public Funcionarios parse(String dados) {
		
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome = arquivo.next();
		double salario = Double.parseDouble(arquivo.next());
		int num_competencias = Integer.parseInt(arquivo.next());
		
				Funcionarios func = new Funcionarios(nome, salario, num_competencias);
		
		for(int i = 0; i < num_competencias; i++){
			String comp = arquivo.next();
			func.ArmazenaCompetencias(i,comp);
		}//fecha for
		arquivo.close();
		return func;
	}//fecha funcionarios parse	
	
}//fecha classe
