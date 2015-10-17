package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ±¾µØ´ÅÅÌ´°¿Ú
 * @author list
 *
 */
public class LayerDisk extends LayerData {
	
	private static final Image IMAGE_DISK = new ImageIcon("Graphics/string/disk.png").getImage();

	public LayerDisk(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
			
	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		g.drawImage(IMAGE_DISK, this.X_START + PADDING, this.Y_START + PADDING, null);
	}

}
