package gamedto;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author arrayListTwo
 * 
 * 游戏中的俄罗斯方块
 */
public class GameAct {
	
	/**
	 * 俄罗斯方块的初始坐标信息
	 */
	private static final List<Point[]> ACT_POINTS;

	/**
	 * 俄罗斯方块信息
	 */
	private Point[] actPoint = null;
	
	/**
	 * 随机数产生器
	 */
	private Random random = new Random();
	
	/**
	 * 俄罗斯方块的类型标识
	 */
	private int actCode;
	
	static{
		ACT_POINTS = new ArrayList<Point[]>();
		ACT_POINTS.add(new Point[]{new Point(3,0), new Point(4,0), new Point(3,1), new Point(4,1)});
		ACT_POINTS.add(new Point[]{new Point(3,0), new Point(2,0), new Point(4,0), new Point(4,1)});
		ACT_POINTS.add(new Point[]{new Point(3,0), new Point(2,0), new Point(4,0), new Point(2,1)});
		ACT_POINTS.add(new Point[]{new Point(3,1), new Point(2,0), new Point(3,0), new Point(4,1)});
		ACT_POINTS.add(new Point[]{new Point(3,1), new Point(4,0), new Point(2,1), new Point(3,0)});
		ACT_POINTS.add(new Point[]{new Point(3,0), new Point(2,0), new Point(4,0), new Point(5,0)});
		ACT_POINTS.add(new Point[]{new Point(3,1), new Point(3,0), new Point(2,1), new Point(4,1)});
	}
	
	public GameAct(int actCode) {
		this.initAct(actCode);
	}
	
	/**
	 * @param actCode
	 */
	public void initAct(int actCode){
		this.actCode = actCode;
		Point[] tempPoint = ACT_POINTS.get(actCode);
		actPoint = new Point[tempPoint.length];
		for (int i = 0; i < tempPoint.length; i++) {
			actPoint[i] = new Point(tempPoint[i].x, tempPoint[i].y);
		}
	}

	/**
	 * @return 
	 */
	public Point[] getActPoint() {
		return actPoint;
	}
	
	/**
	 * 方块移动方法，不可移动返回false，可移动返回true
	 * @param xMove X轴偏移量
	 * @param yMove Y轴偏移量
	 * @return 偏移是否执行
	 */
	public boolean actMove(int xMove, int yMove, boolean[][] map){
		for (int i = 0; i < actPoint.length; i++) {
			int xPoint = actPoint[i].x + xMove;
			int yPoint = actPoint[i].y + yMove;
			if(!this.canMove(xPoint, yPoint, map)){
				return false;
			}
		}
		for (int j = 0; j < actPoint.length; j++) {
			actPoint[j].x = actPoint[j].x + xMove;
			actPoint[j].y = actPoint[j].y + yMove;
		}
		return true;
	}
	
	/**
	 * 方块的旋转
	 * @param map 游戏主界面的地图
	 * A.x = O.y + O.x - B.y
       A.y = O.y - O.x + B.x
	 */
	public void round(boolean[][] map) {
		
		for (int i = 1; i < actPoint.length; i++) {
			int xNew = actPoint[0].y + actPoint[0].x - actPoint[i].y;
			int yNew = actPoint[0].y - actPoint[0].x + actPoint[i].x;
			if(!this.canMove(xNew, yNew, map))
				return;
		}
		for (int i = 1; i < actPoint.length; i++) {
			int xNew = actPoint[0].y + actPoint[0].x - actPoint[i].y;
			int yNew = actPoint[0].y - actPoint[0].x + actPoint[i].x;
			actPoint[i].x = xNew;
			actPoint[i].y = yNew;
		}
	}
	
	/**
	 *是否可以移动
	 * @param xPoint x偏移量
	 * @param yPoint y偏移量
	 * @return 可移动返回true，不可移动返回false
	 */
	private boolean canMove(int xPoint, int yPoint, boolean[][] map){
		if(xPoint >= 0 && xPoint <= 9 && yPoint >= 0 && yPoint <= 17 && (!map[xPoint][yPoint]))
			return true;
		return false;
	}

	/**
	 * @return 每一种俄罗斯方块的标识名
	 */
	public int getActCode() {
		return actCode;
	}

	/**
	 * @return 俄罗斯方块的初始坐标信息
	 */
	public static List<Point[]> getActPoints() {
		return ACT_POINTS;
	}
	
}
