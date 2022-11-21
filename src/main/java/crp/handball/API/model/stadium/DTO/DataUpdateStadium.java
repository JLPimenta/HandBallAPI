package crp.handball.API.model.stadium.DTO;

import crp.handball.API.model.stadium.address.DTO.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataUpdateStadium(
                @NotNull Integer id,
                String name,
                DataAddress address,
                Integer champId) {

}
