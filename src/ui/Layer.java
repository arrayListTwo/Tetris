package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ���ڵĻ���
 * 
 * @author list
 *
 */
public class Layer{
	
	/**
	 * �߿���ͼ�Ķ���
	 */
	protected final static Image IMAGE_BORDER = new ImageIcon("Graphics/window/Window.png").getImage();
	
	/**
	 * �߿���ͼ�ıߵĿ��
	 */
	protected final int SIZE = 7;
	
	/**
	 * �߿���ͼ�Ŀ��
	 */
	protected final static int BORDER_WIDTH = IMAGE_BORDER.getWidth(null);
	
	/**
	 * �߿���ͼ�ĸ߶�
	 */
	protected final static int BORDER_HEIGHT = IMAGE_BORDER.getHeight(null);
	
	/**
	 * ���ڵ����Ͻǵ�x����
	 */
	private final int X_START;
	
	/**
	 * ���ڵ����Ͻǵ�y����
	 */
	private final int Y_START;
	
	/**
	 * ���ڵĿ��
	 */
	private final int WINDOW_WIDTH;
	
	/**
	 * ���ڵĸ߶�
	 */
	private final int WINDOW_HEIGHT;
	
	public Layer(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT){
		this.X_START = X_START;
		this.Y_START = Y_START;
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
	}
	
	/**
	 * ������ͼ
	 * @param g ����
	 */
	protected void createWindow(Graphics g){
		//���Ͻ�
		g.drawImage(IMAGE_BORDER, X_START, Y_START, X_START + SIZE, Y_START + SIZE, 
				0, 0, SIZE, SIZE, null);
		//���ϲ���
		g.drawImage(IMAGE_BORDER, X_START + SIZE, Y_START, X_START + WINDOW_WIDTH - SIZE, Y_START + SIZE, SIZE, 
				0, BORDER_WIDTH - SIZE, SIZE, null);
		//���Ͻ�
		g.drawImage(IMAGE_BORDER, X_START + WINDOW_WIDTH - SIZE, Y_START, X_START + WINDOW_WIDTH, Y_START + SIZE,
				BORDER_WIDTH - SIZE, 0, BORDER_WIDTH, SIZE, null);
		//��߲���
		g.drawImage(IMAGE_BORDER, X_START, Y_START + SIZE, X_START + SIZE, Y_START + WINDOW_HEIGHT - SIZE,
				0, SIZE, SIZE, BORDER_HEIGHT - SIZE, null);
		//���½�
		g.drawImage(IMAGE_BORDER, X_START, Y_START + WINDOW_HEIGHT - SIZE, X_START + SIZE, Y_START + WINDOW_HEIGHT,
				0, BORDER_HEIGHT - SIZE, SIZE, BORDER_HEIGHT, null);
		//�ұ߲���
		g.drawImage(IMAGE_BORDER, X_START + WINDOW_WIDTH - SIZE, Y_START + SIZE, X_START + WINDOW_WIDTH, Y_START + WINDOW_HEIGHT - SIZE,
				BORDER_WIDTH - SIZE, SIZE, BORDER_WIDTH, BORDER_HEIGHT - SIZE, null);
		//���½�
		g.drawImage(IMAGE_BORDER, X_START + WINDOW_WIDTH - SIZE, Y_START + WINDOW_HEIGHT - SIZE, X_START + WINDOW_WIDTH, Y_START + WINDOW_HEIGHT,
				BORDER_WIDTH - SIZE, BORDER_HEIGHT - SIZE, BORDER_WIDTH, BORDER_HEIGHT, null);
		//�±߲���
		g.drawImage(IMAGE_BORDER, X_START + SIZE, Y_START + WINDOW_HEIGHT - SIZE, X_START + WINDOW_WIDTH - SIZE, Y_START + WINDOW_HEIGHT,
				SIZE, BORDER_HEIGHT - SIZE, BORDER_WIDTH - SIZE, BORDER_HEIGHT, null);
	}
	
}
