package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Application.view.GameModeController;
/**
 * 
 * Instance of this class makes possible to convert local .txt files to List of String.
 *
 */
public class LocalFileExtension implements IExtension{
	
	/**
	 * This method returns List of String 
	 * that would contain all words from a specified text file.
	 * 
	 * @param filename the text file that contains words
	 * @return List that contains all words from filename
	 */
	public List<String> retAllCodenames(String filename) {
		List<String> list = new ArrayList<String>();
		try {
			
			InputStream in = LocalFileExtension.class.getResourceAsStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while( (line = reader.readLine()) != null)
			{
			   list.add(line);
			}
		} catch (IOException e) {
			return null;
		}
		return list;
	}
}
