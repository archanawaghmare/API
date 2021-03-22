package testcase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.AddNewBookRequest;
import response.AddBookResponse;
import response.BookResponse;

import static io.restassured.RestAssured.given;

public class AddBookAndValidateTest1 {
    @Test
    public void  addNewBookAndVerify()
    {
        RestAssured.baseURI = "http://216.10.245.166";

        AddNewBookRequest addnewBookRequest = new AddNewBookRequest();
        addnewBookRequest.setName("Practise1");
        addnewBookRequest.setIsbn("97");
        addnewBookRequest.setAisle("19");
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
        //System.out.println(addResponse.asString());
        AddBookResponse[] addBookResponse = addResponse.as(AddBookResponse[].class);
        Assert.assertEquals(addBookResponse[0].getID(), "9719", "Book not Added");
      //String id= addBookResponse[0].getId();


    }
    @Test
    public void verifyGetBookAdd(){

        RestAssured.baseURI="http://216.10.245.166";
        Response response = given().queryParam("ID", "9719")
                .header("Content-Type", "application/json")
                .when()
                .get("/Library/GetBook.php")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asString());
        //BookResponse[] BookResponse = response.as(BookResponse[].class);
        Assert.assertEquals(response.asString(), "[{\"book_name\":\"Practise1\",\"isbn\":\"97\",\"aisle\":\"19\",\"author\":\"Richard\"}]");


    }

    @Test
    public void deleteBook()
    {

    }
}
