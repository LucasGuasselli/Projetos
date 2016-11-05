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

	/*public Funcionarios cadastraFuncionario(String nome, double salario, int num_comp){
		System.out.println("chegou aqui");	
		Funcionarios func = new Funcionarios(nome, salario, num_comp);
		System.out.println("chegou aqui");		
		func.insereCompetencias();
		return func;
	}//fecha cadastraFuncionario
	*/
	
	public void insereCompetencias(){
		int opcao = 0;
		do{
			System.out.println("OPCOES");
			System.out.println("1- cadastra competencia (LIMITE - " + num_competencias + ")");
			System.out.println("0- encerra cadastro de competencia");
				opcao = ler.nextInt();
				if(opcao == 1 && indice < competencia.length){
					System.out.println("Informe a competencia: ");
						competencia[indice] = ler.next();
							indice++;
				}//fecha if
				if(opcao > 1 || opcao < 0){
					System.out.println("OPCAO INVALIDA!!");
				}//fecha if
			
		}while(opcao != 0);
		
	}//insere competencias
	
	public void ArmazenaCompetencias(int num, String comp) {
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
		return "Funcionario: " + nome + 
				"\nSalario: R$ " + salario + 
				"\nNumero de competencias: " + num_competencias +
				"\nCompetencias: " + mostraCompetencia()+ "\n";	 		
				
	}//fecha toString

}//fecha classe
