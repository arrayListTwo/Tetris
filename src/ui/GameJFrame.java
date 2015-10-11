package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.GameConfig;

/**
 * 
 * ��Ϸ����
 * 
 * @author arrayListTwo
 *
 */
public class GameJFrame extends JFrame {
	
	/**
	 * ����������أ��������������ڱ߿�ռ�õ�����
	 */
	private static final int PADDING = GameConfig.getFRIME_CONFIG().getPADDING();
	
	public GameJFrame() {
		//��ʼ����Ϸ����
		init();
	}

	/**
	 * ��ʼ����Ϸ���ڣ�������Ϸ���ڵĻ�����Ϣ
	 */
	private void init() {
		//��Ϸ���ڵ�����(�����ļ��ж�ȡ)
		this.setTitle(GameConfig.getFRIME_CONFIG().getTITLE());
		//���ÿ�ܵĲ���
		this.setLayout(new BorderLayout());
		//��Ϸ���ڵĴ�С(�����ļ��ж�ȡ)
		this.setSize(GameConfig.getFRIME_CONFIG().getWIDTH(), GameConfig.getFRIME_CONFIG().getHEIGHT() + PADDING);
		//����Ϸ���ھ���
		Toolkit toolkit = this.getToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.setLocation((screen.width - this.getWidth()) >> 1, (screen.height - this.getHeight()) >> 1);
		//������Ϸ���ڴ�С���ɱ�
		this.setResizable(false);
		//����Ĭ����Ϸ���ڹرյĶ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����Ĭ��JPanel
		this.setContentPane(new GameJPanel());
		//������Ϸ���ڿɼ�
		this.setVisible(true);
	}

}
