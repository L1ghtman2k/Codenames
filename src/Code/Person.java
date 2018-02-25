package Code;



public class Person {
	
	private Roles Role;
	
	public Person(Roles Role) {
		this.setRole(Role);
	}

	public Roles getRole() {
		return Role;
	}

	public void setRole(Roles role) {
		Role = role;
	}
}
