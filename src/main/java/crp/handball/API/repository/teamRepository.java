package crp.handball.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crp.handball.API.model.team.Team;

@Repository
public interface teamRepository extends JpaRepository<Team, Integer> {

    Page<Team> findAllByActiveTrue(Pageable pagination);

    @Query(value = "SELECT * FROM teams t WHERE t.name LIKE %:name%", nativeQuery = true)
    Page<Team> getReferenceByName(String name, Pageable pagination);

    @Query(value = "SELECT * FROM teams t WHERE t.teamid = :id AND t.champ_id = :champId", nativeQuery = true)
    Team removeTeamByChampId(Integer champId, Integer id);

    @Query(value = "SELECT * FROM teams t WHERE t.teamid = :id AND t.champ_id = :champId", nativeQuery = true)
    Page<Team> searchTeamByChampId(Integer champId, Integer id, Pageable pagination);

}
