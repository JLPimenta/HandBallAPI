package crp.handball.API.model.match;

import java.time.LocalDate;

import crp.handball.API.model.match.DTO.DataCreateMatch;
import crp.handball.API.model.match.DTO.DataUpdateMatch;
import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.team.Team;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Match")
@Table(name = "matches")
@EqualsAndHashCode(of = "id")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id", nullable = false)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @OneToOne(targetEntity = Team.class)
    private Team homeTeam;

    @OneToOne(targetEntity = Team.class)
    private Team visitorTeam;

    @OneToOne(targetEntity = Stadium.class)
    private Stadium stadium;

    @OneToOne(targetEntity = Team.class)
    private Integer winnerTeam;

    @Column(name = "champ_id", nullable = true)
    private Integer champId;

    private Boolean active;

    public Match(DataCreateMatch data, Stadium stadium) {
        this.date = data.date();
        this.homeTeam = data.homeTeam();
        this.visitorTeam = data.visitorTeam();
        this.stadium = stadium;
        this.active = true;
    }

    public void updateData(DataUpdateMatch data) {
        if (data.date() != null) {
            this.date = data.date();
        }
        if (data.homeTeam() != null) {
            this.homeTeam = data.homeTeam();

        }
        if (data.visitorTeam() != null) {
            this.visitorTeam = data.visitorTeam();
        }
        if (data.champId() != null) {
            this.champId = data.champId();
        }

    }

    public void inactivate() {
        this.active = false;
    }

}
