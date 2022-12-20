package de.htwberlin.webtech.wiManager.service;

import de.htwberlin.webtech.wiManager.persistance.StudentEntity;
import de.htwberlin.webtech.wiManager.persistance.StudentRepository;
import de.htwberlin.webtech.wiManager.web.api.Student;
import de.htwberlin.webtech.wiManager.web.api.StudentCreateOrUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentTransformer studentTransformer;

    public StudentService(StudentRepository studentRepository, StudentTransformer studentTransformer) {
        this.studentRepository = studentRepository;
        this.studentTransformer = studentTransformer;
    }

    public List<Student> findAll(){
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Student findById(Long id){
        var studentEntity = studentRepository.findById(id);
        return studentEntity.map(this::transformEntity).orElse(null);
    }

    public Student create(StudentCreateOrUpdateRequest request){
        var studentEntity = new StudentEntity(
                request.getVorname(),
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getMatrikelNr(),
                request.getNotenDurchschnitt(),
                request.getLpGesamt());
        studentEntity = studentRepository.save(studentEntity);
        return transformEntity(studentEntity);

    }

    public Student update(Long id, StudentCreateOrUpdateRequest request){
        var studentEntityOptional = studentRepository.findById(id);
        if (studentEntityOptional.isEmpty()){
            return null;
        }

        var studentEntity = studentEntityOptional.get();
        studentEntity.setVorname(request.getVorname());
        studentEntity.setName(request.getName());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setPassword(request.getPassword());
        studentEntity.setMatrikelNr(request.getMatrikelNr());
        studentEntity.setNotenDurchschnitt(request.getNotenDurchschnitt());
        studentEntity.setLpGesamt(request.getLpGesamt());
        studentEntity = studentRepository.save(studentEntity);

        return transformEntity(studentEntity);
    }

    public boolean deleteById(Long id){
        if (!studentRepository.existsById(id)){
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }

    private Student transformEntity(StudentEntity studentEntity){
        return new Student(
                studentEntity.getId(),
                studentEntity.getVorname(),
                studentEntity.getName(),
                studentEntity.getEmail(),
                studentEntity.getPassword(),
                studentEntity.getMatrikelNr(),
                studentEntity.getNotenDurchschnitt(),
                studentEntity.getLpGesamt()
        );
    }
}
