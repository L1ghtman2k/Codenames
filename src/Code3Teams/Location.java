package Code3Teams;

/**
 * The Location class contains the id's of every location, including the 
 * codenames, whether they have been revealed or not, and what role they have.
 */
public class Location {
	private String codename;
	private boolean revealed;
	private Person person;
	
	/**
	 * Returns the codename of the class.
	 * @return codename.
	 */
	public String getCodename() {
		return codename;
	}
	/**
	 * Sets the codename of the class.
	 * @param codename to become new codename of class.
	 */
	public void setCodename(String codename) {
		this.codename = codename;
	}
	/**
	 * Returns whether or not the location is revealed.
	 * @return true if location is revealed, false otherwise.
	 */
	public boolean isRevealed() {
		return revealed;
	}
	/**
	 * Sets whether the location is revealed or not.
	 * @param revealed - boolean stating if location is revealed or not.
	 */
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}
	/**
	 * Returns the person on the location.
	 * @return person.
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * Sets the person on the location.
	 * @param person to become new person of class.
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
