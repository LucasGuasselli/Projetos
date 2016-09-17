package game;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Sprite;

public class Bloco extends Sprite {

	private boolean desenhaBloco=true;
	
	
	public Bloco(Color cor) {
		super(15, 10,cor);
	}//fecha construtor



	public boolean bateu(Bola bola){
		Point posBola = bola.getPosition();
		Point posBloco = super.getPosition();
		
		if(!desenhaBloco){
			return false;
		}//fecha if
			
		if(posBola.x+bola.getWidth() < posBloco.x){
			return true;
			// não bateu
		}
		
		else if(posBola.x > posBloco.x+getWidth() ){
			return true;
			// não bateu
		}
		else if(posBola.y+bola.getHeight() < posBloco.y){
			return true;
			// não bateu
		}
		else if(posBola.y > posBloco.y+getHeight()){
			return true;
			// não bateu
		}
		else{
			desenhaBloco = false;
			bola.invertVertical();
			return false;
		}//fecha if-else
	} //fecha bateu

	
	public void draw(Canvas canvas){
		if(desenhaBloco == true){
			super.draw(canvas);
	}//fecha if
	}//fecha draw
	
	public void apagaBloco(){
		desenhaBloco = false;
	}//fcha apagabloco
}//fecha classe
