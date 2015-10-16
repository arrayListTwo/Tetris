package control;

import service.GameService;
import ui.GameJPanel;

/**
 * ��Ϸ���߼�����
 * @author arrayListTwo
 *
 */
public class GameControl{
	
	/**
	 * ��Ϸ�����
	 */
	private GameJPanel gameJPanel;
	
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;

	public GameControl(GameJPanel gamePanel, GameService gameService) {
		this.gameJPanel = gamePanel;
		this.gameService = gameService;
	}

	/**
	 * ���������ƶ�
	 */
	public void leftMove() {
		this.gameService.leftMove();
		this.gameJPanel.repaint();
	}

	/**
	 * ���������ƶ�
	 */
	public void upMove() {
		this.gameService.upMove();
		this.gameJPanel.repaint();
	}

	/**
	 * ���������ƶ�
	 */
	public void rightMove() {
		this.gameService.rightMove();
		this.gameJPanel.repaint();
	}

	/**
	 * ���������ƶ�
	 */
	public void downMove() {
		this.gameService.downMove();
		this.gameJPanel.repaint();
	}
	
}
