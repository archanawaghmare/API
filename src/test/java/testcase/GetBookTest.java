package testcase;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetBookTest {

    @Test
    public void verifyGetBookTest() throws IOException {

        RestAssured.baseURI="http://216.10.245.166";
        Response response = given().queryParam("ID", "Anamika23")
                .header("Content-Type", "application/json")
                .when()
                .get("/Library/GetBook.php")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.asString(),"[{\"book_name\":\"Learning API Automation\",\"isbn\":\"Anamika\",\"aisle\":\"23\",\"author\":\"Kushal\"}]");


    }
}