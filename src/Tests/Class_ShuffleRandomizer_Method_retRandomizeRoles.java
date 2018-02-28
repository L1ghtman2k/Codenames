package Tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import Code.Board;
import Code.Launcher;
import Code.Person;

public class Class_ShuffleRandomizer_Method_retRandomizeRoles {

	Launcher launcher;
	Board board;
	
	@Before
	  public void setUp() {
		launcher = new Launcher();
		board = launcher.StartTheGame("Red", "Blue");
	}
	
	@Test
	public void test1() {
		List<Person> ab=board.getRandomizer().retRandomizeRoles();
		assertTrue(ab.size()==25);
	}
	
	@Test
	public void test2() {
		board=launcher.StartTheGame(6, 15, 14, 1, "Greg", "Stony");
		List<Person> ab=board.getRandomizer().retRandomizeRoles();
		assertTrue(ab.size()==36);
		assertTrue(board.getAssassins()==1);
		assertTrue(board.getBystanders()==6);
	}
	
	@Test
	public void test3() {
		board=launcher.StartTheGame(0, 15, 14, 1, "Greg", "Stony");
		List<Person> ab=board.getRandomizer().retRandomizeRoles();
		assertTrue(ab.size()==0);
	}

}
