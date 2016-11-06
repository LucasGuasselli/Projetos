package Projeto;

import java.time.LocalDate;
import java.util.Scanner;

public class Projetos {
	Scanner ler = new Scanner(System.in);
	
	private String nome;
	private String situacao;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private LocalDate hoje = LocalDate.now();
	private int num_competencias;
	private String[] competencia;
	private int indice = 0;
		
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
			if(i<num_competencias-1 ){
				comp = comp + competencia[i] + ", ";						
			}else{
				comp = comp + competencia[i] + ". ";	
			}//fecha if
		} //fecha for
				
		return comp;
	}//fecha mostraCompetencia
	
	public String situacaoProjeto(){
		if(data_inicio.isEqual(hoje) || data_inicio.isBefore(hoje) && data_fim.isAfter(hoje)){
			situacao = " projeto ativo\n"; 
		}else{
			situacao = " projeto inativo";
		}//if-else
		return situacao;
	}//fecha situacaoProjeto
	
	@Override
	public String toString() {
		return "Projeto: " + nome + 
				"\nSituacao: " + situacaoProjeto() +
				"\nInicio: " + data_inicio + 
				"\nFim: " + data_fim + 
				"\nNumero de competencias: " + num_competencias +
				"\nCompetencias: " + mostraCompetencia() + "\n";
	}//fecha toString

	public void insereCompetencias() {
do{
			
			System.out.println("Informe o nome da competencia: " + (indice+1));
				
				if(indice < competencia.length){
						competencia[indice] = ler.next();
							indice++;
				}//fecha if
						
		}while(indice < competencia.length);
		
	}//fecha cadastraProjeto
}//fecha classe