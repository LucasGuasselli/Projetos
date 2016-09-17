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
	private Paddle paddle;
	
	private int quantidadeBloco = 10;
	
	private Bloco linha1[];
	private Bloco linha2[];
	private Bloco linha3[];
	

	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		bola.draw(canvas);
		
		
		paddle.draw(canvas);
		
		for(int i = 0; i < quantidadeBloco; i++){
			linha1[i].draw(canvas);
		}//fecha for
		for(int i = 0; i < quantidadeBloco; i++){
			linha2[i].draw(canvas);
		}//fecha for
		for(int i = 0; i < quantidadeBloco; i++){
			linha3[i].draw(canvas);
		}//fecha for
			
	}//fecha draw

	@Override
	protected void setup() {
		setResolution(Resolution.MSX);
		setFramesPerSecond(60);
	
		bola = new Bola();
		paddle = new Paddle();
		criaBlocos();		
		
		//posição inicial da bola
		bola.setPosition(Resolution.MSX.width / 2,Resolution.MSX.height / 2);
		
		//move paddle para esquerda		
		bindKeyPressed("LEFT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddle.moveRight();
			}
		});
		//move paddle para direita
		bindKeyPressed("RIGHT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddle.moveLeft();
			}
		});
		
		
	}//fecha setup

	@Override
	protected void loop() {
		//colisao da bola com a parede
		colidiuParede(bola);
		//colisao do paddle com a bola
		paddle.bateu(bola);
		//colisao do bloco com a bola
		for(int i = 0; i<quantidadeBloco; i++){
			linha1[i].bateu(bola);
				if(linha1[i].bateu(bola) == false){
					linha1[i].apagaBloco();					
				}//fecha if
		}//fecha for
		
		for(int i = 0; i<quantidadeBloco; i++){
			linha2[i].bateu(bola);
				if(linha2[i].bateu(bola) == false){
					linha2[i].apagaBloco();					
				}//fecha if
		}//fecha for
		
		for(int i = 0; i<quantidadeBloco; i++){
			linha3[i].bateu(bola);
				if(linha3[i].bateu(bola) == false){
					linha3[i].apagaBloco();
					
				}//fecha if
		}//fecha for
		bola.move();
		
		
		if(paddle.bateu(bola) == true){
			bola.invertVertical();
		}
		
		
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
	
	private void criaBlocos(){
		linha1 = new Bloco[quantidadeBloco];
		linha2 = new Bloco[quantidadeBloco];
		linha3 = new Bloco[quantidadeBloco];
		
		for(int i = 0; i < quantidadeBloco; i++){
			linha1[i] = new Bloco(Color.RED);
			int x = (i)*20+ 20;
			int y = 10;
			linha1[i].setPosition(x,y);
			
		}//fecha for
		
		for(int i = 0; i < quantidadeBloco; i++){
			linha2[i] = new Bloco(Color.GRAY);
			int x = (i)*20+ 20;
			int y = 30;
			linha2[i].setPosition(x,y);
			
		}//fecha for
		
		for(int i = 0; i < quantidadeBloco; i++){
			linha3[i] = new Bloco(Color.GREEN);
			int x = (i)*20+ 20;
			int y = 50;
			linha3[i].setPosition(x,y);
			
		}//fecha for
	}//fecha criaBlocos
	
}//fecha classe




