package rest;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class RestTest {

    @Test
    public void testOrderGetTest() {
        when().
                get("http://51.250.6.164:8080/test-orders/{id}", 10).
                then().
                statusCode(200).
                body("status",equalTo("OPEN"),
                        "id",equalTo(10),
                        "courierId",equalTo(null));

    }
}
