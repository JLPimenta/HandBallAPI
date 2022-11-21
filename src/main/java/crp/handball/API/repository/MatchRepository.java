package crp.handball.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import crp.handball.API.model.match.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    @Query(value = "SELECT * FROM matches m WHERE m.date BETWEEN ':initialDate' AND ':finalDate' AND m.active = 1", nativeQuery = true)
    Page<Match> findByDateBetween(@Param("initialDate") String initialDate, @Param("finalDate") String finalDate,
            Pageable pagination);

    Page<Match> findAllByActiveTrue(Pageable pagination);

    @Query(value = "SELECT * FROM matches m WHERE m.match_id = :id AND t.champ_id = :champId", nativeQuery = true)
    Match removeMatchByChampId(Integer champId, Integer id);

    @Query(value = "SELECT * FROM matches m WHERE m.match_id = :id", nativeQuery = true)
    Match findMatchById(Integer id);

    @Query(value = "SELECT * FROM matches m WHERE m.champ_id = :id", nativeQuery = true)
    Page<Match> getAllMatchesByDate(Integer id, Pageable pagination);

}
