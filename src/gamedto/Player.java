package gamedto;

/**
 * 游戏玩家信息
 * @author list
 *
 */
public class Player {
	
	/**
	 * 游戏玩家姓名
	 */
	private String name = null;
	
	/**
	 * 游戏玩家分数
	 */
	private int score = 0;
	
	/**
	 * 构造函数
	 * @param name 玩家姓名
	 * @param score 玩家分数
	 */
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * 获取玩家姓名
	 * @return 玩家姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取玩家分数
	 * @return 玩家分数
	 */
	public int getScore() {
		return score;
	}
	
}
