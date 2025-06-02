package com.idat.student.infraestructure.adapters.student;

import com.idat.student.domain.model.Student;
import com.idat.student.domain.model.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentAdapter implements StudentRepository {

    private final StudentDataRepository studentDataRepository;

    public StudentAdapter(StudentDataRepository studentDataRepository) {
        this.studentDataRepository = studentDataRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentDataRepository.findAll()
                .stream()
                .filter(studentData -> studentData.getActive() != 0)
                .map(StudentMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public Student findById(String uid) {
        Student student = null;

        Optional<StudentData> studentData = studentDataRepository.findById(uid);
        if (studentData.isPresent()) {
            StudentData sd = studentData.get();
            if (sd.getActive() == 1) {
                return StudentMapper.MAPPER.toDomain(studentData.get());
            }
        }

        return student;
    }

    @Override
    public Student save(Student student) {
        StudentData studentData = studentDataRepository.save(StudentMapper.MAPPER.toEntity(student));
        return StudentMapper.MAPPER.toDomain(studentData);
    }

    @Override
    public Student update(Student student) {
        Optional<StudentData> studentData = studentDataRepository.findById(student.uid());
        if (studentData.isPresent()) {
            StudentData studentData2 = StudentMapper.MAPPER.toEntity(student);
            return StudentMapper.MAPPER.toDomain(studentDataRepository.save(studentData2));
        }

        return null;
    }

    @Override
    public void delete(String uid) {
        Optional<StudentData> student = studentDataRepository.findById(uid);
        if (student.isPresent()) {
            StudentData studentData = student.get();
            studentData.setActive(0);
            studentDataRepository.save(studentData);
        }
    }

}
