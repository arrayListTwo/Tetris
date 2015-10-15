package main;

import control.GameControl;
import control.PlayControl;
import gamedto.GameDto;
import service.GameService;
import ui.GameJFrame;
import ui.GameJPanel;

public class Main {
	
	public static void main(String[] args) {
		
		//����һ����Ϸ��������DTO
		GameDto gameDto = new GameDto();
		//����һ�����
		GameJPanel gamePanel = new GameJPanel(gameDto);
		//�����߼��㣨������Ϸ���ݣ�
		GameService gameService = new GameService(gameDto);
		//����һ�������������������Ϸ������Ϸ�߼���
		GameControl gameControl = new GameControl(gamePanel, gameService);
		//����һ����ҿ�������������Ϸ��������
		PlayControl playControl = new PlayControl(gameControl);
		//��װ��ҿ�����
		gamePanel.setGameControl(playControl);
		//����һ����ܣ������Ϸ��壩
		new GameJFrame(gamePanel);
		
		
	}

}
