package Projeto;

import java.util.Scanner;

public class CompetenciasParser implements Parser<Competencias> {

	@Override
	public Competencias parse(String dados) {
			
			Scanner arquivo = new Scanner(dados);
			arquivo.useDelimiter(";");
			String nome = arquivo.next();
			
			Competencias  comp = new Competencias(nome);
			
			arquivo.close();
			return comp;
		}//fefecha metodo Competencias parse

}//fecha classe
