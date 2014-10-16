package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import mainGame.GamePanel;

public class PlayerEntity extends MovingEntity {

	private Graphics2D g2d;
	private float width;
	private float height;
	private float dx;
	private float dy;
	private float jumpSpeed = -20;

	private boolean goingRight;
	private boolean goingLeft;
	private boolean jumping;
	private boolean falling;
	private boolean running;

	// animacoes
	private Animation animation;
	private BufferedImage[] flyingSprites;
	private boolean facingLeft; // todos os sprites foram feitos olhando
								// p/direita

	public PlayerEntity() {
		this.maxSpeed = 36.8f;
		this.minSpeed = 10.786f;
		this.speed = 29;
		this.defaultSpeed = 28;
		this.currentX = GamePanel.GAME_WIDTH / 2;
		this.currentY = GamePanel.GAME_HEIGHT / 2;
		this.gravity = 4.64f;
		this.width = 28;
		this.height = 42;

		try {
			flyingSprites = new BufferedImage[8];
			// carregar imagens
			
			flyingSprites[0] = ImageIO.read(new File("src/graphics/player/raven0.png"));
			flyingSprites[1] = ImageIO.read(new File("src/graphics/player/raven1.png"));
			flyingSprites[2] = ImageIO.read(new File("src/graphics/player/raven2.png"));
			flyingSprites[3] = ImageIO.read(new File("src/graphics/player/raven3.png"));
			flyingSprites[4] = ImageIO.read(new File("src/graphics/player/raven4.png"));
			flyingSprites[5] = ImageIO.read(new File("src/graphics/player/raven5.png"));
			flyingSprites[6] = ImageIO.read(new File("src/graphics/player/raven6.png"));
			flyingSprites[7] = ImageIO.read(new File("src/graphics/player/raven7.png"));
			
			animation = new Animation();
			animation.setFrames(flyingSprites);
			facingLeft = false; //p/saber p/onde o player esta olhando
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		//g2d.fillRect((int) this.currentX, (int) this.currentY, (int) width,(int) height);		
		//g2d.drawImage(flyingSprites[4],(int)this.currentX, (int)this.currentY, null);		
		g2d.drawImage(animation.getImage(),(int)this.currentX, (int)this.currentY, null);

	}

	private void updateMovement() {
		if (running)
			speed = maxSpeed;
		else
			speed = defaultSpeed;

		if (goingRight) {
			currentX += speed;
			//goingRight = false;
		}
		if (goingLeft) {
			currentX -= speed;
			//goingLeft = false;
		}		
		if (jumping) {
			currentY += jumpSpeed;
			falling = true;
			jumping = false;
		}

		if (falling)
			currentY += gravity;

		if(goingLeft || goingRight){
			animation.setFrames(flyingSprites);
			animation.setDelay(100);
		}

		animation.update();
	}

}
