package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mainGame.GamePanel;

public class PlayerEntity extends MovingEntity {

	private Graphics2D g2d;
	private float width;
	private float height;
	private float dx;
	private float dy;

	private boolean goingRight;
	private boolean goingLeft;
	private boolean jumping;
	private boolean falling;
	private boolean running;

	public PlayerEntity() {
		this.maxSpeed = 36.8f;
		this.minSpeed = 10.786f;
		this.speed = 28;
		this.defaultSpeed = 28;
		this.currentX = GamePanel.GAME_WIDTH / 2;
		this.currentY = GamePanel.GAME_HEIGHT / 2;
		this.gravity = 13;
		this.width = 28;
		this.height = 42;

	}

	public boolean isGoigRight() {
		return goingRight;
	}

	public void setGoingRight(boolean right) {
		this.goingRight = right;
	}

	public boolean isGoingLeft() {
		return goingLeft;
	}

	public void setGoingLeft(boolean left) {
		this.goingLeft = left;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void update() {
		this.updateMovement();
	}

	public void draw(Graphics g) {
		this.g2d = (Graphics2D) g.create();
		g2d.setColor(Color.GREEN);
		g2d.fillRect((int) this.currentX, (int) this.currentY, (int) width,
				(int) height);

	}

	private void updateMovement(){
		if(running)
			speed = maxSpeed;
		else
			speed = defaultSpeed;
		
		if(goingRight){
			currentX += speed;
			goingRight = false;
		}
		if(goingLeft){
			currentX -= speed;
			goingLeft = false;
		}
		if(falling)
			currentY += speed;
		
		if(jumping)
			currentY -= speed;
	}
	
	
}
