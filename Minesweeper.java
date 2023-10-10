
public class Minesweeper{
		public Minesweeper(int i) {
		// TODO Auto-generated constructor stub
		}

		public static void main(String args[]){
		Grid grid = new Grid();
		boolean[][] bomb_grid = grid.getBombGrid();
		int[][] count_grid = grid.getCountGrid();
		for(int i=0;i<grid.getNumRows();i++){
		for(int j=0;j<grid.getNumColumns();j++){
		System.out.print(bomb_grid[i][j] + " ");
		}
		System.out.println();
		}

		for(int i=0;i<grid.getNumRows();i++){
		for(int j=0;j<grid.getNumColumns();j++){
		System.out.print(count_grid[i][j] + " ");
		}
		System.out.println();
		}
		}
}
