package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.GameConfig;
import gamedto.GameDto;

/**
 * 窗口的基类
 * 
 * @author arrayListTwo
 *
 */
public class Layer{
	
	/**
	 * 边框切图的对象
	 */
	protected final static Image IMAGE_BORDER = new ImageIcon("Graphics/window/Window.png").getImage();
	
	/**
	 * 等级图片对象
	 */
	protected static final Image IMAGE_LEVEL = new ImageIcon("Graphics/string/level.png").getImage();

	/**
	 * 数字图片对象
	 */
	protected static final Image IMAGE_NUM = new ImageIcon("Graphics/string/num.png").getImage();
	
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
	 * 等级图片的宽度
	 */
	protected static final int IMAGE_LEVEL_W = IMAGE_LEVEL.getWidth(null);
	
	/**
	 * 等级图片的高度
	 */
	protected static final int IMAGE_LEVEL_H = IMAGE_LEVEL.getHeight(null);
	
	/**
	 * 每一个数字的宽度
	 */
	protected static final int IMAGE_NUM_W = IMAGE_NUM.getWidth(null) / 10;
	
	/**
	 * 每一个数字的高度
	 */
	protected static final int IMAGE_NUM_H = IMAGE_NUM.getHeight(null);
	
	/**
	 * 边框切图的边的宽度
	 */
	protected final int SIZE = GameConfig.getFRIME_CONFIG().getSIZE();
	
	/**
	 * 边框切图的宽度
	 */
	protected final static int BORDER_WIDTH = IMAGE_BORDER.getWidth(null);
	
	/**
	 * 边框切图的高度
	 */
	protected final static int BORDER_HEIGHT = IMAGE_BORDER.getHeight(null);
	
	/**
	 * 窗口的左上角的x坐标
	 */
	protected final int X_START;
	
	/**
	 * 窗口的左上角的y坐标
	 */
	protected final int Y_START;
	
	/**
	 * 窗口的宽度
	 */
	protected final int WINDOW_WIDTH;
	
	/**
	 * 窗口的高度
	 */
	protected final int WINDOW_HEIGHT;
	
	/**
	 * 向下填充，形成一个美观的边距
	 */
	protected final int PADDING = GameConfig.getFRIME_CONFIG().getPADDING();
	
	/**
	 * 游戏数据载体
	 */
	protected GameDto gameDto;
	
	public Layer(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT){
		this.X_START = X_START;
		this.Y_START = Y_START;
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
	}
	
	protected void setGameDto(GameDto gameDto){
		this.gameDto = gameDto;
	}
	
	/**
	 * 用于切图
	 * @param g 画笔
	 */
	protected void createWindow(Graphics g){
		//左上角
		g.drawImage(IMAGE_BORDER, X_START, Y_START, X_START + SIZE, Y_START + SIZE, 
				0, 0, SIZE, SIZE, null);
		//中上部分
		g.drawImage(IMAGE_BORDER, X_START + SIZE, Y_START, X_START + WINDOW_WIDTH - SIZE, Y_START + SIZE, SIZE, 
				0, BORDER_WIDTH - SIZE, SIZE, null);
		//右上角
		g.drawImage(IMAGE_BORDER, X_START + WINDOW_WIDTH - SIZE, Y_START, X_START + WINDOW_WIDTH, Y_START + SIZE,
				BORDER_WIDTH - SIZE, 0, BORDER_WIDTH, SIZE, null);
		//左边部分
		g.drawImage(IMAGE_BORDER, X_START, Y_START + SIZE, X_START + SIZE, Y_START + WINDOW_HEIGHT - SIZE,
				0, SIZE, SIZE, BORDER_HEIGHT - SIZE, null);
		//左下角
		g.drawImage(IMAGE_BORDER, X_START, Y_START + WINDOW_HEIGHT - SIZE, X_START + SIZE, Y_START + WINDOW_HEIGHT,
				0, BORDER_HEIGHT - SIZE, SIZE, BORDER_HEIGHT, null);
		//右边部分
		g.drawImage(IMAGE_BORDER, X_START + WINDOW_WIDTH - SIZE, Y_START + SIZE, X_START + WINDOW_WIDTH, Y_START + WINDOW_HEIGHT - SIZE,
				BORDER_WIDTH - SIZE, SIZE, BORDER_WIDTH, BORDER_HEIGHT - SIZE, null);
		//右下角
		g.drawImage(IMAGE_BORDER, X_START + WINDOW_WIDTH - SIZE, Y_START + WINDOW_HEIGHT - SIZE, X_START + WINDOW_WIDTH, Y_START + WINDOW_HEIGHT,
				BORDER_WIDTH - SIZE, BORDER_HEIGHT - SIZE, BORDER_WIDTH, BORDER_HEIGHT, null);
		//下边部分
		g.drawImage(IMAGE_BORDER, X_START + SIZE, Y_START + WINDOW_HEIGHT - SIZE, X_START + WINDOW_WIDTH - SIZE, Y_START + WINDOW_HEIGHT,
				SIZE, BORDER_HEIGHT - SIZE, BORDER_WIDTH - SIZE, BORDER_HEIGHT, null);
	}
	
	/**
	 * 右对齐打印数字
	 * @param x 相对X坐标值
	 * @param y 相对Y坐标值
	 * @param num 打印出来的数字
	 * @param maxcount 打印出数字的最大位数
	 * @param g 画笔
	 */
	protected void drawNum(int x, int y, int num, int maxcount, Graphics g) {
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
	
	/**
	 * 绘制值槽
	 * @param x 值槽起始的相对X坐标
	 * @param y 值槽起始的相对Y坐标
	 * @param width 值槽的宽度
	 * @param height 值槽的高度
	 * @param g 画笔
	 */
	protected void drawExpRect(int x, int y, int width, int height,Graphics g) {
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
