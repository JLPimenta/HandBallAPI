import java.util.List;

public class Campeonato {

	private String name;
	private List<Match> match;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Match> getMatch() {
		return match;
	}
	public void setMatch(List<Match> match) {
		this.match = match;
	}
}
