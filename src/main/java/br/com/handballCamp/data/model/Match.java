package br.com.handballCamp.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matches")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String date;

	@OneToOne
	private Team homeTeam;

	@OneToOne
	private Team visitorTeam;

	@OneToOne
	private Stadium stadium;

	public Match(String date, Team homeTeam, Team visitorTeam) {
		this.date = date;
		this.homeTeam = homeTeam;
		this.visitorTeam = visitorTeam;
		this.stadium = homeTeam.getStadium();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
