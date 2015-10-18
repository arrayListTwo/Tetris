package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 游戏等级窗口
 * @author arrayListTwo
 *
 */
public class LayerLevel extends Layer {
	
	/**
	 * 等级图片对象
	 */
	private static final Image IMAGE_LEVEL = new ImageIcon("Graphics/string/level.png").getImage();

	/**
	 * 数字图片对象
	 */
	private static final Image IMAGE_NUM = new ImageIcon("Graphics/string/num.png").getImage();
	
	/**
	 * 等级数字的最大位数
	 */
	private static final int maxCount = 3;
	
	/**
	 * 等级图片的宽度
	 */
	private static final int IMAGE_LEVEL_W = IMAGE_LEVEL.getWidth(null);
	
	/**
	 * 等级图片的高度
	 */
	private static final int IMAGE_LEVEL_H = IMAGE_LEVEL.getHeight(null);
	
	/**
	 * 每一个数字的宽度
	 */
	private static final int IMAGE_NUM_W = IMAGE_NUM.getWidth(null) / 10;
	
	/**
	 * 每一个数字的高度
	 */
	private static final int IMAGE_NUM_H = IMAGE_NUM.getHeight(null);
	
	public LayerLevel(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		//绘制等级图像
		g.drawImage(IMAGE_LEVEL, this.X_START + ((this.WINDOW_WIDTH - IMAGE_LEVEL_W) >> 1),
				this.Y_START + this.SIZE, null);
		this.drawLevel(((this.WINDOW_WIDTH - maxCount * IMAGE_NUM_W) >> 1),
				IMAGE_LEVEL_H + ((this.WINDOW_HEIGHT - IMAGE_LEVEL_H - IMAGE_NUM_H) >> 1),
				this.gameDto.getLevel(), maxCount, g);
	}
	
	/**
	 * 右对齐打印数字
	 * @param x 相对X坐标值
	 * @param y 相对Y坐标值
	 * @param num 打印出来的数字
	 * @param maxcount 打印出数字的最大位数
	 * @param g 画笔
	 */
	private void drawLevel(int x, int y, int num, int maxcount, Graphics g) {
		String numString = Integer.toString(num);
		for (int i = 0; i < maxcount; i++) {
			if(maxcount - i <= numString.length()){
				int bit = numString.charAt(numString.length() - maxcount + i) - '0';
				g.drawImage(IMAGE_NUM, this.X_START + this.SIZE + x + i * IMAGE_NUM_W, this.Y_START + this.SIZE + y,
						this.X_START + this.SIZE + x + (i + 1) * IMAGE_NUM_W, this.Y_START + this.SIZE + y + IMAGE_NUM.getHeight(null),
						bit * IMAGE_NUM_W, 0, (bit + 1) * IMAGE_NUM_W, IMAGE_NUM_H, null);
			}
		}
	}
	
}
