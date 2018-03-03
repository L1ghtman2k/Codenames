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
	public void CostumeGameStarted7by7Grid8Assassins20Reds20BluesPassed_returnListOf49Peson() {
		//Check If there are 49 Persons, and they are all Bystanders
		Launcher launcher = new Launcher(); 
		Board board=launcher.StartTheGame(7, 21, 19, 8, "Greg", "Stony");
		List<Person> ab=board.getRandomizer().retRandomizeRoles();
		assertTrue(ab.size()==49);
		
		int totalBystanders = 0;
		int totalBlues = 0;
		int totalAssassins = 0;
		int totalReds = 0;
		
		for(Person i : ab) 
		{
			if(i.getRole() == Roles.Bystander) {
				totalBystanders++;
			}
			if(i.getRole() == Roles.Blue) {
				totalBlues++;
			}
			if(i.getRole() == Roles.Red) {
				totalReds++;
			}
			if(i.getRole() == Roles.Assassin) {
				totalAssassins++;
			}
		}
		assertTrue(totalBystanders == 1);
		assertTrue(totalBlues == 19);
		assertTrue(totalReds == 21);
		assertTrue(totalAssassins == 8);
	}
	
	@Test
	public void TwoDefaultBoards_returnsDifferentlyassignedRoles() {
		Launcher launcher1 = new Launcher();
		Launcher launcher2 = new Launcher();
		Board firstBoard = launcher1.StartTheGame("RedTeam", "BlueTeam");
		Board secondBoard = launcher2.StartTheGame("RedTeam", "BlueTeam");
		List<Person> a = firstBoard.getRandomizer().retRandomizeRoles();
		List<Person> a2 = secondBoard.getRandomizer().retRandomizeRoles();;
		boolean checker = false;
		
		for(int i = 0; i < a.size(); i++)
				if(!(a.get(i).getRole()==a2.get(i).getRole()))
					checker = true;			
		assertTrue(checker);
	}

}
