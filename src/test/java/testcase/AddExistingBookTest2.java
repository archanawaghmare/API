package testcase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.AddNewBookRequest;
import response.AddBookResponse;


import static io.restassured.RestAssured.given;

public class AddExistingBookTest2 {
    @Test
    public void addExistingBookAndVerify() {
        RestAssured.baseURI = "http://216.10.245.166";

        AddNewBookRequest addnewBookRequest = new AddNewBookRequest();
        addnewBookRequest.setName("Practise1");
        addnewBookRequest.setIsbn("9712");
        addnewBookRequest.setAisle("19");
        addnewBookRequest.setAuthor("Richard");


        Response addExistingResponse = given()
                .header("Content-Type", "application/json")
                .body(addnewBookRequest)
                .when()
                .post("/Library/Addbook.php")
                .then()

                .extract()
                .response();
        System.out.println(addExistingResponse.asString());

        int actualCode= addExistingResponse.getStatusCode();
        Assert.assertEquals(actualCode, 404);
        //AddBookResponse[] addBookResponse = addExistingResponse.as(AddBookResponse[].class);
        //String actualMsg=addBookResponse[0].getMsg();
        //System.out.println(actualMsg);
        //Assert.assertEquals(actualMsg, "[{\"msg\":\"Add Book operation failed, looks like the book already exists\"}]", "Book not Added");
    }
}