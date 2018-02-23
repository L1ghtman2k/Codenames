package Code;

public class Team {
	private String TeamName;
	private int count;
	
	public Team(String TeamName) {
		this.setTeamName(TeamName);
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
	
	
}
