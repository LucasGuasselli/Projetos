package Projeto;

public class Funcionarios {
	private String nome;
	private String salario;
	private int num_competencias;
	private String[] competencia;
	
	
	public Funcionarios(String nome, String salario, int num_competencias) {
		this.nome = nome;
		this.salario = salario;
		this.num_competencias = num_competencias;
		this.competencia = new String[this.num_competencias];
	}//fecha construtor	

	
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
				"\nSalario: " + salario + 
				"\nNúmero de competencias: " + num_competencias +
				"\nCompetencias: " + mostraCompetencia()+ "\n";	 		
				
	}//fecha toString

}//fecha classe
