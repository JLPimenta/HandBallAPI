package crp.handball.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crp.handball.API.model.team.Team;

@Repository
public interface teamRepository extends JpaRepository<Team, Integer> {

    Page<Team> findAllByActiveTrue(Pageable pagination);
}
