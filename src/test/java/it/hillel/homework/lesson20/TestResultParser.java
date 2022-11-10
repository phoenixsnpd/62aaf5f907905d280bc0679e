package it.hillel.homework.lesson20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TestResultParser {
    private int sumOfTests;
    private int successfulTests;
    private int failedTests;
    private int testExecutionTimeInMs;

    public TestResult parse(String fileName) {
        List<String> testsData = new ArrayList<>();
        String checkString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((checkString = bufferedReader.readLine()) != null) {
                testsData.add(checkString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        applyThatFileContainstTestIformation(testsData);
        fillInTestResultInformation(testsData);
        return new TestResult(sumOfTests, successfulTests, failedTests, testExecutionTimeInMs);
    }

    public TestResult parse(File fileName) {
        List<String> testsData = new ArrayList<>();
        String checkString;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((checkString = bufferedReader.readLine()) != null) {
                testsData.add(checkString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        applyThatFileContainstTestIformation(testsData);
        fillInTestResultInformation(testsData);
        return new TestResult(sumOfTests, successfulTests, failedTests, testExecutionTimeInMs);
    }

    public TestResult parse(Path fileName) {
        List<String> testsData = new ArrayList<>();
        String checkString;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(fileName)))) {
            while ((checkString = bufferedReader.readLine()) != null) {
                testsData.add(checkString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        applyThatFileContainstTestIformation(testsData);
        fillInTestResultInformation(testsData);
        return new TestResult(sumOfTests, successfulTests, failedTests, testExecutionTimeInMs);
    }

    private void applyThatFileContainstTestIformation(List<String> fileData) {
        String[] checkString;
        int countContainers = 0;
        int countTests = 0;

        for (String string : fileData) {
            checkString = string.split(" ");
            for (String str : checkString) {
                if (str.equals("containers")) {
                    countContainers++;
                }
                if (str.equals("tests")) {
                    countTests++;
                }
            }
        }
        if (!fileData.get(1).startsWith("Test run finished after") || countContainers < 6 || countTests < 6) {
            throw new RuntimeException("This file doesn't consist information about tests");
        }
    }

    private void fillInTestResultInformation(List<String> fileData) {
        String[] checkString;



        for (int i = 1; i < fileData.size(); i++) {
            checkString = fileData.get(i).split(" ");
            for (int j = 0; j < checkString.length; j++) {
                if (i == 1 && j == 4) {
                    testExecutionTimeInMs = Integer.parseInt(checkString[j]);
                }
                if (checkString[j].equals("tests")) {
                    if (checkString[j + 1].equals("found")) {
                        sumOfTests = Integer.parseInt(checkString[j - 1]);
                    }
                    if (checkString[j + 1].equals("successful")) {
                        successfulTests = Integer.parseInt(checkString[j - 1]);
                    }
                    if (checkString[j + 1].equals("failed")) {
                        failedTests = Integer.parseInt(checkString[j - 1]);
                    }
                }
            }
        }
    }
}
