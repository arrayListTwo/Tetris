package control;

import service.GameService;
import ui.GameJPanel;

/**
 * 游戏的逻辑控制
 * @author arrayListTwo
 *
 */
public class GameControl{
	
	/**
	 * 游戏界面层
	 */
	private GameJPanel gameJPanel;
	
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;

	public GameControl(GameJPanel gamePanel, GameService gameService) {
		this.gameJPanel = gamePanel;
		this.gameService = gameService;
	}

	/**
	 * 方块向左移动
	 */
	public void leftMove() {
		this.gameService.leftMove();
		this.gameJPanel.repaint();
	}

	/**
	 * 方块向上移动
	 */
	public void round() {
		this.gameService.round();
		this.gameJPanel.repaint();
	}

	/**
	 * 方块向右移动
	 */
	public void rightMove() {
		this.gameService.rightMove();
		this.gameJPanel.repaint();
	}

	/**
	 * 方块向下移动
	 */
	public void downMove() {
		this.gameService.downMove();
		this.gameJPanel.repaint();
	}
	
}
