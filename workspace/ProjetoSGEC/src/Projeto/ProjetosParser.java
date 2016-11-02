package Projeto;

import java.time.LocalDate;
import java.util.Scanner;

public class ProjetosParser implements Parser<Projetos> {
	
	public Projetos parse(String dados) {
		
		Scanner projeto = new Scanner(dados);
		projeto.useDelimiter(";");
					
		String nome = projeto.next();	
		LocalDate data_inicio = LocalDate.parse(projeto.next());
		LocalDate data_fim = LocalDate.parse(projeto.next());
		int num_competencias = Integer.parseInt(projeto.next());
		
		Projetos p = new Projetos(nome, data_inicio, data_fim, num_competencias);
		
		for(int i = 0; i < num_competencias; i++){
			String comp = projeto.next();
			p.ArmazenaCompetencias(i,comp);
		}//fecha for
		
		
		projeto.close();
		return p;
	}
}