import java.util.ArrayList;
import java.util.List;

public class Team {
	private String name;
	private List<Player> players = new ArrayList<Player>();
	private Captain captain;
	private Stadium homeStadium;
	private Integer points;
	
	
	public Team(String name, Captain captain, Stadium homeStadium, Integer points) {
		super();
		this.name = name;
		this.captain = captain;
		this.homeStadium = homeStadium;
		this.points = points;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public Captain getCaptain() {
		return captain;
	}
	
	public void setCaptain(Captain captain) {
		this.captain = captain;
	}
	
	public Stadium getStadium() {
		return homeStadium;
	}
	
	public void setStadium(Stadium stadium) {
		this.homeStadium = stadium;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
}
