package Code;

public class Location {
	private String role;
	private String codename;
	private boolean revealed;
	private Person person;
	
	
	public Location(String role, String codename, boolean revealed, Person person) {
		this.role = role;
		this.codename = codename;
		this.revealed = revealed;
		this.person = person;
	}

	public String getRole() {
		return role;
	}

	public String getCodename() {
		return codename;
	}

	public boolean isRevealed() {
		return revealed;
	}

}
