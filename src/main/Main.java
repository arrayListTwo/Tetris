package main;

import control.GameControl;
import control.PlayControl;
import gamedto.GameDto;
import service.GameService;
import ui.GameJFrame;
import ui.GameJPanel;

public class Main {
	
	public static GameJPanel gamePanel = null;
	public static GameDto gameDto = null;
	public static GameService gameService = null;
	public static GameControl gameControl = null;
	public static PlayControl playControl = null;
	public static GameJFrame gameFrame = null;

	public static void main(String[] args) {
		
		//创建一个面板
		gamePanel = new GameJPanel();
		//创建一个游戏数据载体DTO
		gameDto = new GameDto();
		//创建逻辑层（连接游戏数据）
		gameService = new GameService(gameDto);
		//创建一个中央控制器（连接游戏面板和游戏逻辑）
		gameControl = new GameControl(gamePanel, gameService);
		//创建一个玩家控制器（连接游戏控制器）
		playControl = new PlayControl(gameControl);
		//创建一个框架（添加游戏面板）
		gameFrame = new GameJFrame(gamePanel);
		
	}

}
