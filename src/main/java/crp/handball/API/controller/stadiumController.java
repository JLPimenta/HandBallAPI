package crp.handball.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crp.handball.API.model.stadium.Stadium;
import crp.handball.API.model.stadium.DTO.DataCreateStadium;
import crp.handball.API.model.stadium.DTO.DataListStadium;
import crp.handball.API.model.stadium.DTO.DataUpdateStadium;
import crp.handball.API.repository.StadiumRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("stadiums")
public class stadiumController {

    @Autowired
    private StadiumRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataCreateStadium data) {
        repository.save(new Stadium(data));
    }

    @GetMapping
    public Page<DataListStadium> listAllStadiums(@PageableDefault(size = 5, sort = { "name" }) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DataListStadium::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateStadium data) {
        var stadium = repository.getReferenceById(data.id());
        stadium.updateData(data);
    }

    @DeleteMapping("/{id}")
    public void inactivate(@PathVariable Integer id) {
        var stadium = repository.getReferenceById(id);
        stadium.inactivate();
    }
}
