package crp.handball.API.model.championship.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateChampionship(@NotBlank String name, @NotNull LocalDate startDate,
                @NotNull LocalDate endDate) {

}
