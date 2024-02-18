import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class T6 {
        /*
        https://jsonplaceholder.typicode.com/posts url'ine
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response'un,
        status code'unun 201,
        ve content type'inin application/json; charset=utf-8,
        ve Response Body'sindeki,
         "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini test edin.
 */

    @Test
    public void exercise(){
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject reqbody=new JSONObject();
        reqbody.put("title","API");
        reqbody.put("body","API ogrenmek ne guzel");
        reqbody.put("userId",10);

        Response response=given().contentType(ContentType.JSON).when().body(reqbody.toString()).post(url);

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8")
                .body("title",equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));
    }
}
