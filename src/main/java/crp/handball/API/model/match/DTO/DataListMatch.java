package crp.handball.API.model.match.DTO;

import java.time.LocalDate;

import crp.handball.API.model.match.Match;
import crp.handball.API.model.stadium.address.Address;

public record DataListMatch(Integer id, LocalDate date, String homeTeam, String visitorTeam, String stadium,
        Address stadiumAddress) {

    public DataListMatch(Match match) {

        this(match.getId(), match.getDate(), match.getHomeTeam().getName(), match.getVisitorTeam().getName(),
                match.getStadium().getName(), match.getStadium().getAddress());

    }
}
