package crp.handball.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crp.handball.API.model.championship.Championship;
import crp.handball.API.model.championship.DTO.DataCreateChampionship;
import crp.handball.API.model.championship.DTO.DataListChampionship;
import crp.handball.API.model.championship.DTO.DataUpdateChampionship;
import crp.handball.API.model.match.Match;
import crp.handball.API.model.match.DTO.DataListMatch;
import crp.handball.API.model.match.DTO.DataUpdateMatch;
import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.stadium.DTO.DataUpdateStadium;
import crp.handball.API.model.team.Team;
import crp.handball.API.model.team.DTO.DataListTeam;
import crp.handball.API.model.team.DTO.DataUpdateTeam;
import crp.handball.API.repository.ChampionshipRepository;
import crp.handball.API.repository.MatchRepository;
import crp.handball.API.repository.StadiumRepository;
import crp.handball.API.repository.teamRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("championship")
public class championshipController {

    @Autowired
    private ChampionshipRepository repository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private teamRepository teamRepository;

    @Autowired
    private StadiumRepository stadiumRepository;

    @PostMapping
    @Transactional
    public void createChampionship(@RequestBody @Valid DataCreateChampionship data) {
        if (data.endDate().isAfter(data.startDate()) || data.endDate().isEqual(data.startDate())) {
            repository.save(new Championship(data));
        } else {
            throw new ValidationException("A data de término não pode ser menor que a de início!");
        }
    }

    @PutMapping
    @Transactional
    public void updateChampionship(@RequestBody @Valid DataUpdateChampionship data) {
        Championship champ = repository.getReferenceById(data.id());
        champ.updateData(data);
    }

    @PutMapping("/add-match")
    @Transactional
    public void addMatch(@RequestBody DataUpdateMatch data) {
        Match match = matchRepository.getReferenceById(data.id());
        match.setChampId(data.champId());
    }

    @PutMapping("/remove-match")
    @Transactional
    public void removeMatch(@RequestBody DataUpdateMatch data) {
        Match match = matchRepository.removeMatchByChampId(data.champId(), data.id());
        match.setChampId(null);

    }

    @PutMapping("/add-team")
    @Transactional
    public void addTeam(@RequestBody DataUpdateTeam data) {
        Team team = teamRepository.getReferenceById(data.id());
        team.setChampId(data.champId());
    }

    @PutMapping("/remove-team")
    @Transactional
    public void removeTeam(@RequestBody DataUpdateMatch data) {
        Team team = teamRepository.removeTeamByChampId(data.champId(), data.id());
        team.setChampId(null);

    }

    @PutMapping("/add-stadium")
    @Transactional
    public void addStadium(@RequestBody DataUpdateStadium data) {
        Stadium stadium = stadiumRepository.getReferenceById(data.id());
        stadium.setChampId(data.champId());
    }

    @PutMapping("/remove-stadium")
    @Transactional
    public void removeStadium(@RequestBody DataUpdateMatch data) {
        Stadium stadium = stadiumRepository.removeStadiumByChampId(data.champId(), data.id());
        stadium.setChampId(null);

    }

    @GetMapping("/list-all")
    public Page<DataListChampionship> listAllChampionships(
            @PageableDefault(size = 10, sort = { "startDate" }, direction = Direction.ASC) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DataListChampionship::new);

    }

    @GetMapping("/list-table")
    public Page<DataListTeam> listAllTeamsOnChampionship(
            @PageableDefault(size = 10, sort = { "points" }, direction = Direction.ASC) @RequestBody Integer champId,
            Integer id, Pageable pagination) {
        return teamRepository.searchTeamByChampId(champId, id, pagination).map(DataListTeam::new);

    }

    @GetMapping("/{id}/matches")
    public Page<DataListMatch> listAllPlayers(
            @PageableDefault(size = 10, sort = { "date" }, direction = Direction.ASC) Pageable pagination,
            @PathVariable("id") Integer id) {
        return matchRepository.getAllMatchesByDate(id, pagination).map(DataListMatch::new);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public void deleteChampionship(@PathVariable Integer id) {
        var person = repository.getReferenceById(id);
        person.inactivate();
    }
}
