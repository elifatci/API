package tests;

import baseURL.JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class T15 extends JsonPlaceHolder {
    // https://jsonplaceholder.typicode.com/posts/44 endpointine
    //   bir GET request gonderdigimizde donen response'un
    //   status code'unun 200 oldugunu
    //   ve "title" degerinin "optio dolor molestias sit" oldugunu test edin

    @Test
    public void exercise() {
        specPlace.pathParams("pp1", "posts", "pp2", "44");

        Response response = given().when().spec(specPlace).get("{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title", equalTo("optio dolor molestias sit"));
    }

    @Test
    public void exercise2() {


        // https://jsonplaceholder.typicode.com/posts endpointine
        //    bir GET request gonderdigimizde donen response'un
        //    status code'unun 200 oldugunu ve Response'ta 100 kayit oldugunu test edin


        specPlace.pathParam("pp1", "posts");
        Response response = given().when().spec(specPlace).get("{pp1}");

        response.then().assertThat().statusCode(200).body("id", hasSize(100));

    }

    @Test
    public void exercise3() {
        // https://jsonplaceholder.typicode.com/posts/41 endpointine
        //   bir DELETE request gonderdigimizde donen response'un
        //   status code'unun 200 oldugunu
        //   ve response body'sinin null oldugunu test edin

        specPlace.pathParams("pp1","posts","pp2","41");
        Response response=given().when().spec(specPlace).delete("{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("body",nullValue());

    }
}
