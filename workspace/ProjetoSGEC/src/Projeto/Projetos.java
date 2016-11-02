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
	
	public void ArmazenaCompetencias(int num, String comp){
		if(num < 0 || num > competencia.length)
			throw new ArrayIndexOutOfBoundsException(num);
		this.competencia[num] = comp;
	}

	@Override
	public String toString() {
		return "Projeto: " + nome + 
				"\nInicio: " + data_inicio + 
				"\nFim: " + data_fim + 
				"\nNúmero de competencias: " + num_competencias +
				"\nCompetencias: " + competencia;
	}//fecha toString
}//fecha classe