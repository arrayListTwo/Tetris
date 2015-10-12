package config;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * ��Ϸ�������ļ�����(�������ģʽ)
 * @author arrayListTwo
 * 
 */
public class GameConfig {
	
	/**
	 * ��Ϸ��������ö���
	 */
	private static FrameConfig FRIME_CONFIG;
	
	/**
	 * ��Ϸϵͳ���ö���
	 */
	//TODO ϵͳ����
	private static SystemConfig SYSTEM_CONFIG;
	
	/**
	 * ��Ϸ�������ö���
	 */
	//TODO ��������
	private static DataConfig DATA_CONFIG;

	// ˽�л��乹�췽��
	private GameConfig() {
		
		// ����XML�ļ���ȡ��
		SAXReader reader = new SAXReader();
		// ����һ���ļ�����
		Document doc = null;
		try {
			// ��ȡXML�ļ����õ�һ��Document����
			doc = reader.read(new File("config/config.XML"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// ��ȡ��XML�ļ��ĸ��ڵ�
		Element game = doc.getRootElement();
		// ��ȡ���ڵ��µ�Frame��ǩԪ��
		Element frameConfigOfElement = game.element("frame");
		//��ȡ�������ö���
		FRIME_CONFIG = FrameConfig.getFrameConfig(frameConfigOfElement);
		//��ø��ڵ��µ�system��ǩԪ��
		Element systemCofigOfElement = game.element("system");
		//���ϵͳ���ö���
		SYSTEM_CONFIG = SystemConfig.getSystemConfig(systemCofigOfElement);
		//��ø��ڵ��µ�data��ǩԪ��
		Element dataConfigOfElement = game.element("data");
		//����������ö���
		DATA_CONFIG = DataConfig.getDataConfig(dataConfigOfElement);
		
	}

	/**
	 * �ڴ���һ���ص�ʱ�����static�����ͻ�ִ��
	 */
	static{
		new GameConfig();
	}

	/**
	 * @return �������ö���
	 */
	public static FrameConfig getFRIME_CONFIG() {
		return FRIME_CONFIG;
	}

	/**
	 * @return ϵͳ���ö���
	 */
	public static SystemConfig getSYSTEM_CONFIG() {
		return SYSTEM_CONFIG;
	}

	/**
	 * @return �������ö���
	 */
	public static DataConfig getDATA_CONFIG() {
		return DATA_CONFIG;
	}
		
}
