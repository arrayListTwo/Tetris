package config;

/**
 * ��Ϸ�н����ܵĳ�ʼ����
 * @author arrayListTwo
 *
 */
public class LayerConfig {
	
	/**
	 * ��������������
	 */
	private String className = null;
	
	/**
	 * ������Ͻǵ�x����
	 */
	private int xStart = 0;
	
	/**
	 * ������Ͻǵ�y����
	 */
	private int yStart = 0;
	
	/**
	 * ��ܵĿ��
	 */
	private int width = 0;
	
	/**
	 * ��ܵĸ߶�
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
	 * ���ش˿���������������
	 * @return �������
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * ���ؿ�����Ͻǵ�x����
	 * @return x����
	 */
	public int getxStart() {
		return xStart;
	}

	/**
	 * ���ؿ�ܵ����Ͻǵ�y����
	 * @return y����
	 */
	public int getyStart() {
		return yStart;
	}

	/**
	 * ���ؿ�ܵĿ��
	 * @return ��ܵĿ��
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * ���ؿ�ܵĸ߶�
	 * @return ��ܵĸ߶�
	 */
	public int getHeight() {
		return height;
	}

}
