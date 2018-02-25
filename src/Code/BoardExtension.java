package Code;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class BoardExtension implements Extension{
	
	/**
	 * This method returns List of String 
	 * that would contain all words from a specified text file.
	 * 
	 * @param filename the text file that contains words
	 * @return List that contains all words from filename
	 */
	public List<String> retAllCodenames(String filename) {
		List<String> list = null;
		try {
			list = Files.readAllLines(new File(filename).toPath(), 
					Charset.defaultCharset() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  list;
	}
}
