package crp.handball.API.model.team.DTO;

import crp.handball.API.model.person.Person;
import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.team.Team;

public record DataListTeam(Integer id, String name, Person captain,
        Stadium homeStadium) {

    public DataListTeam(Team team) {

        this(team.getId(), team.getName(), team.getCaptain(), team.getHomeStadium());
    }
}
