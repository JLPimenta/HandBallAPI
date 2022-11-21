package crp.handball.API.model.stadium.DTO;

import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.stadium.address.Address;

public record DataListStadium(Integer id, String name, Address address) {

    public DataListStadium(Stadium stadium) {
        this(stadium.getId(), stadium.getName(), stadium.getAddress());
    }
}
