package main;
import Code.Board;
import Code.Launcher;
import Code.Location;

public class Main {
	
	public static void main(String[] args) {
		Launcher lounch;
		Board board;
		Location[][] grid;
		
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red");
		grid =  board.getGrid();
		board.LocationAssignerAndRedMove("src/GameWords1.txt");
		
		Launcher lounch2;
		Board board2;
		Location[][] grid2;
		
		lounch2 = new Launcher();
		board2 = lounch2.StartTheGame("Blue", "Red");
		grid2 =  board2.getGrid();
		board2.LocationAssignerAndRedMove("src/GameWords1.txt");
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j].getPerson().getRole());
			}
			System.out.println("");
		}
		System.out.println("=================================================");
		for(int i = 0; i < grid2.length; i++) {
			for(int j = 0; j < grid2.length; j++) {
				System.out.print(grid2[i][j].getPerson().getRole());
			}
			System.out.println("");
		}
	}
}
