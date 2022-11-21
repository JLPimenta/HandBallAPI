package crp.handball.API.model.championship;

import java.time.LocalDate;
import java.util.List;

import crp.handball.API.model.championship.DTO.DataCreateChampionship;
import crp.handball.API.model.championship.DTO.DataUpdateChampionship;
import crp.handball.API.model.match.Match;
import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.team.Team;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Championship")
@Table(name = "champs")
@EqualsAndHashCode(of = "id")
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "champ_id", nullable = false)
    private Integer id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(targetEntity = Match.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "champ_id", referencedColumnName = "champ_id")
    private List<Match> match;

    @OneToMany(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "champ_id", referencedColumnName = "champ_id")
    private List<Team> teams;

    @OneToMany(targetEntity = Stadium.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "champ_id", referencedColumnName = "champ_id")
    private List<Stadium> stadiums;

    private Boolean active;

    public Championship(DataCreateChampionship data) {
        this.active = true;
        this.name = data.name();
        this.startDate = data.startDate();
        this.endDate = data.endDate();
    }

    public void inactivate() {
        this.active = false;
    }

    public void updateData(@Valid DataUpdateChampionship data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.startDate() != null) {
            this.startDate = data.startDate();
        }
        if (data.endDate() != null) {
            this.endDate = data.endDate();
        }
    }
}
