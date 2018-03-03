package Code;

/**
 *The Team class is in charge of most of the players/cards, and
 *is able to control the count and agents
 */
public class Team {
	private String TeamName;
	private int count = 0;
	private boolean RevealedAssassin;
	private Roles agents = Roles.Red;
	
	public Team(String TeamName) {
		this.setTeamName(TeamName);
		RevealedAssassin = false;
	}
	/**
	 * Lowers the count by 1.
	 */
	public void decrementCount() {
		setCount(getCount() - 1);
	}
	
	/**
	 * Returns the count.
	 * @return count.
	 */
	public int getCount() {
		return count;
	}
	/**
	 * Sets the count.
	 * @param count - int.
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * Returns the team's name
	 * @return TeamName - String of team's name.
	 */
	public String getTeamName() {
		return TeamName;
	}
	/**
	 * Set's the team's name.
	 * @param teamName - String to become the team's name.
	 */
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	/**
	 * Returns if the assassin has been revealed or not.
	 * @return true if assassin has been revealed, false otherwise.
	 */
	public boolean isRevealedAssassin() {
		return RevealedAssassin;
	}
	/**
	 * Sets whether or not the assassin has been revealed.
	 * @param revealedAssassin - boolean.
	 */
	public void setRevealedAssassin(boolean revealedAssassin) {
		RevealedAssassin = revealedAssassin;
	}
	
	public Roles getAgents() {
		return agents;
	}
	
	public void setAgents(Roles agents) {
		this.agents = agents;
	}
	
	
}

