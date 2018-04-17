package Test2Teams;

import java.util.Random;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Code2Teams.Board;
import Code2Teams.Launcher;
import Code2Teams.Location;
import Code2Teams.Person;
import Code2Teams.ShuffleRandomizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Class_Board_Method_LocationAssignerAndRedMove {

	@Test
	public void CodeNamesAreTakenFromGameWords1ToDefaultBoard_SetsNotRevealedSetsRolesAndSetsCodenames() {	
		Launcher launcher = new Launcher();
		Board board = launcher.StartTheGame("RedTeam", "BlueTeam");
		Location[][] grid = board.getGrid();
		boolean checker = false;	
		board.LocationAssignerAndRedMove("GameWords1.txt");	
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid.length; j++)
			{
				if(grid[i][j].isRevealed()==true || grid[i][j].getCodename() == null || grid[i][j].getPerson() == null)
				{
					checker = true;
				}
			}	
		assertFalse(checker);		
	}

	@Test 
	public void CodeNamesAreTakenFromGameWords2ToCostumeBoard_SetsNotRevealedSetsRolesAndSetsCodenames() {
		Launcher launcher = new Launcher();
		Board board = launcher.StartTheGame(7,20,20,8,"RedTeam", "BlueTeam");
		Location[][] grid = board.getGrid();
		boolean checker = false;		
		board.LocationAssignerAndRedMove("GameWords2.txt");	
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid.length; j++)
			{
				if(grid[i][j].isRevealed()==true || grid[i][j].getCodename() == null || grid[i][j].getPerson() == null)
				{
					checker = true;
				}
			}

		assertFalse(checker);
	}

}
