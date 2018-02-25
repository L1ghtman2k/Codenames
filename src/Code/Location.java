package Code;

public class Location {
	private String codename;
	private boolean revealed;
	private Person person;
	
	
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
