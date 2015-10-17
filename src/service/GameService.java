package service;

import java.awt.Point;
import java.util.Random;

import gamedto.GameAct;
import gamedto.GameDto;

/**
 * 游戏逻辑层
 * @author arrayListTwo
 *
 */
public class GameService {
	
	/**
	 * 
	 */
	private GameDto gameDto;
	
	private Random random = new Random();
	
	public GameService(GameDto gameDto) {
		this.gameDto = gameDto;
		GameAct gameAct = new GameAct();
		this.gameDto.setGameAct(gameAct);
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
		//判断俄罗斯方块是否可以移动
		if(this.gameDto.getGameAct().actMove(0, 1, this.gameDto.getMap())){
			return;
		}
		else{
			//不可动，变颜色
			boolean[][] map = this.gameDto.getMap();
			Point[] actpoints = this.gameDto.getGameAct().getActPoint();
			for (int i = 0; i < actpoints.length; i++) {
				map[actpoints[i].x][actpoints[i].y] = true;
			}
		}
		this.gameDto.getGameAct().initAct(random.nextInt(7));
	}

}
