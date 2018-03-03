package Tests;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.Launcher;
import Code.Location;

public class Class_Board_Method_LocationStatusUpdater {

	Launcher lounch;
	Board board;
	Location[][] grid;
	@Before
	  public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red");
		grid =  board.getGrid();
	}
	
	@Test
	public void Test1(){
	}
}
