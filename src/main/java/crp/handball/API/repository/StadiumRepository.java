package crp.handball.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crp.handball.API.model.stadium.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {

    Page<Stadium> findAllByActiveTrue(Pageable pagination);

    @Query(value = "SELECT * FROM stadium s WHERE s.stadiumid = :id AND s.champ_id = :champId", nativeQuery = true)
    Stadium removeStadiumByChampId(Integer champId, Integer id);

}
