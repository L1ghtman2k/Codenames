package Code;

public class Location {
	private String role;
	private String codename;
	private boolean revealed;
	
	
	public Location(String role, String codename, boolean revealed) {
		this.role = role;
		this.codename = codename;
		this.revealed = revealed;
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
