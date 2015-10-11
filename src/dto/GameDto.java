package dto;

import java.awt.Point;
import java.util.List;

/**
 * ��Ϸ�����ݶ���
 * @author list
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
	 * ��Ϸ������ķ���
	 */
	private List<Point> rect = null;
	
	/**
	 *��Ϸ������ĵ�ͼ 
	 */
	private boolean[][] map = null;
	
	/**
	 * ��Ϸ�е���һ������
	 */
	private List<Point> nextRect = null;
	
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
	 * �����Ϸ�����䷽���������Ϣ
	 * @return �����������Ϣ
	 */
	public List<Point> getRect() {
		return rect;
	}

	/**
	 * ������Ϸ�����䷽���������Ϣ
	 * @param rect ����������Ϣ
	 */
	public void setRect(List<Point> rect) {
		this.rect = rect;
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
	 * ��ȡ��һ�������������Ϣ
	 * @return ������Ϣ
	 */
	public List<Point> getNextRect() {
		return nextRect;
	}

	/**
	 * ������һ�������������Ϣ
	 * @param nextRect ������Ϣ
	 */
	public void setNextRect(List<Point> nextRect) {
		this.nextRect = nextRect;
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
	
}
