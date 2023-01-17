package unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    public void firstTest() {
        CatTest cat = new CatTest();
        String voice = "Мяу";
        Assertions.assertEquals("Мяу", voice, "Error");
    }
}