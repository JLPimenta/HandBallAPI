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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crp.handball.API.model.person.Person;
import crp.handball.API.model.person.TypePlayer;
import crp.handball.API.model.person.DTO.DataListPerson;
import crp.handball.API.model.person.DTO.DataUpdatePerson;
import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.team.Team;
import crp.handball.API.model.team.DTO.DataCreateTeam;
import crp.handball.API.model.team.DTO.DataListTeam;
import crp.handball.API.model.team.DTO.DataUpdateTeam;
import crp.handball.API.repository.PersonRepository;
import crp.handball.API.repository.StadiumRepository;
import crp.handball.API.repository.teamRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("teams")
public class teamController {

    @Autowired
    private teamRepository repository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StadiumRepository stadiumRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody DataCreateTeam data) {
        repository.save(new Team(data));
    }

    @GetMapping("/list-all")
    public Page<DataListTeam> listAllTeams(
            @PageableDefault(size = 10, sort = { "name" }, direction = Direction.ASC) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DataListTeam::new);

    }

    @GetMapping("/{id}/players")
    public Page<DataListPerson> listAllPlayers(
            @PageableDefault(size = 10, sort = { "name" }, direction = Direction.ASC) Pageable pagination,
            @PathVariable("id") Integer id) {
        return personRepository.getAllPlayersByTeam(id, pagination).map(DataListPerson::new);
    }

    @GetMapping(value = "/search")
    public Page<DataListTeam> SearchTeamByName(
            @PageableDefault(sort = { "name" }, direction = Direction.ASC) @RequestParam String name,
            Pageable pagination) {

        return repository.getReferenceByName(name, pagination).map(DataListTeam::new);

    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateTeam data) {
        Team team = repository.getReferenceById(data.id());
        team.updateData(data);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public void delete(@PathVariable Integer id) {
        var person = repository.getReferenceById(id);
        person.inactivate();
    }

    @PutMapping("/add-player")
    @Transactional
    public void addPlayerTeam(@RequestBody DataUpdatePerson data) {
        Person person = personRepository.getReferenceById(data.id());
        person.setTeamId(data.teamId());
    }

    @PutMapping("/remove-player")
    @Transactional
    public void removePlayerTeam(@RequestBody DataUpdatePerson data) {
        var person = personRepository.removePlayerTeamById(data.teamId(), data.id());
        person.setTeamId(null);

    }

    @PutMapping("/set-stadium")
    @Transactional
    public void updateStadium(@RequestParam Integer stadiumId, Integer teamId) {
        Stadium stadium = stadiumRepository.getReferenceById(stadiumId);
        Team team = repository.getReferenceById(teamId);
        team.setHomeStadium(stadium);

    }

    @PutMapping("/captain/select-captain")
    @Transactional
    public void setTeamCaptain(@RequestParam("player") Integer playerId, @RequestParam("team") Integer teamId) {

        Person person = personRepository.getReferenceById(playerId);
        Team team = repository.getReferenceById(teamId);

        person.setType(TypePlayer.CAPTAIN);
        team.setCaptain(person);
    }

    @DeleteMapping("/captain/remove-captain")
    @Transactional
    public void removeTeamCaptain(@RequestParam("player") Integer playerId, @RequestParam("team") Integer teamId) {

        Person person = personRepository.getReferenceById(playerId);
        Team team = repository.getReferenceById(teamId);

        person.setType(TypePlayer.PLAYER);
        team.setCaptain(null);
    }

}
