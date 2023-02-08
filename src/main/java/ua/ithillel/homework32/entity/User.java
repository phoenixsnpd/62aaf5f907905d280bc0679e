package ua.ithillel.homework32.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;
    @Column(name = "name", unique = true, nullable = false, length = 50)
    String name;

    @Column(name = "password", nullable = false, length = 50)
    String password;

    @Column(name = "role", nullable = false, length = 15)
    String role;
}
