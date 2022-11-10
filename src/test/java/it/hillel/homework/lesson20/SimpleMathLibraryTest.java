package it.hillel.homework.lesson20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {
    @Test
    void shouldRetrieveCorrectResult_x_plus_y() {
        double x = 2.0;
        double y = 3.0;
        double result = x + y;
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double simpleMathLibraryResult = simpleMathLibrary.add(x, y);
        Assertions.assertEquals(result, simpleMathLibraryResult);
    }

    @Test
    void shouldRetrieveCorrectResult_x_minus_y() {

        double x = 5.0;
        double y = 3.0;
        double result = x - y;
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double simpleMathLibraryResult = simpleMathLibrary.minus(x, y);
        Assertions.assertEquals(result, simpleMathLibraryResult);
    }
}

