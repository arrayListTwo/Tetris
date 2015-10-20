package control;

import gamedto.GameDto;
import service.GameService;
import ui.GameJPanel;

/**
 * 游戏的逻辑控制
 * @author arrayListTwo
 *
 */
public class GameControl implements Runnable{
	
	/**
	 * 游戏数据载体
	 */
	private GameDto gameDto;
	
	/**
	 * 游戏界面层
	 */
	private GameJPanel gameJPanel;
	
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	private boolean isStart = true;

	public GameControl(GameDto gameDto ,GameJPanel gamePanel, GameService gameService) {
		this.gameDto = gameDto;
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

	/**
	 * 瞬间下移
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
