package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

/**
 * ��Ϸ����������ļ�����
 * 
 * @author arraylistTwo
 *
 */
public class FrameConfig {
	
	/**
	 * ��Ϸ����
	 */
	private static String TITLE;
	
	/**
	 * ��Ϸ��ͼ�߿���
	 */
	private static int SIZE;
	
	/**
	 * ��Ϸ���·������
	 */
	private static int PADDING;
	
	/**
	 * ��Ϸ����Ŀ��
	 */
	private static int WIDTH;
	
	/**
	 * ��Ϸ����ĸ߶�
	 */
	private static int HEIGHT;
	
	/**
	 * ��Ž�����ص�������ֵ
	 */
	private static List<LayerConfig> LAYERS;
	
	private FrameConfig() {}
	
	/**
	 * ������Ϸ����������ļ����󲢽������ļ��е�ֵ��ȡ����
	 * @param frameConfigOfElement ����ǩ��frame�ӱ�ǩԪ��
	 * @return ��Ϸ����������ļ�����
	 */
	public static FrameConfig getFrameConfig(Element frameConfigOfElement){
		//�������ļ������������ȡ����
		extractConfig(frameConfigOfElement);
		//����һ���������ö���
		FrameConfig frameConfig = new FrameConfig();
		return frameConfig;
	}
	
	/**
	 * �������ļ������ֵ��ȡ����
	 * @param frameConfigOfElement 
	 */
	private static void extractConfig(Element frameConfigOfElement){
		//�������ļ������ȡ��������ֵ
		TITLE = frameConfigOfElement.attributeValue("title");
		SIZE = Integer.parseInt(frameConfigOfElement.attributeValue("size"));
		PADDING = Integer.parseInt(frameConfigOfElement.attributeValue("padding"));
		WIDTH = Integer.parseInt(frameConfigOfElement.attributeValue("width"));
		HEIGHT = Integer.parseInt(frameConfigOfElement.attributeValue("height"));
		//ȡ�������ļ�����ı�ǩ�б�
		@SuppressWarnings("unchecked")
		List<Element> layerOfTemporary = frameConfigOfElement.elements("layer");
		//����һ���������ڴ洢��ǩ�����ֵ
		List<LayerConfig> layerConfig = new ArrayList<LayerConfig>();
		//ѭ���������ϣ�����LayConfig������ӵ�������
		for(Element layer : layerOfTemporary){
			layerConfig.add(new LayerConfig(layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("xStart")),
					Integer.parseInt(layer.attributeValue("yStart")),
					Integer.parseInt(layer.attributeValue("width")),
					Integer.parseInt(layer.attributeValue("height"))));
		}
		//���ø�ֵ
		LAYERS = layerConfig;
	}

	/**
	 * @return ������Ϸ��
	 */
	public String getTITLE() {
		return TITLE;
	}

	/**
	 * @return ������Ϸ��ͼ�ı߿���
	 */
	public int getSIZE() {
		return SIZE;
	}

	/**
	 * @return ���ر߾�
	 */
	public int getPADDING() {
		return PADDING;
	}

	/**
	 * @return ���ؽ���Ŀ��
	 */
	public int getWIDTH() {
		return WIDTH;
	}

	/**
	 * @return ���ؽ���ĸ߶�
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}

	/**
	 * @return �������ӱ�ǩ��list����
	 */
	public List<LayerConfig> getLAYERS() {
		return LAYERS;
	}

}
