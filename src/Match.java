
public class Match {
	private String date;
	private Team homeTeam;
	private Team visitorTeam;
	private Stadium stadium;
	
	public String getDate() {
		return date;
	}
	
	public Match(String date, Team homeTeam, Team visitorTeam, Stadium stadium) {
		super();
		this.date = date;
		this.homeTeam = homeTeam;
		this.visitorTeam = visitorTeam;
		this.stadium = stadium;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	public Team getVisitorTeam() {
		return visitorTeam;
	}
	
	public void setVisitorTeam(Team visitorTeam) {
		this.visitorTeam = visitorTeam;
	}
	
	public Stadium getStadium() {
		return stadium;
	}
	
	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}
}
