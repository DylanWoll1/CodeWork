import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
//https://youtu.be/9Qn9BIMKoCM
public class Grid {

	private int numRows;
	private int numColumns;
	private int numBombs;
	private boolean bombGrid[][];
	private int countGrid[][];

	public Grid() {
		numRows = 10;
		numColumns = 10;
		numBombs = 25;

createBombGrid();
createCountGrid();
	}

	public Grid(int rows, int columns) {
		this.numRows = rows;
		this.numColumns = columns;
		numBombs = 25;

		

		createBombGrid();
		createCountGrid();

	}

	public Grid(int rows, int columns, int numBombs) {

		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = numBombs;

		

		createBombGrid();
		createCountGrid();

	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumBombs() {
		return numBombs;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public boolean[][] getBombGrid() {
		boolean[][] bombGridClone = new boolean[numRows][numColumns];
		for (int i = 0; i < bombGridClone.length; i++) {
			for (int j = 0; j < bombGridClone[i].length; j++) {
				bombGridClone[i][j] = bombGrid[i][j];
			}
		}
		return bombGridClone;
	}

	public int[][] getCountGrid() {
		int[][] countGridClone = new int[numRows][numColumns];

		for (int i = 0; i < countGridClone.length; i++) {
			for (int j = 0; j < countGridClone[i].length; j++) {
				countGridClone[i][j] = countGrid[i][j];
			}
		}
		return countGridClone;
	}

// to determine where the bomb is located 
	public boolean isBombAtLocation(int row, int column) {
		return bombGrid[row][column];
	}

	public int getCountAtLocation(int row, int column) {

		return countGrid[row][column];
	}

	public int genRandom(int max) {
		return ThreadLocalRandom.current().nextInt(0, max);
	}
	
	public boolean isValid(int row,int column) {
	if(row>= 0 && column>= 0 && row<numRows && column < numColumns && bombGrid[row][column]==true) {
		return true;
	}
	return false;
	}
	
	public void createBombGrid() {

		bombGrid = new boolean[numRows][numColumns];
		for (int i = 0; i < bombGrid.length; i++) {
			for (int j = 0; j < bombGrid[i].length; j++) {
				bombGrid[i][j] = false;
			}
		}

		Random random = new Random();

		int bombCount = 0;
		while (bombCount != numBombs) {
			int row = random.nextInt(numRows);
			int column = random.nextInt(numColumns);
			boolean bombValue = bombGrid[row][column];
			if (bombValue == false) {
				bombGrid[row][column] = true;
				bombCount += 1;
			}
		}
	}


// this counter will be counting the postion of the mines
	public void createCountGrid() {
		countGrid = new int[numRows][numColumns];

		for (int i = 0; i < numRows; i++) {

		for (int j = 0; j < numColumns; j++) {
			int bombs = 0; 
			if(bombGrid[i][j]== true) { 
			bombs+=1; } 
			if(isValid(i,j-1)){ 
			bombs += 1; } 
			if(isValid(i-1,j-1)){ 
			bombs += 1; } 
			if(isValid(i-1,j)){ 
			bombs += 1; } 
			if(isValid(i-1,j+1)){ 
			bombs += 1; } 
			if(isValid(i,j+1)){ 
			bombs += 1; } 
			if(isValid(i+1,j+1)){ 
			bombs += 1; } 
			if(isValid(i+1,j)){
			 bombs += 1; } 
			if(isValid(i+1,j-1)){ 
			bombs += 1; } 
			countGrid[i][j] = bombs; 
			} } }


	
}
