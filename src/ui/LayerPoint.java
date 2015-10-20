package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 游戏分数窗口
 * @author arrayListTwo
 *
 */
public class LayerPoint extends Layer {
	
	/**
	 * 经验值槽对象
	 */
	private static final Image IMAGE_RECT = new ImageIcon("Graphics/window/rect.png").getImage();
	
	/**
	 * 经验值槽图像的高度
	 */
	private static final int IMAGE_RECT_H = IMAGE_RECT.getHeight(null);
	
	/**
	 * 经验值槽图像的宽度
	 */
	private static final int IMAGE_RECT_W = IMAGE_RECT.getWidth(null);
	
	/**
	 * 分数图像对象
	 */
	private static final Image IMAGE_POINT = new ImageIcon("Graphics/string/point.png").getImage();
	
	/**
	 * 分数图像的高度
	 */
	private static final int IMAGE_POINT_H = IMAGE_POINT.getHeight(null);
	
	/**
	 * 消行图像对象
	 */
	private static final Image IMAGE_LINE = new ImageIcon("Graphics/string/rmline.png").getImage();
	
	/**
	 * 消行图像的高度
	 */
	private static final int IMAGE_LINE_H = IMAGE_LINE.getHeight(null);
	
	public LayerPoint(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		//绘制分数和消行
		this.disPlay(g);
		//绘制值槽
		this.drawExpRect(this.PADDING, (SIZE << 2) + IMAGE_POINT_H + IMAGE_LINE_H,
				this.WINDOW_WIDTH - this.PADDING - (SIZE << 1),
				this.WINDOW_HEIGHT - (SIZE * 6) - (IMAGE_POINT_H + IMAGE_LINE_H), g);
	}
	
	/**
	 * 绘制分数和消行
	 * @param g 画笔
	 */
	private void disPlay(Graphics g){
		//分数和消行显示的最多数
		int maxCount = 5;
		//绘制分数图像
		g.drawImage(IMAGE_POINT, this.X_START + this.PADDING, this.Y_START + (SIZE << 1), null);
		//绘制消行图像
		g.drawImage(IMAGE_LINE, this.X_START + this.PADDING, this.Y_START + (SIZE * 3) + IMAGE_POINT_H, null);
		//分数和消行数字的相对X坐标
		int xPoint = this.WINDOW_WIDTH - (SIZE * 3) - IMAGE_NUM_W * maxCount;
		//绘制分数
		this.drawNum(xPoint, SIZE, this.gameDto.getPoint(), maxCount, g);
		//绘制消去的行数
		this.drawNum(xPoint, (SIZE << 1) + IMAGE_POINT_H, this.gameDto.getRemoveLine(), maxCount, g);
	}
	
	/**
	 * 绘制值槽
	 * @param x 值槽起始的相对X坐标
	 * @param y 值槽起始的相对Y坐标
	 * @param width 值槽的宽度
	 * @param height 值槽的高度
	 * @param g 画笔
	 */
	private void drawExpRect(int x, int y, int width, int height,Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(this.X_START + x, this.Y_START + y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(this.X_START + x + 1, this.Y_START + y + 1, width - 2, height - 2);
		//经验值槽所截图片的比例
		double status = (this.gameDto.getRemoveLine() - this.gameDto.getLevel() * 20) / 20.0;
		g.drawImage(IMAGE_RECT, this.X_START + this.PADDING + 1, this.Y_START + y + 1,
				this.X_START + this.PADDING + (int)(status * (width - 2)), this.Y_START + y + height - 2,
				(int)(status * IMAGE_RECT_W), 0, (int)(status * IMAGE_RECT_W + 1), IMAGE_RECT_H, null);
	}
	
}
