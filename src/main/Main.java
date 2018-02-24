package main;
import java.util.List;

import Code.Board;
import Code.BoardExtension;
import Code.Launcher;

public class Main {
	
	public static void main(String[] args) {
		Launcher lounch = new Launcher();
		Board board = lounch.StartTheGame("Aibek", "LUL");
		List<String> check = BoardExtension.retAllCodenames("src\\GameWords1.txt");
		for(String i : check) {
			System.out.println(i);
		}
	}
}
