package Tests;

import static org.junit.Assert.assertNull;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.Launcher;
import Code.LocalFileExtension;
import Code.ShuffleRandomizer;
import Code.Location;

public class Class_ShuffleRandomizer_Method_retRandomCodenames {
	
	Launcher launcher;
	Board board;
	ShuffleRandomizer shuffleRand;
	LocalFileExtension extension;
	
//	@Before
//	  public void setUp() {
//		launcher = new Launcher();
//		board = launcher.StartTheGame("Blue", "Red");
//	//Delete This, check for Custom, Check for Gameword2, CheckforNull
//	}
	
	@Test
	public void WordStorageIsLessThanTotalLocations_returnNull() {
		Launcher launch = new Launcher();
		board = launch.StartTheGame("RedName", "BlueName");
		List<String> mylist = Arrays.asList("A1", "Buffalo", "Knuckles");
		List<String> assertedList = board.getRandomizer().retRandomCodenames(mylist);
		assertNull(assertedList);
	}
	
	@Test
	public void ProperWordStorage_returnListOfString_GameWords1() {
	
		Board newBoard = new Board(new Location[5][5], 9, 8, 1, "RedTeam", "BlueTeam");
		shuffleRand = new ShuffleRandomizer(newBoard);
		
//		launcher = new Launcher();
//		board = launcher.StartTheGame("RedTeam", "BlueTeam");
		
		
		//board.setGrid(new Location[5][5]);
		List<String> newList = shuffleRand.retRandomCodenames(newBoard.getExtension().retAllCodenames("src/GameWords1.txt"));
		assertNotNull(newList);
		assertEquals(newList.size(), 25);
		
	}
	
	@Test
	public void ProperWordStorage_returnListOfString_GameWords2() {
		
		Board newBoard = new Board(new Location[7][7], 9, 8, 1, "RedTeam", "BlueTeam");
		shuffleRand = new ShuffleRandomizer(newBoard);
		
//		launcher = new Launcher();
//		board = launcher.StartTheGame("RedTeam", "BlueName");
//		
//		board.setGrid(new Location[7][7]);
		List<String> list = shuffleRand.retRandomCodenames(newBoard.getExtension().retAllCodenames("src/GameWords2.txt"));
		assertNotNull(list);
		assertEquals(list.size(), 49);
	}
	
	//Create two Board instances, 
	//randomize their location using gamewords1.txt, 
	//compare if locations are equal
	@Test
	public void CompareTwoDifferentBoards_returnDifferentBoards() {
		Location[][] grid = new Location[5][5];
		Board firstBoard = new Board(grid, 8, 9, 1, "RedTeam", "BlueTeam");
		Board secondBoard = new Board(grid, 8, 9, 1, "RedTeam", "BlueTeam");
		
//		firstBoard.getRandomizer().retRandomCodenames(board.getExtension().retAllCodenames("src/GameWords1.txt"));
//		secondBoard.getRandomizer().retRandomCodenames(board.getExtension().retAllCodenames("src/GameWords1.txt"));
		
		assertFalse(firstBoard.equals(secondBoard));
		assertTrue(!firstBoard.equals(secondBoard));
		assertNotNull(firstBoard);
		assertNotNull(secondBoard);
	}
	
	

}
