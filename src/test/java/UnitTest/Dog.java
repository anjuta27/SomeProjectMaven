package UnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Dog {
    @Test
    public void secondTest(){
        Dog dog = new Dog();
        String voice = "Гав";
        Assertions.assertEquals("Гав",voice,"Error!");

    }
}
