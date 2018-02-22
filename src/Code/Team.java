package Code;

public class Team {
	private String Team;
	private int count;
	
	public void decrementCount() {
		setCount(getCount() - 1);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
