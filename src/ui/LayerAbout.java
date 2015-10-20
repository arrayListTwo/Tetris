package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 版权信息的窗口
 * @author arrayListTwo
 *
 */
public class LayerAbout extends Layer {
	
	private static final Image IMAGE_ABOUT = new ImageIcon("Graphics/string/sign.png").getImage();

	public LayerAbout(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		g.drawImage(IMAGE_ABOUT, this.X_START + SIZE, this.Y_START + SIZE, this.WINDOW_WIDTH, this.WINDOW_HEIGHT, null);
	}

}
