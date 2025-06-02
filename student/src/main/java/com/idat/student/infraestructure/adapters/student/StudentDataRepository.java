package com.idat.student.infraestructure.adapters.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDataRepository extends JpaRepository<StudentData, String> {
}
