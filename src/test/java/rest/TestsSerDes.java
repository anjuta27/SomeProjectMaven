package rest;


import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.dto.Order;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class TestsSerDes {
    @Test
    public void postFirstOrder(){
        Order requestOrder = new Order();
        requestOrder.setStatus("OPEN");
        requestOrder.setCustomerName("ANNA");
        requestOrder.setCourierId(3l);
        requestOrder.setCustomerPhone("58144144");
        requestOrder.setComment("Thanks");

        Gson gson = new Gson();
        String stringRequestOrder = gson.toJson(requestOrder);
        //Сделайте POST запрос с dto объектом
        Response response =
                given()
                        .contentType("application/json")
                        .body(stringRequestOrder)
                        .when()
                        .post("http://51.250.6.164:8080/test-orders/")
                        .then()
                        .statusCode(200)
                        .extract().response();

        //Десериализуйте объект ответа
        Order responseOrder = gson.fromJson(response.body().asString(),Order.class);

        //Проверьте поля ответа
        Assertions.assertEquals(requestOrder.getStatus(),"OPEN", "Error!");
        Assertions.assertEquals(requestOrder.getCustomerName(),"ANNA","Error!");
    }
    }

