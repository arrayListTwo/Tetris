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
		
	}
	
}