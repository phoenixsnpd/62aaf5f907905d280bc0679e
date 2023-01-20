package ua.ithillel.homework31.persistent.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.homework31.persistent.entity.Student;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Student> getAllStudents() {
        List<Student> students;
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
            session.flush();
        }
        return students;
    }

    @Transactional
    public Student getStudentByID(long id) {
        Student student;
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            student = session.get(Student.class, id);
            session.flush();
        }
        return student;
    }

    @Transactional
    public void save(Student student) {
        try (var session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.persist(student);
            session.flush();
            session.getTransaction().commit();
        }
    }

    @Transactional
    public void update(long id, Student updatedStudent) {
        Student studentToBeUpdated;
        try (var session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            studentToBeUpdated = session.get(Student.class, id);
            studentToBeUpdated.setName(updatedStudent.getName());
            studentToBeUpdated.setEmail(updatedStudent.getEmail());
            session.flush();
            session.getTransaction().commit();
        }
    }

    @Transactional
            public void delete(long id) {
        try(var session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.remove(session.get(Student.class, id));
            session.flush();
            session.getTransaction().commit();
        }
    }
}
