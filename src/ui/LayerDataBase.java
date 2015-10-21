package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 数据库窗口
 * @author arrayListTwo
 *
 */
public class LayerDataBase extends LayerData {
	
	/**
	 * 数据库图片的对象
	 */
	private static final Image IMAGE_DB = new ImageIcon("Graphics/string/db.png").getImage();

	/**
	 * 数据库图像对象的高度
	 */
	private static final int IMAGE_DB_H = IMAGE_DB.getHeight(null);
	
	public LayerDataBase(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		int rectHeight = (this.WINDOW_HEIGHT - (SIZE * 9) - IMAGE_DB_H) / 5;
		//绘制框架
		super.createWindow(g);
		//绘制数据库图像
		g.drawImage(IMAGE_DB, this.X_START + PADDING, this.Y_START + (SIZE << 1), null);
		//绘制经验值槽
		for (int i = 0; i < 5; i++) {
			this.drawExpRect(PADDING,
					(SIZE << 1) + IMAGE_DB_H + i * (SIZE + rectHeight),
					this.WINDOW_WIDTH - PADDING - (SIZE <<1), rectHeight, g);
		}
	}
	
}
