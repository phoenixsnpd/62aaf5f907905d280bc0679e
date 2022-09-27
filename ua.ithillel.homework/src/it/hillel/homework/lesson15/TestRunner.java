package it.hillel.homework.lesson15;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class TestRunner {
    public static void start(Class<ClassTests> testClass) {
        checkingAfterAndBeforeSuit(testClass);
        callMethods(testClass);
    }

    private static void checkingAfterAndBeforeSuit(Class<ClassTests> testClass) {
        int beforeSuitecount = 0;
        int afterSuitecount = 0;

        Method[] methodsCount = testClass.getDeclaredMethods();
        for (Method method : methodsCount) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuitecount++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuitecount++;
            }
        }
        if (beforeSuitecount > 1 || afterSuitecount > 1) {
            throw new RuntimeException();
        }
    }

    private static void callMethods(Class<ClassTests> testClass) {
        Object testObject = null;
        try {
            testObject = testClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Method[] methods = testClass.getDeclaredMethods();
        List<Method> testMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Test.class).impotence()))
                .collect(Collectors.toList());

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                testMethods.add(0, method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                testMethods.add(method);
            }
        }
        try {
            for (Method method : testMethods) {
                method.invoke(testObject);
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
