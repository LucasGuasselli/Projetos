package game;

import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;
import com.senac.SimpleJava.Graphics.Rect;

public class Paddle extends Sprite {

	public Paddle() {
		super(30, 5, Color.BLUE);
		super.setPosition(
				Resolution.MSX.width/2-5,
				Resolution.MSX.height-10
				);
	}//fecha construtor
	

	public void moveRight(){
		Point positionPaddle = super.getPosition();
		super.move(-3,0);
		if (positionPaddle.x < 2){
			super.move(3,0);
		}
	}//fecha moveRight
	
	public void moveLeft(){
		Point positionPaddle = super.getPosition();
		super.move(3,0);
		if (positionPaddle.x > 225){
			super.move(-3,0);
		}
	}//fecha moveLeft
	
public boolean bateu(Bola bola) {
		
		Point posBola = bola.getPosition();
		Point posPaddle = super.getPosition();
				
		com.senac.SimpleJava.Graphics.Rect tamBola = getBounds(); 
		int cima = tamBola.y;
		int baixo = tamBola.y + tamBola.height;
		int esquerda = tamBola.x;
		int direita = tamBola.x + tamBola.width;
		
		String local;
		if (posBola.x+4 > direita) {
			return false;
		}                     
		if(posBola.x+4 < esquerda) {
			return false;
		}
		if(posBola.y+4 < cima) {
			return false;
		}
		if(posBola.y+4 > baixo) {
			return false;
		}		
		return true;		
	}//fecha bateu
	
}//fecha classe
