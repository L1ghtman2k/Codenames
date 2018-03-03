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
import Code.Location;

public class Class_ShuffleRandomizer_Method_retRandomCodenames {
	
	Launcher launcher;
	Board board;
	
	@Before
	public void setup() {
		launcher = new Launcher();
	}
	
	@Test
	public void WordStorageIsLessThanTotalLocations_returnNull() {
		board = launcher.StartTheGame("RedName", "BlueName");
		List<String> mylist = Arrays.asList("A1", "Buffalo", "Knuckles");
		List<String> assertedList = board.getRandomizer().retRandomCodenames(mylist);
		assertNull(assertedList);
	}
	
	@Test
	public void ProperWordStorage_returnListOfString_GameWords1() {
		board = launcher.StartTheGame("RedName", "BlueName");
		
		List<String> newList = board.getRandomizer().retRandomCodenames(board.getExtension().retAllCodenames("src/GameWords1.txt"));
		assertNotNull(newList);
		assertEquals(newList.size(), 25);
	}
	
	@Test
	public void ProperWordStorage_returnListOfString_GameWords2() {
		board = launcher.StartTheGame(7,9,8,1,"RedName", "BlueName");
		List<String> list = board.getRandomizer().retRandomCodenames(board.getExtension().retAllCodenames("src/GameWords2.txt"));
		assertNotNull(list);
		assertEquals(list.size(), 49);
	}
 
	@Test
	public void CompareTwoDifferentBoards_returnDifferentBoards() {
		Launcher launcher1 = new Launcher();
		Launcher launcher2 = new Launcher();
		Board firstBoard = launcher1.StartTheGame("RedTeam", "BlueTeam");
		Board secondBoard = launcher2.StartTheGame("RedTeam", "BlueTeam");
		List<String> a = firstBoard.getRandomizer().retRandomCodenames(firstBoard.getExtension().retAllCodenames("src/GameWords1.txt"));
		List<String> a2 = secondBoard.getRandomizer().retRandomCodenames(secondBoard.getExtension().retAllCodenames("src/GameWords1.txt"));
		boolean checker = false;
		
		for(int i = 0; i < a.size(); i++)
				if(!a.get(i).equals(a2.get(i)))
					checker = true;			
		assertTrue(checker);
		
	}
	
	

}
