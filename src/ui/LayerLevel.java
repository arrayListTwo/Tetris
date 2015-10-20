package ui;

import java.awt.Graphics;

/**
 * ��Ϸ�ȼ�����
 * @author arrayListTwo
 *
 */
public class LayerLevel extends Layer {

	/**
	 * �ȼ����ֵ����λ��
	 */
	private static final int maxCount = 3;
	
	public LayerLevel(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		//���Ƶȼ�ͼ��
		g.drawImage(IMAGE_LEVEL, this.X_START + ((this.WINDOW_WIDTH - IMAGE_LEVEL_W) >> 1),
				this.Y_START + this.SIZE, null);
		this.drawNum(((this.WINDOW_WIDTH - maxCount * IMAGE_NUM_W) >> 1),
				IMAGE_LEVEL_H + ((this.WINDOW_HEIGHT - IMAGE_LEVEL_H - IMAGE_NUM_H) >> 1),
				this.gameDto.getLevel(), maxCount, g);
	}
	
}
