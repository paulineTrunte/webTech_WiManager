package de.htwberlin.webtech.wiManager.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModulRepository extends JpaRepository<ModulEntity,Long> {

    List<ModulEntity> findAllBySemester(int semester);
}
