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
	
	/**
	 * 随机数生成器
	 */
	private Random random = new Random();
	
	public GameService(GameDto gameDto) {
		this.gameDto = gameDto;
		//随机数生成器随机生成一个数，用于显示第一个俄罗斯方块
		int actCode = random.nextInt(GameAct.getActPoints().size());
		GameAct gameAct = new GameAct(actCode);
		this.gameDto.setGameAct(gameAct);
		//设置下一个俄罗斯方块类型，存储起来
		this.gameDto.setNext(random.nextInt(GameAct.getActPoints().size()));
	}

	/**
	 * 向左移动
	 */
	public void leftMove() {
		this.gameDto.getGameAct().actMove(-1, 0, this.gameDto.getMap());
	}

	/**
	 * 旋转
	 */
	public void round() {
		this.gameDto.getGameAct().round(this.gameDto.getMap());
	}

	/**
	 * 向右移动
	 */
	public void rightMove() {
		this.gameDto.getGameAct().actMove(1, 0, this.gameDto.getMap());
	}

	/**
	 * 向下移动
	 */
	public void downMove() {
		//判断俄罗斯方块是否可以移动
		if(this.gameDto.getGameAct().actMove(0, 1, this.gameDto.getMap())){
			return;
		}
		//获得游戏地图对象
		boolean[][] map = this.gameDto.getMap();
		//将方块显示在游戏地图上
		this.displayGameAct(map);
		//消去的行数
		int removeLine = plusExp(map);
		//游戏共消去了多少行
		this.gameDto.setRemoveLine(this.gameDto.getRemoveLine() + removeLine);
		//游戏等级变化
		this.plusLevel(this.gameDto.getRemoveLine());
		//获得游戏数据载体中的俄罗斯方块标识
		this.gameDto.getGameAct().initAct(this.gameDto.getNext());
		//将下一个俄罗斯方块标识存储起来
		this.gameDto.setNext(random.nextInt(GameAct.getActPoints().size()));
		
	}

	/**
	 * 游戏等级变化
	 * @param removeLine 游戏现在的等级
	 */
	private void plusLevel(int removeLine) {
		if((removeLine - (this.gameDto.getLevel() * 10)) >= 10){
			this.gameDto.setLevel(this.gameDto.getLevel() + 1);
		}
	}

	/**
	 * 在游戏地图上显示方块
	 * @param map 游戏地图
	 */
	private void displayGameAct(boolean[][] map) {
		//获得俄罗斯方块的现在坐标信息
		Point[] actpoints = this.gameDto.getGameAct().getActPoint();
		//循环遍历俄罗斯方块的坐标信息
		for (int i = 0; i < actpoints.length; i++) {
			map[actpoints[i].y][actpoints[i].x] = true;
		}
	}

	/**
	 * 共消去了多少行
	 * @param map 游戏地图
	 * @return 消去的行数
	 */
	private int plusExp(boolean[][] map) {
		//临时记录消去的行数
		int removeLine = 0;
		//循环遍历游戏地图，是否存在可消行
		for (int row = 0; row < map.length; row++) {
			//判断是否可消行
			if(!this.isCanRemoveLine(row, map))
				continue;
			//执行消行操作
			this.removeLine(map, row);
			//消去的行数加1
			removeLine++;
		}
		return removeLine;
	}

	/**
	 * 执行消行操作
	 * @param map 游戏地图
	 * @param row 行
	 */
	private void removeLine(boolean[][] map, int row) {
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++) {
				map[i + 1][j] = map[i][j];
				map[i][j] = false;
			}
		}
		//将第一行全部置为false
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = false;
		}
	}

	/**
	 * 判断此行是否可以消去
	 * @param row 行
	 * @param map 游戏地图
	 * @return
	 */
	private boolean isCanRemoveLine(int row, boolean[][] map) {
		for (int column = 0; column < map[0].length; column++) {
			if(!map[row][column])
				return false;
		}
		return true;
	}

	public void test() {
		this.gameDto.setRemoveLine(this.gameDto.getRemoveLine() + 1);
		if(this.gameDto.getRemoveLine() - (this.gameDto.getLevel() * 10) >= 10){
			this.gameDto.setLevel(this.gameDto.getLevel() + 1);
		}
	}

}
