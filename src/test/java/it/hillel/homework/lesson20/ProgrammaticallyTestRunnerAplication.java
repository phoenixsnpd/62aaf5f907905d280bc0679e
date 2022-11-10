package it.hillel.homework.lesson20;

import org.junit.platform.launcher.listeners.TestExecutionSummary;
import java.io.*;


public class ProgrammaticallyTestRunnerAplication {
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        testRunner.runAllBySPackage("it.hillel.homework.lesson20");

        TestExecutionSummary summary = testRunner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        PrintStream originalStdOut = System.out;
        System.setOut(ps);

        summary.printTo(new PrintWriter(System.out));

        System.out.flush();
        System.setOut(originalStdOut);

        try (OutputStream fos = new FileOutputStream("new_file.txt")) {
            baos.writeTo(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TestResultParser testResultParser = new TestResultParser();
        System.out.println(testResultParser.parse("new_file.txt"));
    }
}
