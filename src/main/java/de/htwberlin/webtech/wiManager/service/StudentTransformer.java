package de.htwberlin.webtech.wiManager.service;

import de.htwberlin.webtech.wiManager.persistance.ModulEntity;
import de.htwberlin.webtech.wiManager.persistance.StudentEntity;
import de.htwberlin.webtech.wiManager.web.api.Student;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentTransformer {

    public Student transformEntity(StudentEntity studentEntity) {
        var moduleIdsBelegt = studentEntity.getModulesBelegt().stream().map(ModulEntity::getId).collect(Collectors.toList());
        var moduleIdsBestanden = studentEntity.getModulesBestanden().stream().map(ModulEntity::getId).collect(Collectors.toList());
        return new Student(
                studentEntity.getId(),
                studentEntity.getVorname(),
                studentEntity.getName(),
                studentEntity.getMatrikelNr(),
                studentEntity.getEmail(),
                studentEntity.getPassword(),
                studentEntity.getNotenDurchschnitt(),
                moduleIdsBelegt,
                moduleIdsBestanden);
    }
}
