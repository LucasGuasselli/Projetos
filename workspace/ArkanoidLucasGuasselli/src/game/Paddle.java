/*
 * @author Lucas Guasselli de Moraes
 * @date 17/09/2016
 * @version 1.0
 */
package game;

import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Sprite;

public class Paddle extends Sprite {

	public Paddle() {
		super(30, 5, Color.WHITE);		
	}//fecha construtor
	
	public void moveRight(){
		Point positionPaddle = super.getPosition();
		super.move(-5,0);
		if (positionPaddle.x < 2){
			super.move(5,0);
		}
	}//fecha moveRight
	
	public void moveLeft(){
		Point positionPaddle = super.getPosition();
		super.move(5,0);
		if (positionPaddle.x > 225){
			super.move(-5,0);
		}
	}//fecha moveLeft
	
public boolean bateu(Bola bola) {
		
		Point posBola = bola.getPosition();
						
		com.senac.SimpleJava.Graphics.Rect tamBola = getBounds(); 
		int cima = tamBola.y;
		int baixo = tamBola.y + tamBola.height;
		int esquerda = tamBola.x;
		int direita = tamBola.x + tamBola.width;
			
		if (posBola.x+getHeight() > direita) {
			return false;
		}else if(posBola.x+getHeight() < esquerda) {
			return false;
		}else if(posBola.y+getHeight() < cima) {
			return false;
		}else if(posBola.y+getHeight() > baixo) {
			return false;
		}else{		
			return true;	
		}
	}//fecha bateu
	
}//fecha classe
