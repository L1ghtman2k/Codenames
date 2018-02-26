package Code;

import java.util.Collections;
import java.util.List;

public class ShuffleRandomizer implements IRandomizer{
	
	
	
	Board board;
	public ShuffleRandomizer(Board board) {
		this.board = board;
	}
	
	/**
	 * This method returns appropriate amount of random words from ArrayList of String 
	 * wordStorage and stores them in ArrayList of String
	 * 
	 * @param wordStrorage the ArrayList of String which will provide all words to a method
	 * @return the ArrayList of string containing  random words
	 */
	
	public List<String> retRandomCodenames(List<String> wordStrage){
		
		if (wordStrage == null || wordStrage.size() < board.getTotalLocations()) {
			return null;
		}
		List<String> newList = null;
		Collections.shuffle(wordStrage);
		for (int i = 0; i < board.getTotalLocations(); i++) {
			newList.add(wordStrage.get(i));
		}
		return newList;
	}


	public List<Person> retRandomizeRoles(){
		//USE Collections.shuffle(); USE REDS BLUES ASSASSINS and grid.length*grid.length
		return null;
	}
}