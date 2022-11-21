package crp.handball.API.model.match.DTO;

import java.time.LocalDate;

import crp.handball.API.model.team.Team;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DataCreateMatch(LocalDate date, @NotNull @Valid Team homeTeam,
                @NotNull @Valid Team visitorTeam) {
}
