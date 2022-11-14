package crp.handball.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crp.handball.API.model.stadium.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {

    Page<Stadium> findAllByActiveTrue(Pageable pagination);

}
