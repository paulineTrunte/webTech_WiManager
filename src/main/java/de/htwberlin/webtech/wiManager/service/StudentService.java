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

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
        var studentEntity = new StudentEntity(request.getVorname(), request.getName());
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
                studentEntity.getName()
        );
    }
}
