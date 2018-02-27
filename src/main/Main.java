package main;
import java.util.Arrays;
import java.util.List;

import Code.Board;
import Code.Launcher;

public class Main {
	
	public static void main(String[] args) {
		
		Launcher launcher = new Launcher();
		Board board = launcher.StartTheGame("Blue", "Red");
		List<String> newList = board.getRandomizer().retRandomCodenames
				(board.getExtension().retAllCodenames("src/GameWords1.txt"));
		System.out.println(newList);
		}
}
