
public class Match {
	private String date;
	private Team homeTeam;
	private Team visitorTeam;
	private Stadium stadium;
	
	public Match(String date, Team homeTeam, Team visitorTeam) {
		this.date = date;
		this.homeTeam = homeTeam;
		this.visitorTeam = visitorTeam;
		this.stadium = homeTeam.getStadium();
	}
	
	public String getDate() {
		return date;
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
