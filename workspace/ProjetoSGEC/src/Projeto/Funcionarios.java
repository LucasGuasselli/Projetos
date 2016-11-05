package Projeto;

import java.util.Scanner;

public class Funcionarios {
	Scanner ler = new Scanner(System.in);
	
	private String nome;
	private Double salario;
	private int num_competencias;
	private String[] competencia;
	private int indice = 0;
	
	
	public Funcionarios(String nome, Double salario, int num_competencias) {
		this.nome = nome;
		this.salario = salario;
		this.num_competencias = num_competencias;
		this.competencia = new String[this.num_competencias];
	}//fecha construtor	

		
	public void insereCompetencias(){
		
		do{
			
			System.out.println("Informe o nome da competencia: " + (indice+1));
				
				if(indice < competencia.length){
						competencia[indice] = ler.next();
							indice++;
				}//fecha if
						
		}while(indice < competencia.length);
		
	}//insere competencias
	
	public void ArmazenaCompetencias(int num, String comp) {
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
	
	
	@Override
	public String toString() {		
		return "Funcionario: " + nome + 
				"\nSalario: R$ " + salario + 
				"\nNumero de competencias: " + num_competencias +
				"\nCompetencias: " + mostraCompetencia()+ "\n";	 		
				
	}//fecha toString

}//fecha classe
