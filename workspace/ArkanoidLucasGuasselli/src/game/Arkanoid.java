/*
 * @author Lucas Guasselli de Moraes
 * @date 17/09/2016
 * @version 1.0
 */
package game;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.KeyboardAction;

public class Arkanoid extends GraphicApplication {
	
	private Bola bola;
	private Paddle paddle;
	
	private int estagio = 1;
	private int vidas = 3;
	
	private int recorde = 0;
	private int pontos = 0;
	private int armazenaPontos = 0;
	
	private int quantidadeBloco = 10;
	
	private Bloco linha1[] = new Bloco[quantidadeBloco];
	private Bloco linha2[] = new Bloco[quantidadeBloco];
	private Bloco linha3[] = new Bloco[quantidadeBloco];
	private Bloco linha4[] = new Bloco[quantidadeBloco];
	private Bloco linha5[] = new Bloco[quantidadeBloco];
	private Bloco linha6[] = new Bloco[quantidadeBloco];
	private Bloco linha7[] = new Bloco[quantidadeBloco];
	private Bloco linha8[] = new Bloco[quantidadeBloco];
	private Bloco linha9[] = new Bloco[quantidadeBloco];
	
	private Image background1, background2, background3;
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DRAW >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		if(estagio == 1){
			canvas.drawImage(background1, 0, 0);
		}else if(estagio == 2){
			canvas.drawImage(background2, 0, 0);
		}else if(estagio == 3){
			canvas.drawImage(background3, 0, 0);
		}//if-else
		
		canvas.setForeground(Color.BLUE);
		
		canvas.putText(262, 20, 10, ((String)"Score: ").toString());
		canvas.putText(262, 30, 10, ((Integer)pontos).toString());
		canvas.putText(262, 50, 10, ((String)"High Score: ").toString());
		canvas.putText(262, 60, 10, ((Integer)recorde).toString());	
		canvas.putText(262, 80, 10, ((String)"Vidas: ").toString());
		canvas.putText(295, 80, 10, ((Integer)vidas).toString());	
		canvas.putText(262, 95, 10, ((String)"|").toString());
		canvas.putText(262, 115, 10, ((String)"|").toString());
		canvas.putText(262, 135, 10, ((String)"|").toString());
		canvas.putText(262, 155, 10, ((String)"|").toString());
		canvas.putText(262, 175, 10, ((String)"|").toString());
		
		bola.draw(canvas);		
		paddle.draw(canvas);		
		
		if(estagio == 1){
			desenhaBloco(linha1, canvas);
			desenhaBloco(linha2, canvas);
			desenhaBloco(linha3, canvas);
		}else if(estagio == 2){
			desenhaBloco(linha4, canvas);
			desenhaBloco(linha5, canvas);
			desenhaBloco(linha6, canvas);
		}else if(estagio == 3){
			desenhaBloco(linha7, canvas);
			desenhaBloco(linha8, canvas);
			desenhaBloco(linha9, canvas);
		}//fecha else if		
		
	}//fecha draw

	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< SETUP >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Override
	protected void setup() {
		setResolution(Resolution.MODE_X);
		setFramesPerSecond(60);
	
		bola = new Bola();
		paddle = new Paddle();
		
		colocaImagens();
		//estagio 1
		criaBlocos(linha1, 25, Color.RED, 1);
		criaBlocos(linha2, 40, Color.RED, 1);
		criaBlocos(linha3, 55, Color.RED, 1);
		//estagio 2
		criaBlocos(linha4, 15, Color.BLUE, 1);
		criaBlocos(linha5, 40, Color.YELLOW, 5);
		criaBlocos(linha6, 55, Color.BLUE, 1);
		//estagio 3
		criaBlocos(linha7, 95, Color.GRAY, 3);
		criaBlocos(linha8, 15, Color.GRAY, 3);
		criaBlocos(linha9, 30, Color.GRAY, 3);
			
		iniciaJogo(linha1, linha2, linha3,1 ,1 ,1);
		
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

	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< LOOP >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Override
	protected void loop() {
		
		//colisao da bola com a parede
			colidiuParede(bola);
			
		//controla a colisao da bola com o paddle	
			colidiuPaddle(bola);
		
			bola.move();
			
		//controlam a morte e JOptionPane depois de tres mortes
			morte(bola, paddle);
			gameOver();
		
		//looping para controlar a morte dos blocos
		
			if(estagio == 1){
				controlaBloco(linha1);
				controlaBloco(linha2);
				controlaBloco(linha3);				
			}else if(estagio == 2){
				controlaBloco(linha4);
				controlaBloco(linha5);
				controlaBloco(linha6);
			}else if(estagio == 3){
				controlaBloco(linha7);
				controlaBloco(linha8);
				controlaBloco(linha9);
			}
		
		//controla a troca de estagio	
			controlaEstagio();			
		
			controlaRecorde();				
		redraw();
	}//fecha loop 
		
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private void iniciaJogo(Bloco[] linha, Bloco[] linha2, Bloco[] linha3,int vida1, int vida2, int vida3){
		//posi��o inicial da bola
			bola.setPosition(	Resolution.MSX.width / 2 ,
								Resolution.MSX.height / 2+ 10);
		
		//posicao inicia do paddle
			paddle.setPosition(	Resolution.MSX.width/2-5,
								Resolution.MSX.height-10
				);		
		
		for(int i = 0;i<quantidadeBloco; i++){
			linha[i].restauraBloco();
			linha[i].setVidaBloco(vida1);
		}//fecha for
		
		for(int i = 0;i<quantidadeBloco; i++){
			linha2[i].restauraBloco();
			linha2[i].setVidaBloco(vida2);
		}//fecha for
		
		for(int i = 0;i<quantidadeBloco; i++){
			linha3[i].restauraBloco();
			linha3[i].setVidaBloco(vida3);
		}//fecha for
	}//fecha iniciaJogo
	
	private void controlaEstagio(){
		if(pontos == 3000){
			pontos = pontos + 500;
			armazenaPontos = pontos;
			estagio++;
		}else if(pontos == 10500 ){
			pontos = pontos + 500;
			armazenaPontos = pontos;
			estagio++;
		}//fecha if else
		
	}//fecha controlaEstagio
	
	private void colidiuParede(Bola bola) {
		Point posicao = bola.getPosition();
		if (posicao.x < 0 || posicao.x >= Resolution.MSX.width-5){
			bola.invertHorizontal();
		}
		if (posicao.y < 0 || posicao.y >= Resolution.MSX.height-5) {
			bola.invertVertical();
		}//fecha if	
	}//fecha colidiubola
	
	private void colidiuPaddle(Bola bola){
		if(paddle.bateu(bola) == true){
			bola.invertVertical();
		}//fecha if
	}
	private void controlaRecorde(){
		if(pontos > recorde){
			recorde = pontos;
		}//fecha if
	}//fecha controla recorde
	
	private void colocaImagens(){
		try{
			background1 = new Image("Imagens/background1.jpg");
		}catch (IOException e) {
			e.printStackTrace(System.err);
				JOptionPane.showMessageDialog(
					null,
					"NAO FOI POSSIVEL CARREGAR A IMAGEM",
					"ERRO",
					JOptionPane.ERROR_MESSAGE);
		}//fecha try-catch
		
		try{
			background2 = new Image("Imagens/background2.jpg");
		}catch (IOException e) {
			e.printStackTrace(System.err);
				JOptionPane.showMessageDialog(
					null,
					"NAO FOI POSSIVEL CARREGAR A IMAGEM",
					"ERRO",
					JOptionPane.ERROR_MESSAGE);
		}//fecha try-catch	
		
		try{
			background3 = new Image("Imagens/background3.jpg");
		}catch (IOException e) {
			e.printStackTrace(System.err);
				JOptionPane.showMessageDialog(
					null,
					"NAO FOI POSSIVEL CARREGAR A IMAGEM",
					"ERRO",
					JOptionPane.ERROR_MESSAGE);
		}//fecha try-catch	
	}//fecha colocaImagens
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS (BLOCO) >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private void controlaBloco(Bloco[] linha){
		
		for(int i = 0; i<quantidadeBloco; i++){

			if(linha[i].bateu(bola)){
				
				pontos = pontos +100;
			}//fecha if						
		}//fecha for
	}//fecha controlaBloco
	
	private void desenhaBloco(Bloco[] linha, Canvas canvas){
		for(int i = 0; i < quantidadeBloco; i++){
			linha[i].draw(canvas);
		}//fecha for
	}//fecha desenhaBloco	
	
	private void criaBlocos(Bloco[] linha, int y, Color cor, int vida){
			
		for(int i = 0; i < quantidadeBloco; i++){
				linha[i] = new Bloco(cor, vida);
				int x = (i)*20+ 30;
				linha[i].setPosition(x,y);			
		}//fecha for		
		
	}//fecha criaBlocos	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< MORTE/GAMEOVER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
	private void morte(Bola bola, Paddle paddle){
		
		Point posBola = bola.getPosition();
		Point posPaddle = paddle.getPosition();
		
		if(posBola.y > posPaddle.y){
			vidas--;
			if(estagio == 1){
				iniciaJogo(linha1, linha2, linha3, 1, 1, 1);
				pontos = 0;
			}else if(estagio == 2){
				iniciaJogo(linha4, linha5, linha6, 1, 5, 1);
				pontos = armazenaPontos;
			}else if(estagio ==3){
				iniciaJogo(linha7,linha8, linha9, 3, 3, 3);
				pontos = armazenaPontos;
			}//fecha if else			
		}//fecha if	
	}//fecha morte
	
	private void gameOver(){
		if(vidas == 0){
			JOptionPane.showMessageDialog(
				null,
				"GAMEOVER",
				"YOU DIE!",
				JOptionPane.INFORMATION_MESSAGE);
			iniciaJogo(linha1, linha2, linha3, 1, 1, 1);
			vidas = 3;
			pontos = 0;
			estagio = 1;
		}//fecha if		
	}//fecha gameOver
	
}//fecha classe
