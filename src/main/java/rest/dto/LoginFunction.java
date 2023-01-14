package rest.dto;

import com.google.gson.Gson;
import io.restassured.response.Response;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class LoginFunction {
    private String baseUrl;
    private String username;
    private String password;

    public LoginFunction() {
        try (InputStream input = new FileInputStream("src/main/resources/settings.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            baseUrl = properties.getProperty("baseUrl");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public String createUser() {
        User user = new User(username, password);
        Gson gson = new Gson();
        return gson.toJson(user);
    }

    public String getToken() {

        Response response =
                given().
                        header("Content-type", "application/json").
                        body(createUser()).
                        when().
                        post(baseUrl + "/login/student").
                        then().
                        statusCode(200).extract().response();
        return response.body().asString();
    }
}


