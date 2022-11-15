package de.htwberlin.webtech.wiManager.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

List<StudentEntity> findAllByVorname(String vorname);
}
