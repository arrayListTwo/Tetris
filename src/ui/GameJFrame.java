package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.GameConfig;

/**
 * 
 * 游戏窗口
 * 
 * @author arrayListTwo
 *
 */
public class GameJFrame extends JFrame {
	
	/**
	 * 加上这个像素，用来抵消掉窗口边框占用的像素
	 */
	private static final int PADDING = GameConfig.getFRIME_CONFIG().getPADDING();
	
	public GameJFrame() {
		//初始化游戏窗口
		init();
	}

	/**
	 * 初始化游戏窗口，设置游戏窗口的基本信息
	 */
	private void init() {
		//游戏窗口的名称(配置文件中读取)
		this.setTitle(GameConfig.getFRIME_CONFIG().getTITLE());
		//设置框架的布局
		this.setLayout(new BorderLayout());
		//游戏窗口的大小(配置文件中读取)
		this.setSize(GameConfig.getFRIME_CONFIG().getWIDTH(), GameConfig.getFRIME_CONFIG().getHEIGHT() + PADDING);
		//将游戏窗口居中
		Toolkit toolkit = this.getToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.setLocation((screen.width - this.getWidth()) >> 1, (screen.height - this.getHeight()) >> 1);
		//设置游戏窗口大小不可变
		this.setResizable(false);
		//设置默认游戏窗口关闭的动作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置默认JPanel
		this.setContentPane(new GameJPanel());
		//设置游戏窗口可见
		this.setVisible(true);
	}

}
