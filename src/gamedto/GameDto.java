package gamedto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��Ϸ�����ݶ���
 * @author arrayListTwo
 *
 */
public class GameDto {
	
	/**
	 * ���ݿ��е���Ϸ��¼
	 */
	private List<Player> dbPlays = null;
	
	/**
	 * ���ش����е���Ϸ��¼
	 */
	private List<Player> diskPlays = null;
	
	/**
	 *��Ϸ�еĶ���˹���� 
	 */
	private GameAct gameAct;
	
	/**
	 *��Ϸ������ĵ�ͼ 
	 */
	private boolean[][] map = null;
	
	/**
	 * ��Ϸ�÷�
	 */
	private int point = 0;
	
	/**
	 *��Ϸ����ȥ������ 
	 */
	private int removeLine = 0;
	
	/**
	 * ��Ϸ�ļ���
	 */
	private int level = 0;
	
	/**
	 * ��һ������
	 */
	private int next = 0;
	
	/**
	 * ��ȥ��������Ӧ�ķ���
	 */
	private Map<Integer, Integer> linePoint;

	public GameDto() {
		map = new boolean[18][10];
		linePoint = new HashMap<Integer, Integer>(4);
		linePoint.put(1, 10);
		linePoint.put(2, 30);
		linePoint.put(3, 50);
		linePoint.put(4, 80);
	}
	/**
	 * ��ȡ���ݿ��¼
	 * @return ���ݿ��¼�����Players�����List����
	 */
	public List<Player> getDbPlays() {
		return dbPlays;
	}

	/**
	 *������ݿ��¼
	 * @param dbPlays ��Ҷ���
	 */
	public void addDbPlays(Player dbPlays) {
		this.dbPlays.add(dbPlays);
	}

	/**
	 * ��ȡ���ش��̼�¼
	 * @return ���ش��̼�¼����
	 */
	public List<Player> getDiskPlays() {
		return diskPlays;
	}

	/**
	 * ���һ����Ҷ���
	 * @param diskPlays ��Ҷ���
	 */
	public void addDiskPlays(Player diskPlay) {
		this.diskPlays.add(diskPlay);
	}

	/**
	 * �����Ϸ���������
	 * @return ��Ϸ���������
	 */
	public boolean[][] getMap() {
		return map;
	}

	/**
	 * ������Ϸ������
	 * @param map ��Ϸ���������
	 */
	public void setMap(boolean[][] map) {
		this.map = map;
	}

	/**
	 * ��ȡ��ǰ����
	 * @return ����
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * ���õ�ǰ����
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * ��ȡ��ǰ����ȥ������
	 * @return
	 */
	public int getRemoveLine() {
		return removeLine;
	}

	/**
	 * ������ȥ������
	 * @param removeLine ����
	 */
	public void setRemoveLine(int removeLine) {
		this.removeLine = removeLine;
	}

	/**
	 * ��ȡ��ǰ�ȼ�
	 * @return �ȼ�
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * ���õ�ǰ�ȼ�
	 * @param level �ȼ�
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * @return ��Ϸ�еķ������
	 */
	public GameAct getGameAct() {
		return gameAct;
	}
	
	/**
	 * @param gameAct ������Ϸ�еĶ���˹����
	 */
	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}
	
	/**
	 * @return ��һ����������
	 */
	public int getNext() {
		return next;
	}
	
	/**
	 * @param next ��һ����������
	 */
	public void setNext(int next) {
		this.next = next;
	}
	public Map<Integer, Integer> getLinePoint() {
		return linePoint;
	}
	
}
