/*
 * @author Lucas Guasselli de Moraes
 * @date 17/09/2016
 * @version 1.0
 */
package game;

import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Sprite;

public class Bola extends Sprite {
	private int dy = 1;
	private int dx = 1;

	public Bola() {
		super(5,5,Color.GRAY);
	}//fecha construtor
	public void move() {
		super.move(dx, dy);
	}//fecha move
	public void invertHorizontal() {
		dx *= -1;
	}//fecha invertHorizontal
	public void invertVertical() {
		dy *= -1;
	}//fecha invertVertical	
}//fecha classe
