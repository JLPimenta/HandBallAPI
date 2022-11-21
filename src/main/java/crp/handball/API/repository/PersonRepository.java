package crp.handball.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crp.handball.API.model.person.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Page<Person> findAllByActiveTrue(Pageable pagination);

    @Query(value = "SELECT * FROM people p WHERE p.name LIKE %:name%", nativeQuery = true)
    Page<Person> getReferenceByName(String name, Pageable pagination);

    @Query(value = "SELECT * FROM people p WHERE p.teamid = :id", nativeQuery = true)
    Page<Person> getAllPlayersByTeam(Integer id, Pageable pagination);

    @Query(value = "SELECT * FROM people p WHERE p.personid = :id AND p.teamid = :teamid", nativeQuery = true)
    Person removePlayerTeamById(Integer teamid, Integer id);

    @Query(value = "SELECT * FROM people p INNER JOIN teams t ON p.personid = t.captain_personid WHERE t.captain_personid = :id", nativeQuery = true)
    Person getPlayerByCaptainId(Integer id);
}