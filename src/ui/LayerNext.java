package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import gamedto.GameAct;

/**
 * ��Ϸ��һ�����鴰��
 * @author arrayListTwo
 *
 */
public class LayerNext extends Layer {
	
	/**
	 * ��Ϸ�еĶ���˹�����Դͼ
	 */
	private static final Image IMAGE_ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	
	/**
	 * 
	 */
	private final int ACT_SIZE = IMAGE_ACT.getHeight(null);

	public LayerNext(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		//������ʾ��һ������
		this.displayGameAct(g);
	}
	
	/**������ʾ��һ������
	 * @param g
	 */
	private void displayGameAct(Graphics g){
		int actCode = this.gameDto.getNext();
		Point[] points = GameAct.getActPoints().get(actCode);
		for (int i = 0; i < points.length; i++) {
			g.drawImage(IMAGE_ACT,
					this.X_START + (points[i].x << 5) + SIZE,
					this.Y_START + (points[i].y << 5) + SIZE,
					(this.X_START + (points[i].x << 5)) + ACT_SIZE + SIZE,
					(this.Y_START + (points[i].y << 5)) + ACT_SIZE + SIZE,
					(actCode + 1) << 5, 0, ((actCode + 1) << 5) + (1 << 5), (1 << 5), null);
		}
	}

}
