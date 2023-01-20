package ua.ithillel.homework31;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.homework31.persistent.dao.StudentDao;
import ua.ithillel.homework31.persistent.entity.Student;

public class HibernateApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("ua.ithillel.homework31");
        StudentDao studentDao = context.getBean(StudentDao.class);
        Student student1 = new Student("Denys", "phoenix.snpd@gmail.com");
        Student student2 = new Student("Jack", "Jack@gmail.com");
        Student student3 = new Student("Rykard", "Rykard@gmail.com");
        Student student4 = new Student("Updated person", "update@gmail.com");

        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);

        System.out.println(studentDao.getStudentByID(3));
        System.out.println(studentDao.getAllStudents());

        studentDao.update(3, student4);
        System.out.println(studentDao.getStudentByID(3));

        studentDao.delete(3);
    }
}
