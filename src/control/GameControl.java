package control;

import java.awt.event.KeyEvent;

import service.GameService;
import ui.GameJPanel;

public class GameControl{
	
	private GameJPanel gameJPanel;
	
	private GameService gameService;

	public GameControl(GameJPanel gamePanel, GameService gameService) {
		this.gameJPanel = gamePanel;
		this.gameService = gameService;
	}

	public void print(KeyEvent e) {
		
		System.out.println(e.getKeyCode());
		
	}
	
}
