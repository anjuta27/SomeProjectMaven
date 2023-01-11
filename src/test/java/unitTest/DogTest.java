package unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DogTest {
    @Test
    public void secondTest() {
        DogTest dog = new DogTest();
        String voice = "Гав";
        Assertions.assertEquals("Гав", voice, "Error!");

    }
}