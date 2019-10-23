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
		
		//¶¥µã²âÊÔ
		Assert.assertEquals(gameMap.get_neighbor_count(0, 0),2 );//×óÉÏ½Ç¶¥µã
		Assert.assertEquals(gameMap.get_neighbor_count(0, 24),2 );//ÓÒÉÏ½Ç¶¥µã
		Assert.assertEquals(gameMap.get_neighbor_count(24, 0),1);//×óÏÂ½Ç¶¥µã
		Assert.assertEquals(gameMap.get_neighbor_count(24, 24),3 );//ÓÒÏÂ½Ç¶¥µã
		
		//±ßÔµ²âÊÔ
		Assert.assertEquals(gameMap.get_neighbor_count(0, 2),2 );//ÉÏ±ßÔµ
		Assert.assertEquals(gameMap.get_neighbor_count(4, 0),1 );//×ó±ßÔµ
		Assert.assertEquals(gameMap.get_neighbor_count(24, 22),2 );//ÏÂ±ßÔµ
		Assert.assertEquals(gameMap.get_neighbor_count(22, 24),2 );//ÓÒ±ßÔµ
		
	    //ÆäÓà	
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
