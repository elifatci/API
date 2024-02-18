import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class T2 {
        /*
       https://restful-booker.herokuapp.com/booking/23 url’ine bir GET request
       gonderdigimizde donen Response’un,
       status code’unun 200,
       ve content type’inin application/json; charset=utf-8,
       ve Server isimli Header’in degerinin Cowboy,
       ve status Line’in HTTP/1.1 200 OK
       oldugunu test ediniz
     */


    @Test
    public void get(){
        String url="https://restful-booker.herokuapp.com/booking/23";
        Response response=given().when().get(url);
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");
    }
}
