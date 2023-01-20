package ua.ithillel.homework31;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.homework31.persistent.dao.StudentDao;
import ua.ithillel.homework31.persistent.entity.Student;

public class HibernateApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("ua.ithillel.homework31");
        StudentDao studentDao = context.getBean(StudentDao.class);
        Student student = new Student();
        student.setId(1);
        student.setName("Denys");
        student.setEmail("phoenix.snpd@gmail.com");

        studentDao.save(student);
    }
}
