package crp.handball.API.model.person.DTO;

import crp.handball.API.model.person.Gender;
import crp.handball.API.model.person.TypePlayer;
import jakarta.validation.constraints.NotNull;

public record DataUpdatePerson(
                @NotNull Integer id,
                String name,
                String birthDate,
                Gender gender,
                Double height,
                Double weight,
                Integer teamId,
                TypePlayer type) {

}
