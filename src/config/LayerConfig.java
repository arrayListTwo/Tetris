package config;

/**
 * 游戏中界面框架的初始配置
 * @author arrayListTwo
 *
 */
public class LayerConfig {
	
	/**
	 * 框架所属类的名称
	 */
	private String className = null;
	
	/**
	 * 框架左上角的x坐标
	 */
	private int xStart = 0;
	
	/**
	 * 框架左上角的y坐标
	 */
	private int yStart = 0;
	
	/**
	 * 框架的宽度
	 */
	private int width = 0;
	
	/**
	 * 框架的高度
	 */
	private int height = 0;
	
	LayerConfig(String className, int xStrat, int yStart, int width, int height) {
		this.className = className;
		this.xStart = xStrat;
		this.yStart = yStart;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * 返回此框架所属的类的名称
	 * @return 类的名称
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 返回框架左上角的x坐标
	 * @return x坐标
	 */
	public int getxStart() {
		return xStart;
	}

	/**
	 * 返回框架的左上角的y坐标
	 * @return y坐标
	 */
	public int getyStart() {
		return yStart;
	}

	/**
	 * 返回框架的宽度
	 * @return 框架的宽度
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 返回框架的高度
	 * @return 框架的高度
	 */
	public int getHeight() {
		return height;
	}

}
