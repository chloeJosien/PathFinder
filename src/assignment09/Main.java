package assignment09;

/**
 * I pledge that the work done here was my own and that I have learned how to
 * write this program, such that I could throw it out and restart and finish it
 * in a timely manner. I am not turning in any work that I cannot understand,
 * describe, or recreate. I further acknowledge that I contributed substantially
 * to all code handed in and vouch for it's authenticity. Haisley Brooking, Chloe Josien
 * 
 * @author Haisley Brooking
 * @author Chloe Josien
 * 
 * Runs the solve maze function in path finder to
 * solve a given maze.
 *
 */
public class Main {
	
	/**
	 * Calls solve maze on the pathfinder 
	 * object to solve mazes
	 * @param args
	 */
	public static void main(String[] args){
		//Solving all the mazes given to us
		PathFinder pathFinder = new PathFinder();
//		pathFinder.solveMaze("Resources/bigMaze.txt", "Resources/Solutions/bigMazeSol.txt");
//		pathFinder.solveMaze("Resources/classic.txt", "Resources/Solutions/classicSol.txt");
//		pathFinder.solveMaze("Resources/unsolvable.txt", "Resources/Solutions/unsolvableSol.txt");
//		pathFinder.solveMaze("Resources/turn.txt", "Resources/Solutions/turnSol.txt");
//		pathFinder.solveMaze("Resources/tinyOpen.txt", "Resources/Solutions/tinyOpenSol.txt");
//		pathFinder.solveMaze("Resources/tinyMaze.txt", "Resources/Solutions/tinyMazeSol.txt");
//		pathFinder.solveMaze("Resources/straight.txt", "Resources/Solutions/straightSol.txt");
//		pathFinder.solveMaze("Resources/randomMaze.txt", "Resources/Solutions/randomMazeSol.txt");
//		pathFinder.solveMaze("Resources/mediumMaze.txt", "Resources/Solutions/mediumMazeSol.txt");
//		pathFinder.solveMaze("Resources/demoMaze.txt", "Resources/Solutions/demoMazeSol.txt");
		
		//Test example for problem 3 on the analysis
		//**Note: count is static, so only one maze at a time or it will accumulate both counts!**
//		pathFinder.solveMaze("Resources/emptyMaze", "Resources/Solutions/emptyMazeSol.txt");
		pathFinder.solveMaze("Resources/emptyComparison", "Resources/Solutions/emptyComparisonSol.txt");
		System.out.println(Graph.count);
	}
	
}
