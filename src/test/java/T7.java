import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class T7 {

    /*
    https://jsonplaceholder.typicode.com/posts url
    {
        "title":"Software",
        "body":"API is very nice to learn",
        "userId":12
        }
         donen Response'un,
        status code'unun 201,
        ve content type'inin application/json; charset=utf-8,
        ve Response Body'sindeki,
         "title"'in "Software" oldugunu
        "body" nin "learn" icerdigini
        "id" nin "101"oldugunu test edin.
     */

    @Test
    public void exercise(){
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody=new JSONObject();
        reqBody.put("title","Software");
        reqBody.put("body","API is very nice to learn");
        reqBody.put("userId",12);

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8")
                .body("title", equalTo("Software"))
                .body("body",containsString("learn"))
                .body("id", equalTo(101));
    }
}
