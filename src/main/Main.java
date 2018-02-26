package main;
import java.util.Arrays;
import java.util.List;

import Code.Board;
import Code.Launcher;

public class Main {
	
	public static void main(String[] args) {
		
		Launcher launcher = new Launcher();
		Board board = launcher.StartTheGame("Blue", "Red");
		List<String> mylist = Arrays.asList("A1", "Buffalo", "Knuckles");
		List<String> assertedList = board.getRandomizer().retRandomCodenames(mylist);
		System.out.println(assertedList);
	}
}
