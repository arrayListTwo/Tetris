package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.GameConfig;
import config.LayerConfig;
import control.PlayControl;
import gamedto.GameDto;

/**
 * ��Ϸ��壬�û�����ͼ��
 * @author arrayListTwo
 *
 */
public class GameJPanel extends JPanel {
	
	/**
	 * ��Ϸ�и������ڶ�����ɵļ���
	 */
	private static List<Layer> LAYS;
	
	private GameDto gameDto = null;
	
	public GameJPanel(GameDto gameDto){
		//���DTO����
		this.gameDto = gameDto;
		//��ʼ����
		this.initLayer();
		//��ʼ�����
		this.initComponent();
	}
	
	/**
	 * ����Ϸ�����ϰ�װ��ҿ�����
	 * @param playControl ��ҿ�����
	 */
	public void setGameControl(PlayControl playControl){
		this.addKeyListener(playControl);
	}
	
	/**
	 * ��ʼ����Ϸ���
	 */
	private void initComponent() {
		
	}

	/**
	 * ��ʼ����Ϸ����
	 */
	private void initLayer() {
		//��ô�Ž���������Ϣ��List���϶���
		List<LayerConfig> layerConfig = GameConfig.getFRIME_CONFIG().getLAYERS();
		LAYS = new ArrayList<Layer>(layerConfig.size());
		//������Ž���������Ϣ�ļ��϶���
		for(LayerConfig layers : layerConfig){
			Class<?> clazz = null;
			Constructor<?> constructor = null;
			Layer layer = null;
			try {
				//��������ļ��е�ָ��·����Class����
				clazz = Class.forName(layers.getClassName());
				//��ô˶���Ĺ���������
				constructor = clazz.getConstructor(int.class, int.class, int.class, int.class);
				//����һ����Ϸ��������
				layer = (Layer) constructor.newInstance(layers.getxStart(),
						layers.getyStart(),
						layers.getWidth(),
						layers.getHeight());
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | 
					InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			//Ϊ����������DTO����
			layer.setGameDto(this.gameDto);
			//�������Ľ��������ӵ�������
			LAYS.add(layer);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		//���û��෽��
		super.paintComponent(g);
		//�������ڶ�������
		for(Layer lay : LAYS){
			lay.createWindow(g);
		}	
		//��ý���
		this.requestFocus();
	}

}
