package Projeto;

public class Vetor <V> {
	@SuppressWarnings("unchecked")
	private V[] dados = (V[]) new Object[6];
	private int numeroElementos = 0;
	
	
	public void append(V valor){
		aumentaEspaco();
		dados[numeroElementos] = valor;
		numeroElementos++;
	}//fecha append

	private void aumentaEspaco() {
		if(numeroElementos >= dados.length){
			@SuppressWarnings("unchecked")
			V[] novo = (V[]) new Object[dados.length*2];
			for (int i = 0; i < dados.length; i++) {
				novo[i] = dados[i];
			}
			dados = novo;
		}//fecha if
		
	}//fecha aumentaEspaco
	
	public V get(int index){
		validaIndex(index);
		
		return dados[index];
	}//fecha get
	
	public void getVetor(){
		for(int i = 0; i < dados.length; i++){
			if(dados[i] != null){
				System.out.println("indice: " + i + "\n");
				System.out.println(dados[i]);
			}//fecha if
		}//fecha for
	}//fecha getVetor
	
	public int size() {
		return numeroElementos;
	}//fecha size

	public void insert(int index, V valor) {
		validaIndex(index);
		aumentaEspaco();
		for(int i = numeroElementos; i > index; i--){
			dados[i] = dados[i-1];			
		}
		dados[index] = valor;
		numeroElementos++;
	}//fecha insert

	private void validaIndex(int index) {
		if(index < 0 || index >= dados.length){
			throw new ArrayIndexOutOfBoundsException(index);
		} 
	}//fecha validaIndex
	
	public void remove(int index) {
		validaIndex(index);
		for (int i = index; i < numeroElementos; i++) {
				if(dados[i+1] == null){
					dados[i] = null;
				}else{
				dados[i] = dados[i+1];
				}//fecha if-else
		}
		numeroElementos--;
	}//fecha remove
	
	
}//fecha classe