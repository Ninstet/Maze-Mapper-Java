package maze;

public class Cell {
	private boolean[] walls = {true, true , true , true}; // Assume all walls are up
	private int x, y;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWall(int i, boolean state) {
		walls[i] = state;
	}
	
	public boolean[] getWalls() {
		return walls;
	}
	
	public boolean hasWall(int i) {
		return walls[i];
	}
	
	public boolean checkWalls() {
		return walls[0] && walls[1] && walls[2] && walls[3];
	}
	
	public void printCell() {
		System.out.println(" " + (walls[0] ? 1 : 0) + " ");
		System.out.println((walls[3] ? 1 : 0) + " " + (walls[1] ? 1 : 0));
		System.out.println(" " + (walls[2] ? 1 : 0) + " ");
	}
	
}
