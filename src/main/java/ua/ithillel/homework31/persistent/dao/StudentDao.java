package ua.ithillel.homework31.persistent.dao;

import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework31.persistent.entity.Student;

@Repository
public class StudentDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public void save(Student student) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.flush();
        }

    }
}
