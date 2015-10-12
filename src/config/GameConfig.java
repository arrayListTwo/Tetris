package config;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * 游戏的配置文件对象(单例设计模式)
 * @author arrayListTwo
 * 
 */
public class GameConfig {
	
	/**
	 * 游戏界面的配置对象
	 */
	private static FrameConfig FRIME_CONFIG;
	
	/**
	 * 游戏系统配置对象
	 */
	//TODO 系统配置
	private static SystemConfig SYSTEM_CONFIG;
	
	/**
	 * 游戏数据配置对象
	 */
	//TODO 数据配置
	private static DataConfig DATA_CONFIG;

	// 私有化其构造方法
	private GameConfig() {
		
		// 创建XML文件读取器
		SAXReader reader = new SAXReader();
		// 声明一个文件对象
		Document doc = null;
		try {
			// 读取XML文件，得到一个Document对象
			doc = reader.read(new File("config/config.XML"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 获取此XML文件的根节点
		Element game = doc.getRootElement();
		// 获取根节点下的Frame标签元素
		Element frameConfigOfElement = game.element("frame");
		//获取界面配置对象
		FRIME_CONFIG = FrameConfig.getFrameConfig(frameConfigOfElement);
		//获得根节点下的system标签元素
		Element systemCofigOfElement = game.element("system");
		//获得系统配置对象
		SYSTEM_CONFIG = SystemConfig.getSystemConfig(systemCofigOfElement);
		//获得根节点下的data标签元素
		Element dataConfigOfElement = game.element("data");
		//获得数据配置对象
		DATA_CONFIG = DataConfig.getDataConfig(dataConfigOfElement);
		
	}

	/**
	 * 在此类一加载的时候，这个static代码块就会执行
	 */
	static{
		new GameConfig();
	}

	/**
	 * @return 界面配置对象
	 */
	public static FrameConfig getFRIME_CONFIG() {
		return FRIME_CONFIG;
	}

	/**
	 * @return 系统配置对象
	 */
	public static SystemConfig getSYSTEM_CONFIG() {
		return SYSTEM_CONFIG;
	}

	/**
	 * @return 数据配置对象
	 */
	public static DataConfig getDATA_CONFIG() {
		return DATA_CONFIG;
	}
		
}
