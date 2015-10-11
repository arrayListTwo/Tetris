package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 窗口的基类
 * 
 * @author list
 *
 */
public class Layer{
	
	/**
	 * 边框切图的对象
	 */
	protected final static Image IMAGE_BORDER = new ImageIcon("Graphics/window/Window.png").getImage();
	
	/**
	 * 边框切图的边的宽度
	 */
	protected final int SIZE = 7;
	
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
	private final int X_START;
	
	/**
	 * 窗口的左上角的y坐标
	 */
	private final int Y_START;
	
	/**
	 * 窗口的宽度
	 */
	private final int WINDOW_WIDTH;
	
	/**
	 * 窗口的高度
	 */
	private final int WINDOW_HEIGHT;
	
	public Layer(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT){
		this.X_START = X_START;
		this.Y_START = Y_START;
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
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
	
}
