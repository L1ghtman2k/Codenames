package Code3Teams;

/**
 * 
 * This enum contains all possible Roles on the board.
 *
 */
public enum Roles{
	Blue ("Blue Agent"), 
	Red ("Red Agent"), 
	Green("Green Agent"),
	Assassin ("Assassin"), 
	Bystander ("Bystander");
	
	private final String name;     
	private Roles(String s) {
	    name = s;
	}
	public boolean equalsName(String otherName) {
	    return name.equals(otherName);
	}

	public String toString() {
	   return this.name;
	}
}


  



