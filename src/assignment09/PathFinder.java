package assignment09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
 * Finds the shortest path given a maze with a start and end 
 * and creates a 2D array of that given maze
 *
 */
public class PathFinder {
	/**
	 * arr2D is a 2D character representation of the maze file
	 * height and width are the dimensions.
	 * size is how large our maze is.
	 * graph is our graph of connecting nodes.
	 */
	public static char[][] arr2D;
	public static int height;
	public static int width;
	public static int size;
	public static Graph graph;

	/**
	 * Solve maze gets the maze file name and the solution file name
	 * and solves the maze using helper functions.
	 * Prints out the maze solution to the given file name
	 * 
	 * @param inputFileName - a string of what the name of the file is
	 * @param outputFileName - the name of the file where we put the solution
	 */
	public static void solveMaze(String inputFileName, String outputFileName) {
		//maze solving
		get2D(inputFileName);
		graph = new Graph(arr2D);
		graph.BFS();

		// Output
		try (PrintWriter output = new PrintWriter(new FileWriter(outputFileName))) {
			output.println(height + " " + width);
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					output.print(arr2D[row][col]);
				}
				output.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Creates a 2D array from the given file name.
	 * 
	 * @param inputFileName - the name of the file with the maze
	 * @return - a 2D array of characters
	 */
	public static char[][] get2D(String inputFileName) {
		//reads the file
		FileReader reader = null;
		try {
			reader = new FileReader(inputFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader textReader = new BufferedReader(reader);
		String[] dimensions;
		//gets the height and width of the maze
		try {
			dimensions = textReader.readLine().split(" ");
			height = Integer.parseInt(dimensions[0]);
			width = Integer.parseInt(dimensions[1]);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		size = (height * width) - height;
		arr2D = new char[height][width];
		//fills in the 2D array with the appropriate character 
		try {
			while (textReader.ready()) {
				for (int row = 0; row < height; row++) {
					for (int col = 0; col < width; col++) {
						char symbol = ((char) textReader.read());
						if (symbol == 'X') {
							arr2D[row][col] = 'X';
						} else if (symbol == ' ') {
							arr2D[row][col] = ' ';
						} else if (symbol == 'G') {
							arr2D[row][col] = 'G';
						} else if (symbol == 'S') {
							arr2D[row][col] = 'S';
						} else if (symbol == '\n') {
							col--;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr2D;
	}

}
