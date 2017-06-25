package util;



public class Menu {
	
	
	Opcao[] opcoes = new Opcao[15];

	int numOpcoes = 0;

	public void addOption(Opcao opcao) {

		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}//fecha addOption

	public void show() {		
		for (int i = 0; i < numOpcoes; i++) {
			
				if(i==numOpcoes-1){
					System.out.println("[" + "0" + "] " +  opcoes[i].getTexto());
				}else{
					System.out.println("[" + (i+1) + "] " + opcoes[i].getTexto());
				}//fecha if-else
		}//fecha for
		System.out.println("ESCOLHA UMA OPÇÃO: ");
	}//fecha show

	public int getOption() {
		Digita d = new Digita();
			int opcao = Integer.parseInt(d.Digita(""));
				return opcao;		
}//fecha getOption
}//fecha menu
