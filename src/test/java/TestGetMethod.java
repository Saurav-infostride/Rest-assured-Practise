import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestGetMethod {

    @Test
    void testGet(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    // To test different values
    // .log().all(l method will show all the info
    @Test
    void getTest2(){
        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7))
                .body("data.first_name", hasItems("Michael", "Lindsay"));
    }
}
