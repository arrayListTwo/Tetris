package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

/**
 * 游戏界面的配置文件对象
 * 
 * @author arraylistTwo
 *
 */
public class FrameConfig {
	
	/**
	 * 游戏名称
	 */
	private static String TITLE;
	
	/**
	 * 游戏切图边框宽度
	 */
	private static int SIZE;
	
	/**
	 * 游戏的下方的填充
	 */
	private static int PADDING;
	
	/**
	 * 游戏界面的宽度
	 */
	private static int WIDTH;
	
	/**
	 * 游戏界面的高度
	 */
	private static int HEIGHT;
	
	/**
	 * 存放界面相关的配置数值
	 */
	private static List<LayerConfig> LAYERS;
	
	private FrameConfig() {}
	
	/**
	 * 返回游戏界面的配置文件对象并将配置文件中的值提取出来
	 * @param frameConfigOfElement 根标签下frame子标签元素
	 * @return 游戏界面的配置文件对象
	 */
	public static FrameConfig getFrameConfig(Element frameConfigOfElement){
		//将配置文件里面的配置提取出来
		extractConfig(frameConfigOfElement);
		//声明一个界面配置对象
		FrameConfig frameConfig = new FrameConfig();
		return frameConfig;
	}
	
	/**
	 * 将配置文件里面的值提取出来
	 * @param frameConfigOfElement 
	 */
	private static void extractConfig(Element frameConfigOfElement){
		//从配置文件里面读取出来配置值
		TITLE = frameConfigOfElement.attributeValue("title");
		SIZE = Integer.parseInt(frameConfigOfElement.attributeValue("size"));
		PADDING = Integer.parseInt(frameConfigOfElement.attributeValue("padding"));
		WIDTH = Integer.parseInt(frameConfigOfElement.attributeValue("width"));
		HEIGHT = Integer.parseInt(frameConfigOfElement.attributeValue("height"));
		//取出配置文件里面的标签列表
		@SuppressWarnings("unchecked")
		List<Element> layerOfTemporary = frameConfigOfElement.elements("layer");
		//创建一个集合用于存储标签里面的值
		List<LayerConfig> layerConfig = new ArrayList<LayerConfig>();
		//循环遍历集合，创建LayConfig对象并添加到集合中
		for(Element layer : layerOfTemporary){
			layerConfig.add(new LayerConfig(layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("xStart")),
					Integer.parseInt(layer.attributeValue("yStart")),
					Integer.parseInt(layer.attributeValue("width")),
					Integer.parseInt(layer.attributeValue("height"))));
		}
		//引用赋值
		LAYERS = layerConfig;
	}

	/**
	 * @return 返回游戏名
	 */
	public String getTITLE() {
		return TITLE;
	}

	/**
	 * @return 返回游戏切图的边框宽度
	 */
	public int getSIZE() {
		return SIZE;
	}

	/**
	 * @return 返回边距
	 */
	public int getPADDING() {
		return PADDING;
	}

	/**
	 * @return 返回界面的宽度
	 */
	public int getWIDTH() {
		return WIDTH;
	}

	/**
	 * @return 返回界面的高度
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}

	/**
	 * @return 返回其子标签的list集合
	 */
	public List<LayerConfig> getLAYERS() {
		return LAYERS;
	}

}
