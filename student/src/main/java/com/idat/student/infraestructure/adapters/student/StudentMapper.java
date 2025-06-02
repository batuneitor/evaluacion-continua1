package com.idat.student.infraestructure.adapters.student;

import com.idat.student.domain.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    Student toDomain(StudentData entity);

    StudentData toEntity(Student domain);
}
