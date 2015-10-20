package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import config.GameConfig;
import tools.ImageFilter;

public class LayerBackground extends Layer{
	
	//ͼ���ļ����ڵ��ļ��еĸ�Ŀ¼
	private static final String path = "Graphics/background";
	//ͼ���ļ����ڵ��ļ��еĸ�Ŀ¼����
	private static final File FOLDER = new File(path);
	//��ѯ��ͼ���ļ����·����ض���ʽ���ļ�����
	private static final String[] FILES = FOLDER.list(new ImageFilter("jpg"));
	//��ű���ͼƬ����
	private static Image[] BACKGROUND = new Image[FILES.length];
	
	static{
		for (int i = 0; i < FILES.length; i++) {
			BACKGROUND[i] = new ImageIcon(path + "/" + FILES[i]).getImage();
		}
	}
	
	public LayerBackground(int X_START, int Y_START, int WINDOW_WIDTH, int WINDOW_HEIGHT) {
		super(X_START, Y_START, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	//TODO �����̶�
	@Override
	protected void createWindow(Graphics g) {
		int times = this.gameDto.getLevel() % BACKGROUND.length;
		g.drawImage(BACKGROUND[times], 0, 0, GameConfig.getFRIME_CONFIG().getWIDTH(), GameConfig.getFRIME_CONFIG().getHEIGHT(), null);
	}

}
