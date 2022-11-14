package crp.handball.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crp.handball.API.model.person.DTO.DataListPerson;
import crp.handball.API.model.team.Team;
import crp.handball.API.model.team.DTO.DataCreateTeam;
import crp.handball.API.model.team.DTO.DataListTeam;
import crp.handball.API.repository.PersonRepository;
import crp.handball.API.repository.teamRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("teams")
public class teamController {

    @Autowired
    private teamRepository repository;

    @Autowired
    private PersonRepository personRepository;

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

    @GetMapping("/{id}-players")
    public Page<DataListPerson> listAllPlayers(
            @PageableDefault(size = 10, sort = { "name" }, direction = Direction.ASC) Pageable pagination,
            @PathVariable("id") Integer id) {
        return personRepository.getAllPlayersByTeam(id, pagination).map(DataListPerson::new);
    }
}
