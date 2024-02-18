import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class T8 {
     /*
        https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
        Reponse
        status code'unun 200,
        ve content type'inin application/json,
        ve response body'sindeki
        "firstname"in, "Susan",
        ve "lastname"in, "Jackson",
        ve "totalprice"in, 612,
        ve "depositpaid"in, false,
        ve "additionalneeds"in, "Breakfast"
 */

    @Test
    public void exercise(){
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Sally"))
                .body("lastname",equalTo("Jackson"))
                .body("totalprice",equalTo(725))
                .body("depositpaid",equalTo(true))
                .body("additionalneeds",equalTo("Breakfast"));
    }
}
