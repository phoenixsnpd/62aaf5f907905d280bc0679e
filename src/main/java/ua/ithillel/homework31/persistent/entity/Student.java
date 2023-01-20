package ua.ithillel.homework31.persistent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "email", nullable = false, length = 40)
    private String email;
}
