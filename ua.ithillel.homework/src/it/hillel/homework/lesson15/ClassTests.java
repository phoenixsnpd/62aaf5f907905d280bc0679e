package it.hillel.homework.lesson15;

public class ClassTests {

    @Test (impotence = 2)
    public void testOne() {
        System.out.println("ClassTestOne: test 1");
    }

    @Test (impotence = 3)
    public void testTwo() {
        System.out.println("ClassTestOne: test 2");
    }

    @Test
    public void testThree() {
        System.out.println("ClassTestOne: test 3");
    }

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Before suit");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("After suit");
    }
}
