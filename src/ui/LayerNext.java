package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ��Ϸ��һ�����鴰��
 * @author arrayListTwo
 *
 */
public class LayerNext extends Layer {
	
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
		//��ö���˹����ı�ʶ
		int actCode = this.gameDto.getNext();
		Image imageNext = new ImageIcon("Graphics/game/" + actCode + ".png").getImage();
		int imageHeight = imageNext.getHeight(null);
		int imageWidth = imageNext.getWidth(null);
		g.drawImage(imageNext, this.X_START + ((this.WINDOW_WIDTH - imageWidth) >> 1) ,
				this.Y_START + ((this.WINDOW_HEIGHT - imageHeight) >> 1), null);
	}

}
