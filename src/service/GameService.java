package service;

import java.awt.Point;

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
		//判断俄罗斯方块是否可以移动
		boolean canDown = this.gameDto.getGameAct().actMove(0, 1);
		if(canDown){
			return;
		}
		else{
			//不可动，变颜色
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
