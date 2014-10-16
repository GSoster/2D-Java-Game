package entidades;

import java.awt.Graphics;

public abstract class MovingEntity extends AbstractEntity {

	protected float speed;
	protected float defaultSpeed;
	protected float maxSpeed;
	protected float minSpeed;
	protected float gravity;

	public float getSpeed() {
		return speed;
	}

	public float getGravity() {
		return gravity;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public float getMinSpeed() {
		return minSpeed;
	}


}
