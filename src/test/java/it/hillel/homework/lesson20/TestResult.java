package it.hillel.homework.lesson20;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class TestResult {
    private int sumOfTests;
    private int successfulTests;
    private int failedTests;
    private int testExecutionTimeInMs;
}
