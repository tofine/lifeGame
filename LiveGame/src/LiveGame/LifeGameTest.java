package LiveGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LifeGameTest {

	private LifeGame lifeGame;
	private int[][] initMap=GameMapTest.initMap;
	
	@Before
	public void setUp() throws Exception {
		
		lifeGame=new LifeGame(initMap);
	}

	@Test
	public void testGame_cycle() {
		
		lifeGame.game_cycle();
		
		GameMap map=lifeGame.getGameMap();
		
		Assert.assertEquals(map.get(24, 24),LifeGame.ALIVE);
		Assert.assertEquals(map.get(2, 2), LifeGame.DEATH);
		Assert.assertEquals(map.get(0, 2), initMap[0][2]);
	}
}
