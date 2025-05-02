package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Qualifications")
public class Qualification {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_qualification")
    private Integer idQualification; // Cambiado a Integer

    @Column (nullable = false, name = "note") // Buena práctica especificar el nombre de la columna
    private Float note;

    @Column (name = "evaluation_date", nullable = false)
    private String evaluationDate;


    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    @JsonBackReference
    private Course course;



    public Qualification(){}

    // Constructor actualizado para usar Integer
    public Qualification(Integer idQualification, Float note, String evaluationDate) {
        this.idQualification = idQualification;
        this.note = note;
        this.evaluationDate = evaluationDate;
    }

    public Integer getIdQualification() { // Cambiado a Integer
        return idQualification;
    }

    public void setIdQualification(Integer idQualification) { // Cambiado a Integer
        this.idQualification = idQualification;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public String getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(String evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}