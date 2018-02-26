package Tests;

import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.LocalFileExtension;
import Code.Launcher;

public class Method_retRandomCodenames {
	
	Launcher launcher;
	Board board;
	
	@Before
	  public void setUp() {
		launcher = new Launcher();
		board = launcher.StartTheGame("Blue", "Red");
	}
	
	@Test
	public void WordStorageIsLessThanTotalLocations_returnNull() {
		List<String> mylist = Arrays.asList("A1", "Buffalo", "Knuckles");
		List<String> assertedList = board.getRandomizer().retRandomCodenames(mylist);
		assertNull(assertedList);
	}
	
	@Test
	public void WordStorageIsMoreThanTotalLocations_returnListOfString() {
		
	}
	
	@Test
	public void WordStorageIsNull_returnNull() {
		
	}
	@Test
	public void WordStorageIsEqualTotalLocations_returnNull() {
		
	}
	

}
