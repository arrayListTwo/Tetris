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
	 * 阴影图像
	 */
	private static final Image IMAGE_SHADOW = new ImageIcon("Graphics/game/shodow.png").getImage();
	
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
		Point[] points = this.gameDto.getGameAct().getActPoint();
		int actCode = this.gameDto.getGameAct().getActCode();
		for (int i = 0; i < points.length; i++) {
			g.drawImage(IMAGE_ACT,
					this.X_START + (points[i].x << 5) + SIZE,
					this.Y_START + (points[i].y << 5) + SIZE,
					(this.X_START + (points[i].x << 5)) + ACT_SIZE + SIZE,
					(this.Y_START + (points[i].y << 5)) + ACT_SIZE + SIZE,
					(actCode + 1) << 5, 0, ((actCode + 1) << 5) + (1 << 5), (1 << 5), null);
		}
		//给下落的方块绘制阴影
		this.showShadow(points, g);
		//在地图上绘制俄罗斯方块
		this.drawMap(g);
	}

	/**
	 * 绘制阴影
	 * @param points 俄罗斯方块的坐标信息
	 * @param g 游戏画笔
	 */
	private void showShadow(Point[] points, Graphics g) {
		//俄罗斯方块的最大x坐标
		int xMax = this.xMax(points);
		//俄罗斯方块在最小x坐标
		int xMin = this.xMin(points);
		g.drawImage(IMAGE_SHADOW, this.X_START + this.SIZE + (xMin << 5), this.Y_START + this.SIZE,
				(xMax - xMin + 1) << 5, this.WINDOW_HEIGHT - (this.SIZE << 1), null);
	}

	/**
	 * 俄罗斯方块中的最大x坐标
	 * @param points 俄罗斯方块坐标信息
	 * @return 最大x坐标
	 */
	private int xMax(Point[] points) {
		int xMax = points[0].x;
		for (int i = 0; i < points.length; i++) {
			if(xMax < points[i].x)
				xMax = points[i].x;
		}
		return xMax;
	}
	
	/**
	 * 俄罗斯方块中的最小x坐标信息
	 * @param points 俄罗斯方块坐标信息
	 * @return 最下x坐标
	 */
	private int xMin(Point[] points) {
		int xMin = points[0].x;
		for (int i = 0; i < points.length; i++) {
			if(xMin > points[i].x)
				xMin = points[i].x;
		}
		return xMin;
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
							this.X_START + (j << 5) + SIZE,
							this.Y_START + (i << 5) + SIZE,
							(this.X_START + (j << 5)) + ACT_SIZE + SIZE,
							(this.Y_START + (i << 5)) + ACT_SIZE + SIZE,
							0, 0, 1 << 5, 1 << 5, null);
			}
		}
		
	}
	
}
