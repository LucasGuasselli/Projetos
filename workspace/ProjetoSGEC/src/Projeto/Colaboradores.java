package Projeto;

public class Colaboradores {
	
	private String colab_projeto;
	private String colab_funcionario;
	private String colab_competencia;
	
	public Colaboradores(String projeto, String funcionario, String competencia){
		this.colab_projeto = projeto;
		this.colab_funcionario = funcionario;
		this.colab_competencia = competencia;
	}//fecha construtor
	
	@Override
	public String toString() {		
		return "Projeto: " + colab_projeto + 
				"\nFuncionario: " + colab_funcionario + 
				"\nCompetencia: " + colab_competencia + "\n";	 		
				
	}//fecha toString
	
}//fecha classe
