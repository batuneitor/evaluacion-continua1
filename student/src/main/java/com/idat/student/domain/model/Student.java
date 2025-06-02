package com.idat.student.domain.model;

public record Student(
        String uid,
        String documentNumber,
        String name,
        String lastName,
        String phone,
        String email,
        String photo,
        int active
) {
}
