package crp.handball.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crp.handball.API.model.person.Person;
import crp.handball.API.model.person.DTO.DataCreatePerson;
import crp.handball.API.model.person.DTO.DataListPerson;
import crp.handball.API.model.person.DTO.DataUpdatePerson;
import crp.handball.API.repository.PersonRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("people")
public class personController {

    @Autowired
    private PersonRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataCreatePerson data) {
        repository.save(new Person(data));
    }

    @GetMapping(value = "/list-players")
    public Page<DataListPerson> listAllPlayers(
            @PageableDefault(size = 10, sort = { "name" }, direction = Direction.ASC) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DataListPerson::new);
    }

    @GetMapping(value = "/search/name={name}")
    public Page<DataListPerson> SearchPlayerByName(
            @PageableDefault(sort = { "name" }, direction = Direction.ASC) @PathVariable("name") String name,
            Pageable pagination) {

        return repository.getReferenceByName(name.toLowerCase(), pagination).map(DataListPerson::new);

    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdatePerson data) {
        var person = repository.getReferenceById(data.id());
        person.updateData(data);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public void delete(@PathVariable Integer id) {
        var person = repository.getReferenceById(id);
        person.inactivate();
    }
}
