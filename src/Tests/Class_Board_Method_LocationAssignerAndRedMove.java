package Tests;

import java.util.Random;
import java.util.List;

import Code.Board;

import Code.Launcher;
import Code.Location;
import Code.Person;
import Code.ShuffleRandomizer;

import org.junit.Test;


import static org.junit.Assert.assertTrue;


public class Class_Board_Method_LocationAssignerAndRedMove {
	
	@Test
	public void CodeNames_NotRevealed() {
		
		Random r = new Random();
		int i = r.nextInt(20);
		
		Launcher launcher = new Launcher();
		Board board = launcher.StartTheGame(5, 9, 8, 1, "RedTeam", "BlueTeam");
		Location[][] grid = board.getGrid();
		board.LocationAssignerAndRedMove("src/GameWords1.txt");
		assertTrue(!grid[i][i].isRevealed());
	}
	
	@Test 
	public void LocationsHasCodeNamesAndRoles() {
		
		Launcher launcher = new Launcher();
		Board board = launcher.StartTheGame(5, 9, 8, 1, "RedName", "BlueName");
		ShuffleRandomizer shuffle = new ShuffleRandomizer(board);
		
		Random r = new Random();
		int i = r.nextInt(5);
		int j = r.nextInt(5);
		int k = r.nextInt(25);
		int ran = r.nextInt(5);
		
		
		List<String> list = shuffle.retRandomCodenames(board.getExtension().retAllCodenames("src/GameWords1.txt"));
		List<Person> list2 = shuffle.retRandomizeRoles();
		
		Location[][] grid = board.getGrid();
		board.LocationAssignerAndRedMove("src/GameWords1.txt");
		assertTrue(grid[i][j].getCodename().equals(list.get(k)));
		assertTrue(grid[i][j].getPerson().equals(list2.get(ran)));
		
	}

}
