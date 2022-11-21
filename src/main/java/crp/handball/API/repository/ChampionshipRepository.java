package crp.handball.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crp.handball.API.model.championship.Championship;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {

    Page<Championship> findAllByActiveTrue(Pageable pagination);
}
