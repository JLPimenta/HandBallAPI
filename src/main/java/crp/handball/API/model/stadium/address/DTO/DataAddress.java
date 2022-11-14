package crp.handball.API.model.stadium.address.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(
                @NotBlank String place,
                String number,
                @NotBlank String city,
                @NotBlank String state,
                @NotBlank @Pattern(regexp = "\\d{8}") String zipCode) {

}
