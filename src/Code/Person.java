package Code;

 /**
 *The Person class simply controls the role of the players.
 **/

public class Person {
	
	private Roles Role;
	/**
	 * Instantiates the Person class by assigning it a role.
	 * @param Role to be assigned to the class.
	 */
	public Person(Roles Role) {
		this.setRole(Role);
	}
	/**
	 * Gets the class's role.
	 * @return Role of class.
	 */
	public Roles getRole() {
		return Role;
	}
	/**
	 * Sets the role of the class
	 * @param role to become new role of the class.
	 */
	public void setRole(Roles role) {
		Role = role;
	}
}
