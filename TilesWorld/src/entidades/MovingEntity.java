package entidades;

import java.awt.Graphics;
public class MovingEntity extends AbstractEntity{

	
	protected float velocity;
	protected float gravity;
	
	public float getVelocity(){
		return velocity;
	}
	public float getGravity(){
		return gravity;
	}
	
	public void update(){}
	
	public void draw(Graphics g){}
}
