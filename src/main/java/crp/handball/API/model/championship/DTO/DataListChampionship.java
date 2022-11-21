package crp.handball.API.model.championship.DTO;

import java.time.LocalDate;

import crp.handball.API.model.championship.Championship;

public record DataListChampionship(Integer id, String name, LocalDate startDate, LocalDate endDate) {

    public DataListChampionship(Championship championship) {
        this(championship.getId(), championship.getName(), championship.getStartDate(), championship.getEndDate());
    }
}
