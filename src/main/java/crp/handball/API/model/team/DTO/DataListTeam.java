package crp.handball.API.model.team.DTO;

import crp.handball.API.model.person.Person;
import crp.handball.API.model.team.Team;

public record DataListTeam(Integer id, String name, Person captain, Integer points) {

    public DataListTeam(Team team) {

        this(team.getId(), team.getName(), team.getCaptain(), team.getPoints());
    }
}
