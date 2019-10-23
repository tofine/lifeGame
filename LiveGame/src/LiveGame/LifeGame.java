package LiveGame;

import java.awt.event.ActionListener;

public class LifeGame {

	private GameMap gameMap;
	final static int ALIVE =1;
	final static int DEATH =0;
	private int[][] newAlive;
	//�����������г�ʼ��ʵ��
	public LifeGame(int[][] life_init_ratio) {
		
		gameMap=new GameMap(life_init_ratio);
		newAlive=new int[gameMap.getRows()][gameMap.getCols()];
	}
	
	//����һ����Ϸѭ�������ڴ���ɵ�ͼ�ĸ��£����ڼ�ʱ������ʱ������
	public void game_cycle() {
		
		int status;
		for(int i=0;i<gameMap.getRows();i++) {
		    for(int j=0;j<gameMap.getCols();j++) {
		    	
		    	status=gameMap.get_neighbor_count(i, j);
		    	
				if(status==2) {
					newAlive[i][j]=gameMap.get(i, j);
				}
				else if(status==3) {
					newAlive[i][j]=ALIVE;
				}
				else {
					newAlive[i][j]=DEATH;
				}
			}
		}
		gameMap.reset(newAlive);
	}

	
	public void setGameMap(GameMap map) {
		this.gameMap=map;
	}
	
	public GameMap getGameMap() {
		return gameMap;
	}
	
	
	//Ϊstart��ťע���¼�
	public void setStart(ActionListener e) {
		gameMap.setStart(e);
	}
}
