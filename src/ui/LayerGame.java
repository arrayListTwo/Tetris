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
		Point[] points = this.gameDto.getGameAct().getActPoints();
		for (int i = 0; i < points.length; i++) {
			g.drawImage(IMAGE_ACT,
					this.X_START + (points[i].x << 5) + SIZE,
					this.Y_START + (points[i].y << 5) + SIZE,
					(this.X_START + (points[i].x << 5)) + ACT_SIZE + SIZE,
					(this.Y_START + (points[i].y << 5)) + ACT_SIZE + SIZE,
					0, 0, 32, 32, null);
		}
		//�ڵ�ͼ�ϻ��ƶ���˹����
		this.drawMap(g);
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
							this.X_START + (i << 5) + SIZE,
							this.Y_START + (j << 5) + SIZE,
							(this.X_START + (i << 5)) + ACT_SIZE + SIZE,
							(this.Y_START + (j << 5)) + ACT_SIZE + SIZE,
							0, 0, 32, 32, null);
			}
		}
		
	}
	
}
