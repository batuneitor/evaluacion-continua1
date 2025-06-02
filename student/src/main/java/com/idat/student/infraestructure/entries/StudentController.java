package com.idat.student.infraestructure.entries;

import com.idat.student.domain.model.Student;
import com.idat.student.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instituto/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{uid}")
    public Student getStudentById(@PathVariable("uid") String uid) {
        return studentService.findById(uid);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(studentService.save(student));
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Student> updateStudent(@PathVariable("uid") String uid, @RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(studentService.update(uid, student));
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("uid") String uid) {
        studentService.delete(uid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
