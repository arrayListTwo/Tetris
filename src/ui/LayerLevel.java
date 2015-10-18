package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ��Ϸ�ȼ�����
 * @author arrayListTwo
 *
 */
public class LayerLevel extends Layer {
	
	/**
	 * �ȼ�ͼƬ����
	 */
	private static final Image IMAGE_LEVEL = new ImageIcon("Graphics/string/level.png").getImage();

	/**
	 * ����ͼƬ����
	 */
	private static final Image IMAGE_NUM = new ImageIcon("Graphics/string/num.png").getImage();
	
	/**
	 * �ȼ����ֵ����λ��
	 */
	private static final int maxCount = 3;
	
	/**
	 * �ȼ�ͼƬ�Ŀ��
	 */
	private static final int IMAGE_LEVEL_W = IMAGE_LEVEL.getWidth(null);
	
	/**
	 * �ȼ�ͼƬ�ĸ߶�
	 */
	private static final int IMAGE_LEVEL_H = IMAGE_LEVEL.getHeight(null);
	
	/**
	 * ÿһ�����ֵĿ��
	 */
	private static final int IMAGE_NUM_W = IMAGE_NUM.getWidth(null) / 10;
	
	/**
	 * ÿһ�����ֵĸ߶�
	 */
	private static final int IMAGE_NUM_H = IMAGE_NUM.getHeight(null);
	
	public LayerLevel(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		//���Ƶȼ�ͼ��
		g.drawImage(IMAGE_LEVEL, this.X_START + ((this.WINDOW_WIDTH - IMAGE_LEVEL_W) >> 1),
				this.Y_START + this.SIZE, null);
		this.drawLevel(((this.WINDOW_WIDTH - maxCount * IMAGE_NUM_W) >> 1),
				IMAGE_LEVEL_H + ((this.WINDOW_HEIGHT - IMAGE_LEVEL_H - IMAGE_NUM_H) >> 1),
				this.gameDto.getLevel(), maxCount, g);
	}
	
	/**
	 * �Ҷ����ӡ����
	 * @param x ���X����ֵ
	 * @param y ���Y����ֵ
	 * @param num ��ӡ����������
	 * @param maxcount ��ӡ�����ֵ����λ��
	 * @param g ����
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
