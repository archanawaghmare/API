package testcase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.AddNewBookRequest;
import response.AddBookResponse;

import static io.restassured.RestAssured.given;

public class AddBookNewTest {

    @Test
    public void verifyAddNewBook() {
        RestAssured.baseURI = "http://216.10.245.166";

        AddNewBookRequest addnewBookRequest = new AddNewBookRequest();
        addnewBookRequest.setName("Practise Rest Assured");
        addnewBookRequest.setIsbn("0908");
        addnewBookRequest.setAisle("09");
        addnewBookRequest.setAuthor("Richard");
        System.out.println(addnewBookRequest.getName());

        Response addResponse = given()
                .header("Content-Type", "application/json")
                .body(addnewBookRequest)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(addResponse.asString());
        AddBookResponse[] addBookResponse = addResponse.as(AddBookResponse[].class);
        System.out.println(addBookResponse[0].getMsg());


    }

}
