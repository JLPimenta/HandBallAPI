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

import crp.handball.API.model.match.Match;
import crp.handball.API.model.match.DTO.DataCreateMatch;
import crp.handball.API.model.match.DTO.DataListMatch;
import crp.handball.API.model.match.DTO.DataUpdateMatch;
import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.team.Team;
import crp.handball.API.repository.MatchRepository;
import crp.handball.API.repository.teamRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("matches")
public class matchController {

    @Autowired
    private MatchRepository repository;

    @Autowired
    private teamRepository teamRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataCreateMatch data) {
        Team homeTeam = teamRepository.getReferenceById(data.homeTeam().getId());
        Stadium stadium = homeTeam.getHomeStadium();

        repository.save(new Match(data, stadium));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateMatch data) {
        var person = repository.getReferenceById(data.id());
        person.updateData(data);
    }

    @PutMapping("/match-{id}/score-{hg}-{vg}")
    public void pickWinnerTeamByGoals(@PathVariable("id") Integer id, @PathVariable("hg") Integer homeTeamGoals,
            @PathVariable("vg") Integer visitorTeamGoals) {
        Match match = repository.findMatchById(id);
        Team homeTeam = match.getHomeTeam();
        Team visitorTeam = match.getVisitorTeam();

        if (homeTeamGoals > visitorTeamGoals) {
            match.setWinnerTeam(homeTeam.getId());
            homeTeam.addPoints(2);

        }
        if (homeTeamGoals < visitorTeamGoals) {
            match.setWinnerTeam(visitorTeam.getId());
            visitorTeam.addPoints(2);

        }
        if (homeTeamGoals == visitorTeamGoals) {
            match.setWinnerTeam(null);

            homeTeam.addPoints(1);
            visitorTeam.addPoints(1);
        }
    }

    @GetMapping(value = "/list-matches")
    public Page<DataListMatch> listAllMatches(
            @PageableDefault(size = 10, sort = { "date" }, direction = Direction.ASC) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DataListMatch::new);
    }

    @GetMapping(value = "/search")
    public Page<DataListMatch> listAllMatches(
            @PageableDefault(size = 10, sort = { "date" }, direction = Direction.ASC) @RequestBody String initialDate,
            String finalDate, Pageable pagination) {
        return repository.findByDateBetween(initialDate, finalDate, pagination).map(DataListMatch::new);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public void delete(@PathVariable Integer id) {
        var person = repository.getReferenceById(id);
        person.inactivate();
    }
}
