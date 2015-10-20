package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ��Ϸ��������
 * @author arrayListTwo
 *
 */
public class LayerPoint extends Layer {
	
	/**
	 * ����ֵ�۶���
	 */
	private static final Image IMAGE_RECT = new ImageIcon("Graphics/window/rect.png").getImage();
	
	/**
	 * ����ֵ��ͼ��ĸ߶�
	 */
	private static final int IMAGE_RECT_H = IMAGE_RECT.getHeight(null);
	
	/**
	 * ����ֵ��ͼ��Ŀ��
	 */
	private static final int IMAGE_RECT_W = IMAGE_RECT.getWidth(null);
	
	/**
	 * ����ͼ�����
	 */
	private static final Image IMAGE_POINT = new ImageIcon("Graphics/string/point.png").getImage();
	
	/**
	 * ����ͼ��ĸ߶�
	 */
	private static final int IMAGE_POINT_H = IMAGE_POINT.getHeight(null);
	
	/**
	 * ����ͼ�����
	 */
	private static final Image IMAGE_LINE = new ImageIcon("Graphics/string/rmline.png").getImage();
	
	/**
	 * ����ͼ��ĸ߶�
	 */
	private static final int IMAGE_LINE_H = IMAGE_LINE.getHeight(null);
	
	public LayerPoint(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		//���Ʒ���������
		this.disPlay(g);
		//����ֵ��
		this.drawExpRect(this.PADDING, (SIZE << 2) + IMAGE_POINT_H + IMAGE_LINE_H,
				this.WINDOW_WIDTH - this.PADDING - (SIZE << 1),
				this.WINDOW_HEIGHT - (SIZE * 6) - (IMAGE_POINT_H + IMAGE_LINE_H), g);
	}
	
	/**
	 * ���Ʒ���������
	 * @param g ����
	 */
	private void disPlay(Graphics g){
		//������������ʾ�������
		int maxCount = 5;
		//���Ʒ���ͼ��
		g.drawImage(IMAGE_POINT, this.X_START + this.PADDING, this.Y_START + (SIZE << 1), null);
		//��������ͼ��
		g.drawImage(IMAGE_LINE, this.X_START + this.PADDING, this.Y_START + (SIZE * 3) + IMAGE_POINT_H, null);
		//�������������ֵ����X����
		int xPoint = this.WINDOW_WIDTH - (SIZE * 3) - IMAGE_NUM_W * maxCount;
		//���Ʒ���
		this.drawNum(xPoint, SIZE, this.gameDto.getPoint(), maxCount, g);
		//������ȥ������
		this.drawNum(xPoint, (SIZE << 1) + IMAGE_POINT_H, this.gameDto.getRemoveLine(), maxCount, g);
	}
	
	/**
	 * ����ֵ��
	 * @param x ֵ����ʼ�����X����
	 * @param y ֵ����ʼ�����Y����
	 * @param width ֵ�۵Ŀ��
	 * @param height ֵ�۵ĸ߶�
	 * @param g ����
	 */
	private void drawExpRect(int x, int y, int width, int height,Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(this.X_START + x, this.Y_START + y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(this.X_START + x + 1, this.Y_START + y + 1, width - 2, height - 2);
		//����ֵ������ͼƬ�ı���
		double status = (this.gameDto.getRemoveLine() - this.gameDto.getLevel() * 20) / 20.0;
		g.drawImage(IMAGE_RECT, this.X_START + this.PADDING + 1, this.Y_START + y + 1,
				this.X_START + this.PADDING + (int)(status * (width - 2)), this.Y_START + y + height - 2,
				(int)(status * IMAGE_RECT_W), 0, (int)(status * IMAGE_RECT_W + 1), IMAGE_RECT_H, null);
	}
	
}
