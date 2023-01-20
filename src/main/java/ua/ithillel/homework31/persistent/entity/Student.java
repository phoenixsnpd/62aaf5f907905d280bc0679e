package ua.ithillel.homework31.persistent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
