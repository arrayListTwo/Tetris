package service;

import java.awt.Point;
import java.util.Random;

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
	
	/**
	 * �����������
	 */
	private Random random = new Random();
	
	public GameService(GameDto gameDto) {
		this.gameDto = gameDto;
		int actCode = random.nextInt(GameAct.getActPoints().size());
		GameAct gameAct = new GameAct(actCode);
		this.gameDto.setGameAct(gameAct);
		this.gameDto.setNext(random.nextInt(GameAct.getActPoints().size()));
	}

	/**
	 * 
	 */
	public void leftMove() {
		this.gameDto.getGameAct().actMove(-1, 0, this.gameDto.getMap());
	}

	/**
	 * 
	 */
	public void round() {
		this.gameDto.getGameAct().round(this.gameDto.getMap());
	}

	/**
	 * 
	 */
	public void rightMove() {
		this.gameDto.getGameAct().actMove(1, 0, this.gameDto.getMap());
	}

	/**
	 * 
	 */
	public void downMove() {
		//�ж϶���˹�����Ƿ�����ƶ�
		if(this.gameDto.getGameAct().actMove(0, 1, this.gameDto.getMap())){
			return;
		}
		else{
			//���ɶ�������ɫ
			boolean[][] map = this.gameDto.getMap();
			Point[] actpoints = this.gameDto.getGameAct().getActPoint();
			for (int i = 0; i < actpoints.length; i++) {
				map[actpoints[i].x][actpoints[i].y] = true;
			}
		}
		//
		this.gameDto.getGameAct().initAct(this.gameDto.getNext());
		//
		this.gameDto.setNext(random.nextInt(GameAct.getActPoints().size()));
	}

}
