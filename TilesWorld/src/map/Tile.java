package map;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Tile {

	private BufferedImage tileSet;
	private int tileSize;
	
	public Tile(String nomeArquivo){
		try{
			this.tileSet = ImageIO.read(new File(nomeArquivo));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public BufferedImage getTile(int row, int col){
		return this.tileSet.getSubimage(col * tileSize, row * tileSize, tileSize, tileSize);
	}
	
	public void setTileSize(int size){
		this.tileSize = size;
	}
	
	
}
