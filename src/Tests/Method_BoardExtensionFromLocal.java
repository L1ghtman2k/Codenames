package Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Code.BoardExtensionFromLocal;
import Code.Extension;

public class Method_BoardExtensionFromLocal {
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	Extension extension;
	@Before
	  public void setUp() {
		extension = new BoardExtensionFromLocal();
	} 
	
	@Test
	public void ListIsEmpty_returnsNull() {
		assertNull(extension.retAllCodenames("dsa"));
	}

}
