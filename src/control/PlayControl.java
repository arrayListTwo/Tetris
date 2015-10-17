package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * ��ҿ�����
 * @author arrayListTwo
 *
 */
public class PlayControl extends KeyAdapter {
	
	/**
	 * ��Ϸ���������൱��һ��������תվ��
	 * ������ҿ������������������
	 */
	private GameControl gameControl;
	
	public PlayControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.gameControl.leftMove();
			break;
		case KeyEvent.VK_UP:
			this.gameControl.round();
			break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.rightMove();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.downMove();
			break;
		default:
			break;
		}
	}
	
}
