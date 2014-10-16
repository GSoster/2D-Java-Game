package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class TileMap {

	private int numOfRows;// y
	private int numOfCols;// x
	private int tileSize;
	private int map[][];
	private boolean debug;

	private int lastPlayerYPosition;
	private int lastPlayerXPostition;

	private Tile tile;
	private BufferedImage tiles[][];

	// ////////////////////////
	// 0 -> ceu/background (azul)
	// 1 -> grama (bloco verde)

	// ////////////////////////

	public TileMap(int width, int height, int tileSize) {
		this.tileSize = tileSize;
		this.numOfCols = width / tileSize;
		this.numOfRows = height / tileSize;
		//this.tile = new Tile("src/tileset.gif");
		this.tile = new Tile("src/sprite.png");
		this.tile.setTileSize(32);
		loadMap();
		loadTiles();
	}

	
	public void loadTiles(){
		tiles = new BufferedImage[2][12];
		//grama
		//this.tiles[1][0] = tile.getTile(1, 0);
		this.tiles[1][0] = tile.getTile(19, 10);
		//piso
		this.tiles[1][1] = tile.getTile(23, 9);			
	}
	
	public TileMap(int width, int height) {
		this.numOfCols = width;
		this.numOfRows = height;
	}

	// metodo responsavel por carregar o mapa
	public void loadMap() {
		// mapa [y][x]
		map = new int[numOfRows][numOfCols];
		for (int x = 0; x < numOfCols; x++) {
			map[19][x] = 2;
			map[20][x] = 1;
			map[21][x] = 1;			
		}
	}

	public void setPlayerPosition(int x, int y) {
		lastPlayerXPostition = x;
		lastPlayerYPosition = y;
		this.map[y][x] = -1;
	}

	// Metodo responsavel gerar a parte grafica
	public void draw(Graphics2D g) {
		// percorre o y
		for (int y = 0; y < numOfRows; y++) {
			// percorre o x
			for (int x = 0; x < numOfCols; x++) {
				switch (map[y][x]) {
				// azul (backGround)
				case 0:
					g.setColor(Color.BLUE);
					g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
					break;
				// terra
				case 1:					
					g.drawImage(tiles[1][0], x * tileSize, y * tileSize,
							tileSize, tileSize, null);
					break;
				case 2:
					g.drawImage(tiles[1][1],x * tileSize, y * tileSize,
							tileSize, tileSize, null);
					break;				
				}
				// Debugging
				if (this.debug) {
					g.setColor(Color.RED);
					g.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
				}
			}
		}		
	}

	// Getters e Setters

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public int getNumOfCols() {
		return this.numOfCols;
	}

	public int getNumOfRows() {
		return this.numOfRows;
	}

}
