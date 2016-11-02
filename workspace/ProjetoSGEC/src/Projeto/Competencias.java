package Projeto;

public class Competencias {
	
	private String nome;
		
	public Competencias(String nome) {
		this.nome = nome;
		
	}//fecha construtor

	@Override
	public String toString() {
		return "Competencia: " + nome + "\n";
	}//fecha toString

}//fecha classe
