package dto;

import java.awt.Point;
import java.util.List;

/**
 * 游戏中数据对象
 * @author list
 *
 */
public class GameDto {
	
	/**
	 * 数据库中的游戏记录
	 */
	private List<Player> dbPlays = null;
	
	/**
	 * 本地磁盘中的游戏记录
	 */
	private List<Player> diskPlays = null;
	
	/**
	 * 游戏中下落的方块
	 */
	private List<Point> rect = null;
	
	/**
	 *游戏主界面的地图 
	 */
	private boolean[][] map = null;
	
	/**
	 * 游戏中的下一个方块
	 */
	private List<Point> nextRect = null;
	
	/**
	 * 游戏得分
	 */
	private int point = 0;
	
	/**
	 *游戏中消去的行数 
	 */
	private int removeLine = 0;
	
	/**
	 * 游戏的级数
	 */
	private int level = 0;

	/**
	 * 获取数据库记录
	 * @return 数据库记录，存放Players对象的List集合
	 */
	public List<Player> getDbPlays() {
		return dbPlays;
	}

	/**
	 *添加数据库记录
	 * @param dbPlays 玩家对象
	 */
	public void addDbPlays(Player dbPlays) {
		this.dbPlays.add(dbPlays);
	}

	/**
	 * 获取本地磁盘记录
	 * @return 本地磁盘记录对象
	 */
	public List<Player> getDiskPlays() {
		return diskPlays;
	}

	/**
	 * 添加一个玩家对象
	 * @param diskPlays 玩家对象
	 */
	public void addDiskPlays(Player diskPlay) {
		this.diskPlays.add(diskPlay);
	}

	/**
	 * 获得游戏中下落方块的坐标信息
	 * @return 方块的坐标信息
	 */
	public List<Point> getRect() {
		return rect;
	}

	/**
	 * 设置游戏中下落方块的坐标信息
	 * @param rect 方块坐标信息
	 */
	public void setRect(List<Point> rect) {
		this.rect = rect;
	}

	/**
	 * 获得游戏主界面对象
	 * @return 游戏主界面对象
	 */
	public boolean[][] getMap() {
		return map;
	}

	/**
	 * 设置游戏主界面
	 * @param map 游戏主界面对象
	 */
	public void setMap(boolean[][] map) {
		this.map = map;
	}

	/**
	 * 获取下一个方块的坐标信息
	 * @return 坐标信息
	 */
	public List<Point> getNextRect() {
		return nextRect;
	}

	/**
	 * 设置下一个方块的坐标信息
	 * @param nextRect 坐标信息
	 */
	public void setNextRect(List<Point> nextRect) {
		this.nextRect = nextRect;
	}

	/**
	 * 获取当前分数
	 * @return 分数
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * 设置当前分数
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * 获取当前已消去的行数
	 * @return
	 */
	public int getRemoveLine() {
		return removeLine;
	}

	/**
	 * 设置消去的行数
	 * @param removeLine 行数
	 */
	public void setRemoveLine(int removeLine) {
		this.removeLine = removeLine;
	}

	/**
	 * 获取当前等级
	 * @return 等级
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * 设置当前等级
	 * @param level 等级
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
}
