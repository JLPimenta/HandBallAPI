package crp.handball.API.model.person.DTO;

import crp.handball.API.model.person.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreatePerson(
                @NotBlank String name,
                @NotBlank String birthDate,
                @NotNull Gender gender,
                Double height,
                Double weight) {

}
