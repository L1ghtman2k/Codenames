package Test2Teams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Code2Teams.IExtension;
import Code2Teams.LocalFileExtension;

public class Class_LocalFileExtension_Method_retAllCodenames {
	
	IExtension iExtension;
	@Before
	  public void setUp() {
		
		iExtension = new LocalFileExtension();
	} 
	
	@Test
	public void FileExists_ListOfStringContaining() {
		List<String> assertion = iExtension.retAllCodenames("GameWords1.txt");
		assertEquals(assertion.size(), 400);
		List<String> assertion2 = iExtension.retAllCodenames("GameWords2.txt");
		assertEquals(assertion2.size(), 50);
	}

}
