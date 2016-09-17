package game;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;
import com.senac.SimpleJava.Graphics.events.KeyboardAction;

public class Arkanoid extends GraphicApplication {

	private Bola bola;
	private Sprite bloco;
	private Paddle paddle;
	private boolean desenhaBloco=true;

	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		bola.draw(canvas);
		
		if(desenhaBloco){
			bloco.draw(canvas);
		}
		
		paddle.draw(canvas);
		
	}//fecha draw

	@Override
	protected void setup() {
		setResolution(Resolution.MSX);
		setFramesPerSecond(60);
		
		bola = new Bola();
		
		bloco = new Sprite(18,10,Color.RED);
		
		paddle = new Paddle();
		
		
		
		bindKeyPressed("LEFT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddle.moveRight();
			}
		});
		bindKeyPressed("RIGHT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddle.moveLeft();
			}
		});
	}//fecha setup

	@Override
	protected void loop() {
		colidiuParede(bola);
		paddle.bateu(bola);
		
		
		bola.move();
		
		Point position = bola.getPosition();
		Point blocoPosition = bloco.getPosition();
		
		if(paddle.bateu(bola) == true){
			bola.invertVertical();
		}
		if(position.x+bola.getWidth() < blocoPosition.x){
			desenhaBloco=true;
			// n�o bateu 
		}
		
		else if(position.x > blocoPosition.x+bloco.getWidth() ){
			desenhaBloco=true;
			// n�o bateu
		}
		else if(position.y+bola.getHeight() < blocoPosition.y){
			desenhaBloco=true;
			// n�o bateu
		}
		else if(position.y > blocoPosition.y+bloco.getHeight()){
			desenhaBloco=true;
			// n�o bateu
		}
		else
			desenhaBloco = false;
		
		redraw();
	} 
	
	private void colidiuParede(Bola bola) {
		Point posicao = bola.getPosition();
		if (posicao.x < 0 || posicao.x >= Resolution.MSX.width-5){
			bola.invertHorizontal();
		}
		if (posicao.y < 0 || posicao.y >= Resolution.MSX.height-5) {
			bola.invertVertical();
		}//fecha if	
	}//fecha colidiubola
	
	
}//fecha classe




