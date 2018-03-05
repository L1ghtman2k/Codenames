 package Code;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/**
 * 
 * Instance of this method helps to Randomize Lists of words using Collections.shuffle
 *
 */
public class ShuffleRandomizer implements IRandomizer{
	Board board;

	/**
	 * Instantiates the ShuffleRandomizer class.
	 * @param board - current board being used.
	 */
	public ShuffleRandomizer(Board board) {
		this.board = board;
	}
	/**
	 * This method returns appropriate amount of random words from ArrayList of String 
	 * wordStorage and stores them in ArrayList of String
	 * 
	 * @param wordStorage - List<String> which will provide all words to the method
	 * @return the List of string containing random words
	 */
	public List<String> retRandomCodenames(List<String> wordStorage){
		if (wordStorage == null || wordStorage.size() < 	board.getTotalLocations()) {
			return null;
		}
		List<String> newList = new ArrayList<String>();
		Collections.shuffle(wordStorage);
		for (int i = 0; i < board.getTotalLocations(); i++) {
			newList.add(wordStorage.get(i));
		}
		return newList;
	}
	
	/**
	 * This method assigns a random spot to each of the players/cards on the board
	 * using the roles from the Roles class.
	 * 
	 * @return the ArrayList of Person containing all the assigned roles.
	 */
	
	public List<Person> retRandomizeRoles(){
		List<Person> rolesList = new ArrayList<Person>();
		int reds=board.getRedsCount();
		int blues=board.getBluesCount();
		int assassins=board.getAssassins();
		int bystanders=board.getBystanders();		
		
		for(int i=0;i<reds;i++) {	
			Person b=new Person(Roles.Red);
			rolesList.add(b);
		}
		for(int i=0;i<blues;i++) {
			Person b=new Person(Roles.Blue);
			rolesList.add(b);
		}
		for(int i=0;i<assassins;i++) {
			Person b=new Person(Roles.Assassin);
			rolesList.add(b);
		}
		for(int i=0;i<bystanders;i++) {
			Person b=new Person(Roles.Bystander);
			rolesList.add(b);
		}
		Collections.shuffle(rolesList);
		return rolesList;

	}
}