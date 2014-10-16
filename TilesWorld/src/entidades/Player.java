package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mainGame.GamePanel;

public class Player extends Entity{

	private float dx;// posicao da direcao currentX
	private float dy;// posicao da direcao currentY
	private float maxX;
	private float minX;
	private float maxY;
	private float minY;

	private boolean direita;
	private boolean esquerda;
	private boolean pulando;
	private boolean caindo;
	private boolean correndo;
	
	private float defaultVelocity = 11.8f;
	private float maxVelocity = 25.9f;

	private Graphics2D g2d;

	// Metodos

	public Player() {
		this.currentX = 30;
		this.currentY = 11;
		//maxX = GamePanel.GAME_WIDTH / GamePanel.TILE_SIZE -1;
		//maxY = GamePanel.GAME_HEIGHT / GamePanel.TILE_SIZE -1;
		maxX = GamePanel.GAME_WIDTH;
		maxY = GamePanel.GAME_HEIGHT;
		minX = 0;
		minY = 0;
		this.correndo = false;
	}

	public void calcMovimento() {
		if(correndo)
			if(velocity < maxVelocity)
				velocity *= 1.5;
			else
				velocity = maxVelocity;
		else
			velocity = defaultVelocity;
		if (direita) {
			dx = currentX + velocity;
			if(dx > maxX){
				dx = maxX;
			}
			currentX = dx;
			direita = false;
		}
		if (esquerda) {
			dx = currentX - velocity;
			if(dx < minX){
				dx = minX;
			}
			currentX = dx;
			esquerda = false;
		}
		if (pulando) {
			dy = currentY - velocity;
			if(dy < minY){
				dy = minY;
			}
			currentY = dy;
			pulando = false;			
		}
		if (caindo) {
			dy = currentY + velocity;
			if(dy > maxY){
				dy = maxY;
			}
			currentY = dy;
			caindo = false;
		}
	}

	public void update(){
		calcMovimento();
	}
	
	public void draw(Graphics g) {
		this.g2d = (Graphics2D) g.create();

		g2d.setColor(Color.RED);
		/*g2d.fillRect((int)currentX * GamePanel.TILE_SIZE, (int)currentY * GamePanel.TILE_SIZE,
				GamePanel.TILE_SIZE, GamePanel.TILE_SIZE );*/

		g2d.fillRect((int)currentX, (int)currentY,
				GamePanel.TILE_SIZE, GamePanel.TILE_SIZE );
	}
	
	//Getters e Setters		
	public boolean isDireita() {return direita;}
	public void setDireita(boolean direita) {this.direita = direita;}
	public boolean isEsquerda() {return esquerda;}
	public void setEsquerda(boolean esquerda) {	this.esquerda = esquerda;}
	public boolean isPulando() {return pulando;}
	public void setPulando(boolean pulando) {this.pulando = pulando;}
	public boolean isCaindo() {	return caindo;}
	public void setCaindo(boolean caindo) {	this.caindo = caindo;}
	public boolean isCorrendo() {	return correndo;}
	public void setCorrendo(boolean correndo) {	this.correndo = correndo;}
	public float getPlayerX() {return currentX;}
	public float getPlayerY() {return currentY;}

}
