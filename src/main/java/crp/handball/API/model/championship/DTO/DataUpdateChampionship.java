package crp.handball.API.model.championship.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.team.Team;
import jakarta.validation.constraints.NotNull;

public record DataUpdateChampionship(@NotNull Integer id, String name, LocalDate startDate, LocalDate endDate,
        Match match, Team team, Stadium stadium) {

}
