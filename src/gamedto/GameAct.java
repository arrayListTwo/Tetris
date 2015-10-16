package gamedto;

import java.awt.Point;

/**
 * @author arrayListTwo
 * 
 * 游戏中的俄罗斯方块
 */
public class GameAct {

	/**
	 * 
	 */
	private Point[] actPoints = null;
	
	public GameAct() {
		actPoints = new Point[]{
			new Point(3,0), new Point(4,0), new Point(3,1), new Point(4,1)	
		};
	}

	/**
	 * @return the actPoints
	 */
	public Point[] getActPoints() {
		//利用数组映射来拷贝俄罗斯方块的坐标信息
		Point[] actPoints = new Point[this.actPoints.length];
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i] = new Point(this.actPoints[i].x, this.actPoints[i].y);
		}
		return actPoints;
	}
	
	/**
	 * 方块移动方法
	 * @param xMove X轴偏移量
	 * @param yMove Y轴偏移量
	 * @return 偏移是否执行
	 */
	public boolean actMove(int xMove, int yMove){
		for (int i = 0; i < actPoints.length; i++) {
			int xPoint = actPoints[i].x + xMove;
			int yPoint = actPoints[i].y + yMove;
			if(!this.canMove(xPoint, yPoint)){
				return false;
			}
		}
		for (int j = 0; j < actPoints.length; j++) {
			actPoints[j].x = actPoints[j].x + xMove;
			actPoints[j].y = actPoints[j].y + yMove;
		}
		
		return true;
	}
	
	/**
	 * @param xPoint
	 * @param yPoint
	 * @return
	 */
	private boolean canMove(int xPoint, int yPoint){
		if((xPoint >= 0 & xPoint <= 9) & (yPoint >= 0 & yPoint <= 17))
			return true;
		return false;
	}
	
}
