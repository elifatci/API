package tests;

import baseURL.Restful;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatas.RestfulData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class T22 extends Restful {
        /*
    https://restful-booker.herokuapp.com/booking POST request
     {
        "firstname" : "John",
        "lastname" : “Swee",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" :{
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                        },
        "additionalneeds" : "wi-fi"
     }
     Response,
     status code==> 200,
     content type==> application/json,
     body==>
     "firstname“,"Ahmet",
     "lastname“, "Bulut",
     "totalprice“,500,
     "depositpaid“,false,
     "checkin" 2021-06-01 and "checkout" 2021-06-10
     "additionalneeds“in,"wi-fi"

     */
    @Test
    public void test01(){

        specRestful.pathParam("pp1","booking");
        JSONObject reqData= RestfulData.requestBody();
        JSONObject expBody=RestfulData.expectedBody();

        Response response=given().contentType(ContentType.JSON).spec(specRestful).when().body(reqData.toString()).post("{pp1}");
        JsonPath resJP=response.jsonPath();

        assertEquals(RestfulData.succesStatusCode,response.statusCode());
        assertEquals(RestfulData.successContentType,response.contentType());
        assertEquals(expBody.get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expBody.get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expBody.get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expBody.get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.get("checkout"),resJP.get("booking.bookingdates.checkout"));
        assertEquals(expBody.get("additionalneeds"),resJP.get("booking.additionalneeds"));

    }
}
