package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 本地磁盘窗口
 * @author arrayListTwo
 *
 */
public class LayerDisk extends LayerData {
	
	private static final Image IMAGE_DISK = new ImageIcon("Graphics/string/disk.png").getImage();
	
	private static final int IMAGE_DISK_H = IMAGE_DISK.getHeight(null);

	public LayerDisk(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
			
	@Override
	protected void createWindow(Graphics g) {
		int rectHeight = (this.WINDOW_HEIGHT - (SIZE * 9) - IMAGE_DISK_H) / 5;
		super.createWindow(g);
		g.drawImage(IMAGE_DISK, this.X_START + PADDING, this.Y_START + (SIZE << 1), null);
		//绘制经验值槽
		for (int i = 0; i < 5; i++) {
			this.drawExpRect(PADDING,
					(SIZE << 1) + IMAGE_DISK_H + i * (SIZE + rectHeight),
					this.WINDOW_WIDTH - PADDING - (SIZE <<1), IMAGE_DISK_H, g);
		}
	}

}
