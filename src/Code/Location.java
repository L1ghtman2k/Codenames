package Code;

/**
 * The Location class contains the id's of every location, including the 
 * codenames, whether they have been revealed or not, and what role they have.
 */
public class Location {
	private String codename;
	private boolean revealed;
	private Person person;
	
	//Getters and Setters
	
	public String getCodename() {
		return codename;
	}
	public void setCodename(String codename) {
		this.codename = codename;
	}
	public boolean isRevealed() {
		return revealed;
	}
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
