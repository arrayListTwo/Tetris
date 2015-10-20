package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.GameConfig;
import gamedto.GameDto;

/**
 * ���ڵĻ���
 * 
 * @author arrayListTwo
 *
 */
public class Layer{
	
	/**
	 * �߿���ͼ�Ķ���
	 */
	protected final static Image IMAGE_BORDER = new ImageIcon("Graphics/window/Window.png").getImage();
	
	/**
	 * �ȼ�ͼƬ����
	 */
	protected static final Image IMAGE_LEVEL = new ImageIcon("Graphics/string/level.png").getImage();

	/**
	 * ����ͼƬ����
	 */
	protected static final Image IMAGE_NUM = new ImageIcon("Graphics/string/num.png").getImage();
	
	/**
	 * �ȼ�ͼƬ�Ŀ��
	 */
	protected static final int IMAGE_LEVEL_W = IMAGE_LEVEL.getWidth(null);
	
	/**
	 * �ȼ�ͼƬ�ĸ߶�
	 */
	protected static final int IMAGE_LEVEL_H = IMAGE_LEVEL.getHeight(null);
	
	/**
	 * ÿһ�����ֵĿ��
	 */
	protected static final int IMAGE_NUM_W = IMAGE_NUM.getWidth(null) / 10;
	
	/**
	 * ÿһ�����ֵĸ߶�
	 */
	protected static final int IMAGE_NUM_H = IMAGE_NUM.getHeight(null);
	
	/**
	 * �߿���ͼ�ıߵĿ��
	 */
	protected final int SIZE = GameConfig.getFRIME_CONFIG().getSIZE();
	
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
	protected final int X_START;
	
	/**
	 * ���ڵ����Ͻǵ�y����
	 */
	protected final int Y_START;
	
	/**
	 * ���ڵĿ��
	 */
	protected final int WINDOW_WIDTH;
	
	/**
	 * ���ڵĸ߶�
	 */
	protected final int WINDOW_HEIGHT;
	
	protected final int PADDING = GameConfig.getFRIME_CONFIG().getPADDING();
	
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
	
	/**
	 * �Ҷ����ӡ����
	 * @param x ���X����ֵ
	 * @param y ���Y����ֵ
	 * @param num ��ӡ����������
	 * @param maxcount ��ӡ�����ֵ����λ��
	 * @param g ����
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
	
}
