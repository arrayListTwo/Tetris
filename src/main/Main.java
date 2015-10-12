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
		
		//����һ�����
		gamePanel = new GameJPanel();
		//����һ����Ϸ��������DTO
		gameDto = new GameDto();
		//�����߼��㣨������Ϸ���ݣ�
		gameService = new GameService(gameDto);
		//����һ�������������������Ϸ������Ϸ�߼���
		gameControl = new GameControl(gamePanel, gameService);
		//����һ����ҿ�������������Ϸ��������
		playControl = new PlayControl(gameControl);
		//����һ����ܣ������Ϸ��壩
		gameFrame = new GameJFrame(gamePanel);
		
	}

}
