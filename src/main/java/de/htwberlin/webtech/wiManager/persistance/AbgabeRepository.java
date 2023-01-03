package de.htwberlin.webtech.wiManager.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AbgabeRepository extends JpaRepository<AbgabeEntity,Long> {

    List<AbgabeEntity> findAllByFrist(Date frist);

}
