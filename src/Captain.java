

public class Captain {
	Player captain;

	
	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}

	public Captain(Player captain) {
		super();
		this.captain = captain;
	}
}
