package main;

import control.GameControl;
import control.PlayControl;
import gamedto.GameDto;
import service.GameService;
import ui.GameJFrame;
import ui.GameJPanel;

public class Main {
	
	public static void main(String[] args) {
		
		//创建一个游戏数据载体DTO
		GameDto gameDto = new GameDto();
		//创建一个面板
		GameJPanel gamePanel = new GameJPanel(gameDto);
		//创建逻辑层（连接游戏数据）
		GameService gameService = new GameService(gameDto);
		//创建一个中央控制器（连接游戏面板和游戏逻辑）
		GameControl gameControl = new GameControl(gamePanel, gameService);
		//创建一个玩家控制器（连接游戏控制器）
		PlayControl playControl = new PlayControl(gameControl);
		//安装玩家控制器
		gamePanel.setGameControl(playControl);
		//创建一个框架（添加游戏面板）
		new GameJFrame(gamePanel);
		
		
	}

}
