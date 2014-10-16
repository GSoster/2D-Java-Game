package mainGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import map.TileMap;
import ui.BasicUi;
import entidades.Player;
import entidades.PlayerEntity;

public class GamePanel extends JPanel implements KeyListener {

	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 720;
	public static final int TILE_SIZE = 32;
	private static final int FPS = 30;

	// 32 colunas e 22 linhas

	private boolean debug;

	private Graphics2D g2d;
	private TileMap map;
	//private Player player;
	private PlayerEntity playerEntity;	
	private BasicUi basicUi;

	private long startTime;
	private double estimatedTime;
	private double espectedTime = 1000 / FPS;

	// /////////

	public GamePanel() {
		super();
		this.map = new TileMap(GAME_WIDTH, GAME_HEIGHT, TILE_SIZE);
		//this.player = new Player();
		this.playerEntity = new PlayerEntity();
		this.basicUi = new BasicUi();
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}

	public void update() {
		//player.update();
		playerEntity.update();
	}

	public void draw(Graphics2D g) {
		this.map.draw(g);
		//this.player.draw(g);
		this.playerEntity.draw(g);
		// this.basicUi.draw(g);
	}

	public void gameLoop(Graphics g) {
		this.g2d = (Graphics2D) g;
		while (true) {
			this.startTime = System.nanoTime();

			this.update();
			this.draw(g2d);

			this.estimatedTime = (double) ((System.nanoTime() - startTime));
			if (estimatedTime < espectedTime) {
			} else {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		// calcular andando p/direita
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
			playerEntity.setGoingRight(true);//player.setDireita(true);
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
			playerEntity.setGoingLeft(true);//player.setEsquerda(true);
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
			playerEntity.setJumping(true);//player.setPulando(true);
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
			playerEntity.setFalling(true);//player.setCaindo(true);
		if (code == KeyEvent.VK_SHIFT) {
			playerEntity.setRunning(true);//player.setCorrendo(true);
			basicUi.setShift(true);
		}
		if (code == KeyEvent.VK_SPACE) {
			//player.setPulando(true);
		}

		// Debug
		if (code == KeyEvent.VK_G) {
			if (getDebug()) {
				setDebug(false);
			} else {
				setDebug(true);
			}
		}

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SHIFT){
			//player.setCorrendo(false);
			playerEntity.setRunning(false);
		}
		if(code == KeyEvent.VK_SPACE){
			//player.setPulando(false);
			playerEntity.setJumping(false);
		}
		basicUi.setShift(false);
		
		
		
	}
	
	

	public void setDebug(boolean debug) {
		this.debug = debug;
		map.setDebug(this.debug);
	}

	public boolean getDebug() {
		return this.debug;
	}

}
