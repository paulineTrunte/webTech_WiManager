package de.htwberlin.webtech.wiManager.web;
import de.htwberlin.webtech.wiManager.service.StudentService;
import de.htwberlin.webtech.wiManager.web.api.Student;


import de.htwberlin.webtech.wiManager.web.api.StudentCreateOrUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/api/v1/students")
    public ResponseEntity<List<Student>> fetchStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping(path = "/api/v1/students/{id}")
    public ResponseEntity<Student> fetchStudentbyId(@PathVariable Long id){
        var student = studentService.findById(id);
        return student != null? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/students")
    public ResponseEntity<Void> createStudent(@RequestBody StudentCreateOrUpdateRequest request) throws URISyntaxException {
        var student = studentService.create(request);
        URI uri = new URI("/api/v1/students/"+ student.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/students/{id}")
        public ResponseEntity<Student > updateStudent(@PathVariable Long id, @RequestBody StudentCreateOrUpdateRequest request){
            var student = studentService.update(id, request);
        return student != null? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/students/{id}")
    public ResponseEntity<Void > deleteStudent(@PathVariable Long id){
        boolean successful = studentService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    }

