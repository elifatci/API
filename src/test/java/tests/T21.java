package tests;

import baseURL.JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class T21 extends JsonPlaceHolder {
    /*
     https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
     PUT request gonderdigimizde
     {
     "title": "Ahmet",
     "body": "Merhaba",
     "userId": 10,
     "id": 70
     }
     donen Response’un,
     status code’unun 200,
     ve content type’inin application/json; charset=utf-8,
     ve Server isimli Header’in degerinin cloudflare,
     ve status Line’in HTTP/1.1 200 OK
     */

    @Test
    public void test01(){
        specPlace.pathParams("pp1","posts","pp2","70");
        Response response=given().contentType(ContentType.JSON).spec(specPlace).when().put("{pp1}/{pp2}");

        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").header("Server","cloudflare").statusLine("HTTP/1.1 200 OK");

    }
}
