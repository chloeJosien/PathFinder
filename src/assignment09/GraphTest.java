package assignment09;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * I pledge that the work done here was my own and that I have learned how to
 * write this program, such that I could throw it out and restart and finish it
 * in a timely manner. I am not turning in any work that I cannot understand,
 * describe, or recreate. I further acknowledge that I contributed substantially
 * to all code handed in and vouch for it's authenticity. Haisley Brooking, Chloe Josien
 * 
 * @author Haisley Brooking
 * @author Chloe Josien
 * 
 * Tests the graph class.
 *
 */
public class GraphTest {
	
	/**
	 * Test for how many steps it took to reach the goal.
	 */
	@Test
	public void testDotCount() {
		PathFinder pathFinder = new PathFinder();
		int mazeDot = Graph.shortestPath;
		char[][] sol = pathFinder.get2D("Resources/Solutions/randomMazeSol.txt");
		int solDot = 0;
		for(int row= 0; row < pathFinder.height; row++){
			for(int col = 0; col < pathFinder.width; col++){
				if(sol[row][col] == '.'){
					solDot++;
				}
			}
		}
		assertEquals(mazeDot, solDot);
	}

}
