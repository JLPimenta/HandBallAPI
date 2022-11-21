package crp.handball.API.model.team.DTO;

import java.util.List;

import crp.handball.API.model.person.Person;
import crp.handball.API.model.stadium.Stadium;
import jakarta.validation.constraints.NotBlank;

public record DataCreateTeam(
        @NotBlank String name,
        List<Person> players,
        Person captain,
        Stadium homeStadium) {

}
