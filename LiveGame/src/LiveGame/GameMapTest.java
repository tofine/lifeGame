package LiveGame;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


import junit.framework.Assert;

public class GameMapTest {
	
	private static GameMap gameMap;
	static int initMap[][]= {
			{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
			{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
	};
	

	@Before
	public void setUp() throws Exception {
	
		gameMap=new GameMap(initMap);
	}

	@Test
	public void testReset() {
		
		int[][] resetMap=new int[25][25];
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				resetMap[i][j]=(int)(Math.random()+0.5);
			}
		}
		
		gameMap.reset(resetMap);
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				Assert.assertEquals(resetMap[i][j],gameMap.get(i,j));
			}
		}
		
		gameMap.reset(initMap);
	}

	@Test
	public void testGet_neighbor_count() {
		
		//�������
		Assert.assertEquals(gameMap.get_neighbor_count(0, 0),2 );//���ϽǶ���
		Assert.assertEquals(gameMap.get_neighbor_count(0, 24),2 );//���ϽǶ���
		Assert.assertEquals(gameMap.get_neighbor_count(24, 0),1);//���½Ƕ���
		Assert.assertEquals(gameMap.get_neighbor_count(24, 24),3 );//���½Ƕ���
		
		//��Ե����
		Assert.assertEquals(gameMap.get_neighbor_count(0, 2),2 );//�ϱ�Ե
		Assert.assertEquals(gameMap.get_neighbor_count(4, 0),1 );//���Ե
		Assert.assertEquals(gameMap.get_neighbor_count(24, 22),2 );//�±�Ե
		Assert.assertEquals(gameMap.get_neighbor_count(22, 24),2 );//�ұ�Ե
		
	    //����	
		Assert.assertEquals(gameMap.get_neighbor_count(1, 1),5 );
		Assert.assertEquals(gameMap.get_neighbor_count(2, 3),3 );
	}


	@Test
	public void testGet() {
		
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				Assert.assertEquals(gameMap.get(i, j),initMap[i][j]);
			}
		}
	}

}
