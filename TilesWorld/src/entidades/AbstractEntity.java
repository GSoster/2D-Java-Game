package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import components.GameComponent;

abstract class AbstractEntity implements EntityInterface, Serializable {

	private boolean solid;
	private boolean blocked;
	protected float currentX;
	protected float currentY;
	protected ArrayList<GameComponent> components;

	public float getX() {
		return currentX;
	}

	public float getY() {
		return currentY;
	}

	public boolean isBlocked() {
		return this.blocked;
	}

	public boolean isSolid() {
		return this.solid;
	}

	
}
