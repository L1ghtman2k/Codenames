package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.Launcher;
public class Class_Board_Method_isClueLegal {
	Launcher lounch;
	Board board;
	@Before
	  public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red");
	}
	
	@Test
	public void ClueLegal_returnsTrue(){
		String clue = new String();
		assertTrue(clue.length()>0);
		
		
	}
	@Test
	public void ClueIllegal_returnsFalse(){
		String clue = new String();
		assertFalse(clue.isEmpty());
		
	}

}
