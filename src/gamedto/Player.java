package gamedto;

/**
 * ��Ϸ�����Ϣ
 * @author list
 *
 */
public class Player {
	
	/**
	 * ��Ϸ�������
	 */
	private String name = null;
	
	/**
	 * ��Ϸ��ҷ���
	 */
	private int score = 0;
	
	/**
	 * ���캯��
	 * @param name �������
	 * @param score ��ҷ���
	 */
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��ȡ��ҷ���
	 * @return ��ҷ���
	 */
	public int getScore() {
		return score;
	}
	
}
