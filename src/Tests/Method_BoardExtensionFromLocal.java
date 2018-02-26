package Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Code.BoardExtensionFromLocal;
import Code.IExtension;

public class Method_BoardExtensionFromLocal {
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	IExtension iExtension;
	@Before
	  public void setUp() {
		iExtension = new BoardExtensionFromLocal();
	} 
	
	@Test
	public void ListIsEmpty_returnsNull() {
		assertNull(iExtension.retAllCodenames("dsa"));
	}

}
