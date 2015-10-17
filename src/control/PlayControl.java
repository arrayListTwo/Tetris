package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 玩家控制器
 * @author arrayListTwo
 *
 */
public class PlayControl extends KeyAdapter {
	
	/**
	 * 游戏控制器，相当于一个命令中转站，
	 * 接收玩家控制器的命令，做出动作
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
