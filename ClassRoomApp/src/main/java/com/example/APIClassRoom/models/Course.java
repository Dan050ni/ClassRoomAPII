package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer idCourse;

    @Column(length = 100, nullable = false)
    private String Name;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id_class")
    @JsonBackReference
    private SchoolClass classroom;

    @ManyToOne
    @JoinColumn(name = "fk_teacher", referencedColumnName = "id_teacher")
    @JsonBackReference
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Registration> registrations;

    public Course() {}

    public Course(Integer idCourse, String name) {
        this.idCourse = idCourse;
        Name = name;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
