package control;

import gamedto.GameDto;
import service.GameService;
import ui.GameJPanel;

/**
 * ��Ϸ���߼�����
 * @author arrayListTwo
 *
 */
public class GameControl implements Runnable{
	
	/**
	 * ��Ϸ��������
	 */
	private GameDto gameDto;
	
	/**
	 * ��Ϸ�����
	 */
	private GameJPanel gameJPanel;
	
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	private boolean isStart = true;

	public GameControl(GameDto gameDto ,GameJPanel gamePanel, GameService gameService) {
		this.gameDto = gameDto;
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
	public void round() {
		this.gameService.round();
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

	/**
	 * ˲������
	 */
	public void decline(){
		this.gameService.decline();
		this.gameJPanel.repaint();
	}
	
	@Override
	public void run() {
		while(this.isStart){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.downMove();
		}
	}
	
	private void changeStart(){
		this.isStart = !isStart;
	}
	
	public void test() {
		this.gameService.test();
		this.gameJPanel.repaint();
	}
	
}
