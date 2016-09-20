/*
 * @author Lucas Guasselli de Moraes
 * @date 17/09/2016
 * @version 1.0
 */
package game;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Sprite;

public class Bloco extends Sprite {
	
	private boolean desenhaBloco=true;
	private int vidaBloco = 0; 
	
	public Bloco(Color cor, int vida) {
		super(15, 10,cor);
		vidaBloco = vida;
	}//fecha construtor
	
	public void setVidaBloco(int vida){
		this.vidaBloco = vida;
	}
	
	public boolean bateu(Bola bola){
		Point posBola = bola.getPosition();
		Point posBloco = super.getPosition();
		
		if(!desenhaBloco){
			return false;
		}//fecha if
			
		if(posBola.x+bola.getWidth() < posBloco.x){
			return false;
			// não bateu
		}		
		else if(posBola.x > posBloco.x+getWidth() ){
			return false;
			// não bateu
		}
		else if(posBola.y+bola.getHeight() < posBloco.y){
			return false;
			// não bateu
		}
		else if(posBola.y > posBloco.y+getHeight()){
			return false;
			// não bateu
		}
		else{			
			vidaBloco--;
				if(vidaBloco == 0){
					desenhaBloco = false;
						return true;
				}//fecha if				
			return true;	
		}//fecha if-else
	} //fecha bateu

	
	public void draw(Canvas canvas){
		if(desenhaBloco == true){
			super.draw(canvas);
	}//fecha if
	}//fecha draw
	
	public void restauraBloco(){
		desenhaBloco = true;
	}//fecha restauraBloco
}//fecha classe
