package crp.handball.API.model.team;

import java.util.List;

import crp.handball.API.model.person.Person;
import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.team.DTO.DataCreateTeam;
import crp.handball.API.model.team.DTO.DataUpdateTeam;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamid", nullable = false)
    private Integer id;

    private String name;

    @OneToMany(targetEntity = Person.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamid", referencedColumnName = "teamid")
    private List<Person> players;

    @OneToOne(targetEntity = Person.class)
    private Person captain;

    @Column(name = "champ_id", nullable = true)
    private Integer champId;

    @OneToOne
    private Stadium homeStadium;
    private Integer points;
    private Boolean active;

    public Team(DataCreateTeam data) {
        this.active = true;
        this.name = data.name();
        this.players = data.players();
        this.captain = data.captain();
        this.homeStadium = data.homeStadium();
        this.points = 0;
    }

    public void updateData(DataUpdateTeam data) {

        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.captain() != null) {
            this.captain.updateData(data.captain());
        }
        if (data.homeStadium() != null) {
            this.homeStadium.updateData(data.homeStadium());
        }
        if (data.name() != null) {
            this.points = data.points();
        }
    }

    public void inactivate() {
        this.active = false;
    }

    public void addPoints(Integer points) {
        this.points = this.points + points;
    }
}
