package service;

import java.awt.Point;

import gamedto.GameAct;
import gamedto.GameDto;

/**
 * ��Ϸ�߼���
 * @author arrayListTwo
 *
 */
public class GameService {
	
	/**
	 * 
	 */
	private GameDto gameDto;
	
	public GameService(GameDto gameDto) {
		this.gameDto = gameDto;
<<<<<<< HEAD
		GameAct gameAct = new GameAct();
		this.gameDto.setGameAct(gameAct);
	}

	/**
	 * 
	 */
	public void leftMove() {
		this.gameDto.getGameAct().actMove(-1, 0);
	}

	/**
	 * 
	 */
	public void upMove() {
		this.gameDto.getGameAct().actMove(0, -1);
	}

	/**
	 * 
	 */
	public void rightMove() {
		this.gameDto.getGameAct().actMove(1, 0);
	}

	/**
	 * 
	 */
	public void downMove() {
		//�ж϶���˹�����Ƿ�����ƶ�
		boolean canDown = this.gameDto.getGameAct().actMove(0, 1);
		if(canDown){
			return;
		}
		else{
			//���ɶ�������ɫ
			boolean[][] map = this.gameDto.getMap();
			Point[] actpoints = this.gameDto.getGameAct().getActPoints();
			for (int i = 0; i < actpoints.length; i++) {
				map[actpoints[i].x][actpoints[i].y] = true;
			}
		}
=======
		System.out.println("hahahah");
>>>>>>> efdd984ada83dbf6a3cfbe313509c414e3cc057b
	}

}
