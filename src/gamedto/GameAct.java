package gamedto;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author arrayListTwo
 * 
 * ��Ϸ�еĶ���˹����
 */
public class GameAct {
	
	/**
	 * ����˹����ĳ�ʼ������Ϣ
	 */
	private static final List<Point[]> ACT_POINTS;

	/**
	 * ����˹������Ϣ
	 */
	private Point[] actPoint = null;
	
	/**
	 * �����������
	 */
	private Random random = new Random();
	
	/**
	 * ����˹��������ͱ�ʶ
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
	 * �����ƶ������������ƶ�����false�����ƶ�����true
	 * @param xMove X��ƫ����
	 * @param yMove Y��ƫ����
	 * @return ƫ���Ƿ�ִ��
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
	 * �������ת
	 * @param map ��Ϸ������ĵ�ͼ
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
	 *�Ƿ�����ƶ�
	 * @param xPoint xƫ����
	 * @param yPoint yƫ����
	 * @return ���ƶ�����true�������ƶ�����false
	 */
	private boolean canMove(int xPoint, int yPoint, boolean[][] map){
		if(xPoint >= 0 && xPoint <= 9 && yPoint >= 0 && yPoint <= 17 && (!map[xPoint][yPoint]))
			return true;
		return false;
	}

	/**
	 * @return ÿһ�ֶ���˹����ı�ʶ��
	 */
	public int getActCode() {
		return actCode;
	}

	/**
	 * @return ����˹����ĳ�ʼ������Ϣ
	 */
	public static List<Point[]> getActPoints() {
		return ACT_POINTS;
	}
	
}
