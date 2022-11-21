package crp.handball.API.model.match.DTO;

import java.time.LocalDate;

import crp.handball.API.model.team.Team;
import jakarta.validation.constraints.NotNull;

public record DataUpdateMatch(@NotNull Integer id, LocalDate date, Team homeTeam, Team visitorTeam, Integer champId) {

}
