package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import gamedto.GameAct;

/**
 * 
 * ��Ϸ������
 * @author list
 *
 */
public class LayerGame extends Layer {
	
	/**
	 * ��Ϸ�еĶ���˹�����Դͼ
	 */
	private static final Image IMAGE_ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	
	/**
	 * ��Ӱͼ��
	 */
	private static final Image IMAGE_SHADOW = new ImageIcon("Graphics/game/shodow.png").getImage();
	
	/**
	 * ����˹����ĸ߶�
	 */
	private static final int ACT_SIZE = IMAGE_ACT.getHeight(null);
	
	public LayerGame(int xStart, int yStart, int width, int height) {
		super(xStart, yStart, width, height);
	}
	
	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		this.drawAct(g);
	}

	/**
	 * ���ƶ���˹����
	 * @param g ����
	 */
	public void drawAct(Graphics g){
		Point[] points = this.gameDto.getGameAct().getActPoint();
		int actCode = this.gameDto.getGameAct().getActCode();
		for (int i = 0; i < points.length; i++) {
			g.drawImage(IMAGE_ACT,
					this.X_START + (points[i].x << 5) + SIZE,
					this.Y_START + (points[i].y << 5) + SIZE,
					(this.X_START + (points[i].x << 5)) + ACT_SIZE + SIZE,
					(this.Y_START + (points[i].y << 5)) + ACT_SIZE + SIZE,
					(actCode + 1) << 5, 0, ((actCode + 1) << 5) + (1 << 5), (1 << 5), null);
		}
		//������ķ��������Ӱ
		this.showShadow(points, g);
		//�ڵ�ͼ�ϻ��ƶ���˹����
		this.drawMap(g);
	}

	/**
	 * ������Ӱ
	 * @param points ����˹�����������Ϣ
	 * @param g ��Ϸ����
	 */
	private void showShadow(Point[] points, Graphics g) {
		//����˹��������x����
		int xMax = this.xMax(points);
		//����˹��������Сx����
		int xMin = this.xMin(points);
		g.drawImage(IMAGE_SHADOW, this.X_START + this.SIZE + (xMin << 5), this.Y_START + this.SIZE,
				(xMax - xMin + 1) << 5, this.WINDOW_HEIGHT - (this.SIZE << 1), null);
	}

	/**
	 * ����˹�����е����x����
	 * @param points ����˹����������Ϣ
	 * @return ���x����
	 */
	private int xMax(Point[] points) {
		int xMax = points[0].x;
		for (int i = 0; i < points.length; i++) {
			if(xMax < points[i].x)
				xMax = points[i].x;
		}
		return xMax;
	}
	
	/**
	 * ����˹�����е���Сx������Ϣ
	 * @param points ����˹����������Ϣ
	 * @return ����x����
	 */
	private int xMin(Point[] points) {
		int xMin = points[0].x;
		for (int i = 0; i < points.length; i++) {
			if(xMin > points[i].x)
				xMin = points[i].x;
		}
		return xMin;
	}

	/**
	 * �ڵ�ͼ�ϻ��ƹ̶��˵Ķ���˹����
	 * @param g ����
	 */
	private void drawMap(Graphics g) {
		
		boolean[][] map = this.gameDto.getMap();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j])
					g.drawImage(IMAGE_ACT,
							this.X_START + (j << 5) + SIZE,
							this.Y_START + (i << 5) + SIZE,
							(this.X_START + (j << 5)) + ACT_SIZE + SIZE,
							(this.Y_START + (i << 5)) + ACT_SIZE + SIZE,
							0, 0, 1 << 5, 1 << 5, null);
			}
		}
		
	}
	
}
