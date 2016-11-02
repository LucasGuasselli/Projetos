package Projeto;

public class Competencias {
	private String nome;
	
	
	public Competencias(String nome) {
		this.nome = nome;
		
	}	

	@Override
	public String toString() {
		return "---------------------------------------\n"
			 + "Competencia\n [ " + nome + " ]";
	}

}
