 package Code;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


public class ShuffleRandomizer implements IRandomizer{
	Board board;

	/**
	 * This method returns appropriate amount of random words from ArrayList of String 
	 * wordStorage and stores them in ArrayList of String
	 * 
	 * @param wordStrorage the ArrayList of String which will provide all words to a method
	 * @return the ArrayList of string containing  random words
	 */
	public ShuffleRandomizer(Board board) {
		this.board = board;
	}
	public List<String> retRandomCodenames(List<String> wordStrage){
		if (wordStrage == null || wordStrage.size() < 	board.getTotalLocations()) {
			return null;
		}
		List<String> newList = new ArrayList<String>();
		Collections.shuffle(wordStrage);
		for (int i = 0; i < board.getTotalLocations(); i++) {
			newList.add(wordStrage.get(i));
		}
		return newList;
	}


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