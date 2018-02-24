package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Code.BoardCostume;
import Code.Location;

public class KarTest {

	@Test
	public void retRandomCodenames() {
		
		Location[][] grid = new Location[5][5];
		int Reds = 9;
		int Blues = 8;
		int Assasins = 1;
		String redName = "Red";
		String blueName = "Blue";
		BoardCostume boardTest = new BoardCostume(grid, Reds, Blues, Assasins, redName, blueName);
		
//		assertNotNull(boardTest.retRandomCodenames(wordStrorage))
		
		//fail("Not yet implemented");
	}

}
