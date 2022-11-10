package br.com.handballCamp.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@ElementCollection
	@CollectionTable(name = "listOfPeople")
	@OneToMany
	private List<Person> players = new ArrayList<>();

	@OneToOne
	private Person captain;

	@OneToOne
	private Stadium homeStadium;
	private Integer points;

	public Team(String name, Person captain, Stadium homeStadium) {
		super();
		this.name = name;
		this.captain = captain;
		this.homeStadium = homeStadium;
		this.points = 0;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", players=" + players + ", captain=" + captain + ", homeStadium="
				+ homeStadium + ", points=" + points + "]";
	}

	public void addPlayer(Person player) {
		this.players.add(player);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPlayers() {
		return players;
	}

	public void setPlayers(List<Person> players) {
		this.players = players;
	}

	public Person getCaptain() {
		return captain;
	}

	public void setCaptain(Person captain) {
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