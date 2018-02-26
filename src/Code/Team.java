package Code;

public class Team {
	private String TeamName;
	private int count;
	private boolean RevealedAssassin;
	private Roles agents = Roles.Red;
	
	public Team(String TeamName) {
		this.setTeamName(TeamName);
		RevealedAssassin = false;
	}
	
	public void decrementCount() {
		setCount(getCount() - 1);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public boolean isRevealedAssassin() {
		return RevealedAssassin;
	}

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
