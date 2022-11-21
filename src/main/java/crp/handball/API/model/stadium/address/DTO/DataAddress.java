package crp.handball.API.model.stadium.address.DTO;

import jakarta.validation.constraints.NotBlank;

public record DataAddress(
        @NotBlank String place,
        String number,
        @NotBlank String city,
        @NotBlank String state,
        @NotBlank String zipCode) {

}
