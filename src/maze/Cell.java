package maze;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;

public class Cell implements Cloneable, Serializable {
	private static final long serialVersionUID = -4655500596468015178L;
	
	private boolean[] walls = {true, true , true , true}; // Assume all walls are up
	private boolean green = false;
	private boolean displayValues;
	
	private int x, y;
	private int g = 0, h = 0, f = 0;
	private int direction = -1;
	
	private Color color = Color.WHITE;
	
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
	
	public String getCoords() {
		return "(" + x + ", " + y + ")";
	}
	
	public void setDirection(int d) {
		direction = d;
	}
	
	public int getDirection() {
		return direction;
	}
	
	
	// Walls
	
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
	
	
	// Colors
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setGreen(boolean state) {
		green = state;
		setColor(Color.GREEN);
	}
	
	public boolean isGreen() {
		return green;
	}
	
	
	// A*
	
	public int getF() {
		return f;
	}
	
	public int getH() {
		return h;
	}
	
	public int getG() {
		return g;
	}	
	
	public int getNewG(Cell cellBefore) {
		return Math.abs(getX() - cellBefore.getX()) + Math.abs(getY() - cellBefore.getY()) + cellBefore.getG();
	}
	
	public void update(Cell cellBefore, Cell cellEnd) {
		g = Math.abs(getX() - cellBefore.getX()) + Math.abs(getY() - cellBefore.getY()) + cellBefore.getG();
		h = Math.abs(getX() - cellEnd.getX()) + Math.abs(getY() - cellEnd.getY());
		f = g + h;
	}
	
	public void displayValues(boolean b) {
		displayValues = b;
	}
	
	public boolean willDisplayValues() {
		return displayValues;
	}
	
	
	// Misc
	
	@Override
	public Cell clone() {
		Cell cell = new Cell(this.x, this.y);
		cell.walls = Arrays.copyOf(this.walls, this.walls.length);
		cell.green = this.green;
		cell.displayValues = this.displayValues;
		cell.g = this.g;
		cell.h = this.h;
		cell.f = this.f;
		cell.direction = this.direction;
		cell.color = this.color;
		return cell;
	}
	
}
