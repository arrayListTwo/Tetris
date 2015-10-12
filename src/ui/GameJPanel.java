package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.GameConfig;
import config.LayerConfig;
import control.GameControl;
import control.PlayControl;
import main.Main;

/**
 * 游戏面板，用户绘制图形
 * @author arrayListTwo
 *
 */
public class GameJPanel extends JPanel {
	
	/**
	 * 游戏中各个窗口对象组成的集合
	 */
	private static List<Layer> LAYS;
	
	
	
	public GameJPanel(){
		//初始化层
		this.initLayer();
		//初始化组件
		this.initComponent();
	}
		
	private void initComponent() {
		this.addKeyListener(Main.playControl);
	}

	/**
	 * 初始化游戏界面
	 */
	private void initLayer() {
		//获得存放界面配置信息的List集合对象
		List<LayerConfig> layerConfig = GameConfig.getFRIME_CONFIG().getLAYERS();
		LAYS = new ArrayList<Layer>(layerConfig.size());
		//遍历存放界面配置信息的集合对象
		for(LayerConfig layers : layerConfig){
			Class<?> clazz = null;
			Constructor<?> constructor = null;
			Layer layer = null;
			try {
				//获得配置文件中的指定路径的Class对象
				clazz = Class.forName(layers.getClassName());
				//获得此对象的构造器对象
				constructor = clazz.getConstructor(int.class, int.class, int.class, int.class);
				//创建一个游戏界面框对象
				layer = (Layer) constructor.newInstance(layers.getxStart(),
						layers.getyStart(),
						layers.getWidth(),
						layers.getHeight());
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | 
					InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			LAYS.add(layer);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		//调用基类方法
		super.paintComponent(g);
		//遍历窗口对象数组
		for(Layer lay : LAYS){
			lay.createWindow(g);
		}	
		this.requestFocus();
	}

}
