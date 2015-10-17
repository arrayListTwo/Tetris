package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Êý¾Ý¿â´°¿Ú
 * @author list
 *
 */
public class LayerDataBase extends LayerData {
	
	private static final Image IMAGE_DB = new ImageIcon("Graphics/string/db.png").getImage();

	public LayerDataBase(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		g.drawImage(IMAGE_DB, this.X_START + PADDING, this.Y_START + PADDING, null);
	}
	
}
