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
import javax.persistence.Table;

@Entity
@Table(name = "champs")
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "listOfMatches")
    @OneToMany
    private List<Match> match = new ArrayList<>();

    public Championship(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Championship [id=" + id + ", name=" + name + ", match=" + match + "]";
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

    public void addMatch(Match match) {
        this.match.add(match);
    }

    public Match getMatch(int ref) {
        return this.getAllMatch().get(ref);
    }

    public List<Match> getAllMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

}
