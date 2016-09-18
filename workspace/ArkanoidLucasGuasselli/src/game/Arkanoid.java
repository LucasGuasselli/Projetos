/*
 * @author Lucas Guasselli de Moraes
 * @date 17/09/2016
 * @version 1.0
 */
package game;

import javax.swing.JOptionPane;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.KeyboardAction;

public class Arkanoid extends GraphicApplication {
	
	private Bola bola;
	private Paddle paddle;
	
	private int vidas = 3;
	private int pontos = 0;
	private int quantidadeBloco = 10;
	
	private Bloco linha1[];
	private Bloco linha2[];
	private Bloco linha3[];
	
	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		canvas.setBackground(Color.BLACK);
		canvas.setForeground(Color.BLUE);
		
		canvas.putText(262, 20, 9, ((String)"Pontuacao").toString());
		canvas.putText(262, 30, 10, ((Integer)pontos).toString());
		canvas.putText(262, 60, 10, ((String)"Vidas: ").toString());
		canvas.putText(295, 60, 10, ((Integer)vidas).toString());	
		
		bola.draw(canvas);		
		paddle.draw(canvas);		
		
		desenhaBloco(linha1, canvas);
		desenhaBloco(linha2, canvas);
		desenhaBloco(linha3, canvas);
		
	}//fecha draw

	@Override
	protected void setup() {
		setResolution(Resolution.MODE_X);
		setFramesPerSecond(60);
	
		bola = new Bola();
		paddle = new Paddle();
		criaBlocos(linha1 = new Bloco[quantidadeBloco], 25, Color.RED);
		criaBlocos(linha2 = new Bloco[quantidadeBloco], 40, Color.YELLOW);
		criaBlocos(linha3 = new Bloco[quantidadeBloco], 55, Color.GRAY);
		
		iniciaJogo();
		morte(bola, paddle);
		
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
		//movimento da bola
			bola.move();
		//controlam a morte e JOptionPane depois de tres mortes
			morte(bola, paddle);
			gameOver();
		//looping para controlar a morte dos blocos
			controlaBloco(linha1);
			controlaBloco(linha2);
			controlaBloco(linha3);
				
		if(paddle.bateu(bola) == true){
			bola.invertVertical();
		}//fecha if
		
		redraw();
	}//fecha loop 
		
	private void controlaBloco(Bloco[] linha){
		for(int i = 0; i<quantidadeBloco; i++){
			linha[i].bateu(bola);
				if(linha[i].bateu(bola) == false){
					linha[i].apagaBloco();					
			}//fecha if
		}//fecha for
	}//fecha controlaBloco
	
	private void adicionaPontos() {
		pontos = pontos + 100; 
		
	}//fecha adiciona pontos

	private void desenhaBloco(Bloco[] linha, Canvas canvas){
		for(int i = 0; i < quantidadeBloco; i++){
			linha[i].draw(canvas);
		}//fecha for
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
	
	private void criaBlocos(Bloco[] linha, int y, Color cor){
			
		for(int i = 0; i < quantidadeBloco; i++){
			linha[i] = new Bloco(cor);
			int x = (i)*20+ 30;
			linha[i].setPosition(x,y);			
		}//fecha for		
		
	}//fecha criaBlocos
	
	private void iniciaJogo(){
		//posição inicial da bola
			bola.setPosition(	Resolution.MSX.width / 2,
								Resolution.MSX.height / 2);
		
		//posicao inicia do paddle
			paddle.setPosition(	Resolution.MSX.width/2-5,
								Resolution.MSX.height-10
				);
		
		for(int i = 0;i<quantidadeBloco; i++){
			linha1[i].restauraBloco();
		}//fecha for
		
		for(int i = 0;i<quantidadeBloco; i++){
			linha2[i].restauraBloco();
		}//fecha for
		
		for(int i = 0;i<quantidadeBloco; i++){
			linha3[i].restauraBloco();
		}//fecha for
	}//fecha iniciaJogo
	
	private void morte(Bola bola, Paddle paddle){
		
		Point posBola = bola.getPosition();
		Point posPaddle = paddle.getPosition();
		
		if(posBola.y > posPaddle.y){
			vidas--;
			iniciaJogo();
		}//fecha if	
	}//fecha morte
	
	private void gameOver(){
		if(vidas == 0){
			JOptionPane.showMessageDialog(
				null,
				"GAMEOVER",
				"YOU DIE!",
				JOptionPane.INFORMATION_MESSAGE);
			vidas = 3;
		}//fecha if
		
	}//fecha gameOver
}//fecha classe




