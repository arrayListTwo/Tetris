package gamedto;

import java.util.List;

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
	private boolean[][] map = new boolean[10][18];
	
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

	public GameDto() {}
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
	
}
