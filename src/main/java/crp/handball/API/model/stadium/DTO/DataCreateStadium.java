package crp.handball.API.model.stadium.DTO;

import crp.handball.API.model.stadium.address.DTO.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateStadium(
        @NotBlank String name,
        @NotNull @Valid DataAddress address) {

}
