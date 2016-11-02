package Projeto;

import java.time.LocalDate;

public class Projetos {
	
	private String nome;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private int num_competencias;
	private String[] competencia;
		
	public Projetos(String nome, LocalDate data_inicio, LocalDate data_fim,
			int num_competencias){
		this.nome = nome;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.num_competencias = num_competencias;
		this.competencia = new String[this.num_competencias];
	}//fecha construtor
	
	public void armazenaCompetencias(int num, String comp){
		if(num < 0 || num > competencia.length)
			throw new ArrayIndexOutOfBoundsException(num);
		this.competencia[num] = comp;
	}//fecha armazenaCompetencias

	public String mostraCompetencia(){
		String comp = "";
		
		for (int i=0;i<num_competencias;i++) {
			if(i<num_competencias){
				comp = comp + competencia[i] + ", ";						
			}//fecha if
			if(i == num_competencias-1){
				comp = comp + competencia[i] + ". ";	
			}//fecha if
		} //fecha for
				
		return comp;
	}//fecha mostraCompetencia
	
	@Override
	public String toString() {
		return "Projeto: " + nome + 
				"\nInicio: " + data_inicio + 
				"\nFim: " + data_fim + 
				"\nNumero de competencias: " + num_competencias +
				"\nCompetencias: " + mostraCompetencia() + "\n";
	}//fecha toString
}//fecha classe