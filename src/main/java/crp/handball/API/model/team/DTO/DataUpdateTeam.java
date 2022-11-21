package crp.handball.API.model.team.DTO;

import crp.handball.API.model.person.Person;
import crp.handball.API.model.person.DTO.DataUpdatePerson;
import crp.handball.API.model.stadium.DTO.DataUpdateStadium;
import jakarta.validation.constraints.NotNull;

public record DataUpdateTeam(@NotNull Integer id, String name, Person player, DataUpdatePerson captain,
                DataUpdateStadium homeStadium,
                Integer points, Integer champId) {

}
