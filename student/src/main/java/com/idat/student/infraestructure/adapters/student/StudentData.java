package com.idat.student.infraestructure.adapters.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class StudentData {
    public StudentData() {
    }

    public StudentData(String uid, String documentNumber, String name, String lastName, String phone, String email, String photo, int active) {
        this.uid = uid;
        this.documentNumber = documentNumber;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
        this.active = active;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Id
    @Column(length = 40)
    private String uid;

    @Column(name = "nro_documento", length = 30)
    private String documentNumber;

    @Column(name = "nombres", length = 60)
    private String name;

    @Column(name = "apellidos", length = 60)
    private String lastName;

    @Column(name = "telefono", length = 30)
    private String phone;

    @Column(name = "correo", length = 60)
    private String email;

    @Column(name = "foto", length = 100)
    private String photo;

    @Column(name = "activo")
    private int active;
}
