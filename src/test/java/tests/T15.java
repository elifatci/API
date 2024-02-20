package tests;

import baseURL.JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class T15 extends JsonPlaceHolder{
    // https://jsonplaceholder.typicode.com/posts/44 endpointine
//   bir GET request gonderdigimizde donen response'un
//   status code'unun 200 oldugunu
//   ve "title" degerinin "optio dolor molestias sit" oldugunu test edin

    @Test
    public void exercise(){
        specPlace.pathParams("pp1","posts","pp2","44");

        Response response=given().when().spec(specPlace).get("{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title", equalTo("optio dolor molestias sit"));
    }
}
