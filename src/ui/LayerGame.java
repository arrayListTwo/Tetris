package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import gamedto.GameAct;

/**
 * 
 * 游戏主窗口
 * @author list
 *
 */
public class LayerGame extends Layer {
	
	/**
	 * 游戏中的俄罗斯方块的源图
	 */
	private static final Image IMAGE_ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	
	/**
	 * 俄罗斯方块的高度
	 */
	private static final int ACT_SIZE = IMAGE_ACT.getHeight(null);
	
	public LayerGame(int xStart, int yStart, int width, int height) {
		super(xStart, yStart, width, height);
	}
	
	@Override
	protected void createWindow(Graphics g) {
		super.createWindow(g);
		this.drawAct(g);
	}

	/**
	 * 绘制俄罗斯方块
	 * @param g 画笔
	 */
	public void drawAct(Graphics g){
		Point[] points = this.gameDto.getGameAct().getActPoints();
		for (int i = 0; i < points.length; i++) {
			g.drawImage(IMAGE_ACT,
					this.X_START + (points[i].x << 5) + SIZE,
					this.Y_START + (points[i].y << 5) + SIZE,
					(this.X_START + (points[i].x << 5)) + ACT_SIZE + SIZE,
					(this.Y_START + (points[i].y << 5)) + ACT_SIZE + SIZE,
					0, 0, 32, 32, null);
		}
		//在地图上绘制俄罗斯方块
		this.drawMap(g);
	}

	/**
	 * 在地图上绘制固定了的俄罗斯方块
	 * @param g 画笔
	 */
	private void drawMap(Graphics g) {
		
		boolean[][] map = this.gameDto.getMap();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j])
					g.drawImage(IMAGE_ACT,
							this.X_START + (i << 5) + SIZE,
							this.Y_START + (j << 5) + SIZE,
							(this.X_START + (i << 5)) + ACT_SIZE + SIZE,
							(this.Y_START + (j << 5)) + ACT_SIZE + SIZE,
							0, 0, 32, 32, null);
			}
		}
		
	}
	
}
