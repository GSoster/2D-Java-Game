package entidades;

import java.awt.Graphics;

public interface EntityInterface {

	
	
	/**
	 * metodo que toda entidade deve ter, responsavel por
	 * criar a representacao grafica da entidade;
	 * @param g
	 */
	public void draw(Graphics g);
	
	/**
	 * Metodo responsavel por atualizar os status (posicao, etc.)
	 * da entidade.
	 */
	public void update();
	
	/**
	 * verifica se o objeto representado pela entidade eh solido
	 * @return boolean
	 */
	public boolean isSolid();
	
	/**
	 * verifica se o objeto representado pela entidade esta bloqueado
	 * @return
	 */
	public boolean isBlocked();
	
}
