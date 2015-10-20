package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import config.GameConfig;
import tools.ImageFilter;

public class LayerBackground extends Layer{
	
	//图像文件所在的文件夹的父目录
	private static final String path = "Graphics/background";
	//图像文件所在的文件夹的父目录对象
	private static final File FOLDER = new File(path);
	//查询出图像文件夹下符合特定格式的文件名称
	private static final String[] FILES = FOLDER.list(new ImageFilter("jpg"));
	//存放背景图片对象
	private static Image[] BACKGROUND = new Image[FILES.length];
	
	static{
		for (int i = 0; i < FILES.length; i++) {
			BACKGROUND[i] = new ImageIcon(path + "/" + FILES[i]).getImage();
		}
	}
	
	public LayerBackground(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	//TODO 背景固定
	@Override
	protected void createWindow(Graphics g) {
		int times = this.gameDto.getLevel() % BACKGROUND.length;
		g.drawImage(BACKGROUND[times], 0, 0, GameConfig.getFRIME_CONFIG().getWIDTH(), GameConfig.getFRIME_CONFIG().getHEIGHT(), null);
	}

}
