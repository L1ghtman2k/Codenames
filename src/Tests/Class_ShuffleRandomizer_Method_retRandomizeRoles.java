package Tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import Code.Board;
import Code.Launcher;
import Code.Person;
import Code.Roles;

public class Class_ShuffleRandomizer_Method_retRandomizeRoles {
	
	@Test
	public void DefaultGameStarted_returnListOf25Peson() {
		Launcher launcher = new Launcher(); 
		Board board = launcher.StartTheGame("Greg", "Stony");
		List<Person> ab=board.getRandomizer().retRandomizeRoles();
		assertTrue(ab.size()==25);
	}
	
	@Test
	public void CostumeGameStarted_returnListOf36Peson()  {
		Launcher launcher = new Launcher(); 
		Board board=launcher.StartTheGame(6, 15, 14, 1, "Greg", "Stony");
		List<Person> ab=board.getRandomizer().retRandomizeRoles();
		assertTrue(ab.size()==36);
		assertTrue(board.getAssassins()==1);
		assertTrue(board.getBystanders()==6);
	}
	
	@Test
	public void CostumeGameStarted7by7Grid0Assassins0Reds0BluesPassed_returnListOf36Peson() {
		//Check If there are 49 Persons, and they are all Bystanders
		Launcher launcher = new Launcher(); 
		Board board=launcher.StartTheGame(7, 0, 0, 0, "Greg", "Stony");
		List<Person> ab=board.getRandomizer().retRandomizeRoles();
		assertTrue(ab.size()==49);
		int totalBystanders = 0;
		for(Person i : ab) 
		{
			if(i.getRole() == Roles.Bystander) {
				totalBystanders++;
			}
		}
		assertTrue(totalBystanders == 49);
	}

}
