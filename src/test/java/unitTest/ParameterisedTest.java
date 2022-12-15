package unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterisedTest {


    @ParameterizedTest
    @CsvFileSource (resources = "/some.csv", useHeadersInDisplayName = true)
    void testWithCsvFileAndHeaders(String LOGIN, String PASSWORD, String ROLE){
        Assertions.assertNotEquals(LOGIN,PASSWORD,ROLE);
        String a = LOGIN+ " " + PASSWORD+ " " + ROLE;
        System.out.println(a);

    }
}
