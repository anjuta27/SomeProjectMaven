package UnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

public class Cat {
    @Test
    public void firstTest() {
        Cat cat = new Cat();
        String voice = "Мяу";
        Assertions.assertEquals("Мяу", voice, "Error");
    }
}