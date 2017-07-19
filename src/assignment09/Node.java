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
 * Creates nodes with a row and column
 *
 */
public class Node {
	/**
	 * north, south, east, and west are the neighboring nodes of a given node.
	 * previous is the previous node of the given node.
	 * row and col are the positions in the array the given node is in.
	 * seen is a boolean flag used in traversal.
	 */
	public Node north;
	public Node south;
	public Node east;
	public Node west;
	public Node previous;
	public int row;
	public int col;
	public boolean seen;

	/**
	 * gives the node data
	 * 
	 * @param _row
	 *            - the row the node is in
	 * @param _col
	 *            - the column the node is in
	 */
	public Node(int _row, int _col) {
		this.seen = false;
		row = _row;
		col = _col;
	}

	/**
	 * marks that this node has been visited in traversal
	 */
	public void visited() {
		seen = true;
	}
}
