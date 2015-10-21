package service;

import java.awt.Point;
import java.util.Random;

import gamedto.GameAct;
import gamedto.GameDto;

/**
 * ��Ϸ�߼���
 * @author arrayListTwo
 *
 */
public class GameService {
	
	/**
	 * ���ݶ�������
	 */
	private GameDto gameDto;
	
	/**
	 * �����������
	 */
	private Random random = new Random();
	
	public GameService(GameDto gameDto) {
		this.gameDto = gameDto;
		//������������������һ������������ʾ��һ������˹����
		int actCode = random.nextInt(GameAct.getActPoints().size());
		GameAct gameAct = new GameAct(actCode);
		this.gameDto.setGameAct(gameAct);
		//������һ������˹�������ͣ��洢����
		this.gameDto.setNext(random.nextInt(GameAct.getActPoints().size()));
	}

	/**
	 * �����ƶ�
	 */
	public void leftMove() {
		this.gameDto.getGameAct().actMove(-1, 0, this.gameDto.getMap());
	}

	/**
	 * ��ת
	 */
	public void round() {
		if(this.gameDto.getGameAct().getActCode() != 4){
			this.gameDto.getGameAct().round(this.gameDto.getMap());
		}
		return;
	}

	/**
	 * �����ƶ�
	 */
	public void rightMove() {
		this.gameDto.getGameAct().actMove(1, 0, this.gameDto.getMap());
	}

	/**
	 * �����ƶ�
	 * @return 
	 */
	public boolean downMove() {
		//�ж϶���˹�����Ƿ�����ƶ�
		if(this.gameDto.getGameAct().actMove(0, 1, this.gameDto.getMap())){
			return true;
		}
		//�����Ϸ��ͼ����
		boolean[][] map = this.gameDto.getMap();
		//��������ʾ����Ϸ��ͼ��
		this.displayGameAct(map);
		//��ȥ������
		int removeLine = plusExp(map);
		//��Ϸ�ӷ�
		this.plusPoint(removeLine);
		//��Ϸ����ȥ�˶�����
		this.gameDto.setRemoveLine(this.gameDto.getRemoveLine() + removeLine);
		//��Ϸ�ȼ��仯
		this.plusLevel(this.gameDto.getRemoveLine());
		//�����Ϸ���������еĶ���˹�����ʶ
		this.gameDto.getGameAct().initAct(this.gameDto.getNext());
		//����һ������˹�����ʶ�洢����
		this.gameDto.setNext(random.nextInt(GameAct.getActPoints().size()));
		return false;
	}
	
	public void decline(){
		while(this.downMove());
	}

	/**
	 * ��Ϸ�ӷ�
	 * @param removeLine �˴���ȥ�˶�����
	 */
	private void plusPoint(int removeLine) {
		if(removeLine == 0)
			return;
		this.gameDto.setPoint(this.gameDto.getPoint() + this.gameDto.getLinePoint().get(removeLine));
	}

	/**
	 * ��Ϸ�ȼ��仯
	 * @param removeLine ��Ϸ���ڵĵȼ�
	 */
	private void plusLevel(int removeLine) {
		if((removeLine - (this.gameDto.getLevel() * 20)) >= 20){
			this.gameDto.setLevel(this.gameDto.getLevel() + 1);
		}
	}

	/**
	 * ����Ϸ��ͼ����ʾ����
	 * @param map ��Ϸ��ͼ
	 */
	private void displayGameAct(boolean[][] map) {
		//��ö���˹���������������Ϣ
		Point[] actpoints = this.gameDto.getGameAct().getActPoint();
		//ѭ����������˹�����������Ϣ
		for (int i = 0; i < actpoints.length; i++) {
			map[actpoints[i].y][actpoints[i].x] = true;
		}
	}

	/**
	 * ����ȥ�˶�����
	 * @param map ��Ϸ��ͼ
	 * @return ��ȥ������
	 */
	private int plusExp(boolean[][] map) {
		//��ʱ��¼��ȥ������
		int removeLine = 0;
		//ѭ��������Ϸ��ͼ���Ƿ���ڿ�����
		for (int row = 0; row < map.length; row++) {
			//�ж��Ƿ������
			if(!this.isCanRemoveLine(row, map))
				continue;
			//ִ�����в���
			this.removeLine(map, row);
			//��ȥ��������1
			removeLine++;
		}
		return removeLine;
	}

	/**
	 * ִ�����в���
	 * @param map ��Ϸ��ͼ
	 * @param row ��
	 */
	private void removeLine(boolean[][] map, int row) {
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++) {
				map[i + 1][j] = map[i][j];
				map[i][j] = false;
			}
		}
		//����һ��ȫ����Ϊfalse
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = false;
		}
	}

	/**
	 * �жϴ����Ƿ������ȥ
	 * @param row ��
	 * @param map ��Ϸ��ͼ
	 * @return true���������ȥһ�У�false����������
	 */
	private boolean isCanRemoveLine(int row, boolean[][] map) {
		for (int column = 0; column < map[0].length; column++) {
			if(!map[row][column])
				return false;
		}
		return true;
	}

	public void test() {
		//���м�һ
		this.gameDto.setRemoveLine(this.gameDto.getRemoveLine() + 1);
		//�жϵȼ��Ƿ��һ
		if(this.gameDto.getRemoveLine() - (this.gameDto.getLevel() * 20) >= 20){
			this.gameDto.setLevel(this.gameDto.getLevel() + 1);
		}
		//���ӷ���
		this.gameDto.setPoint(this.gameDto.getPoint() + this.gameDto.getLinePoint().get(1));
	}

}
