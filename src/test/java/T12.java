import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class T12 {
/*
https://restful-booker.herokuapp.com/booking url
Request body
{
"firstname" : "Hami",
"lastname" : "Bulut",
"totalprice" : 100,
"depositpaid" : false,
"bookingdates" : {
    "checkin" : "2021-06-01",
    "checkout" : "2021-06-10"
    },
"additionalneeds" : "wi-fi"
}

Expected Response Body
{
"bookingid":24,
"booking":{
    "firstname":"Hasan",
    "lastname":"Yagmur",
    "totalprice":500,
    "depositpaid":false,
    "bookingdates":{
        "checkin":"2021-06-01",
        "checkout":"2021-06-10"
        },
"additionalneeds":"wi-fi"
}
}
 */
    @Test
    public void exercise(){
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject innerBody=new JSONObject();
        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Hami");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 100);
        reqBody.put("depositpaid" , false);
        reqBody.put("additionalneeds","wi-fi");
        reqBody.put("bookingdates" , innerBody);


        JSONObject expResBody=new JSONObject();
        expResBody.put("bookingid",24);
        expResBody.put("booking",reqBody);

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        JsonPath resJsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJsonPath.get("booking.firstname"),expResBody.getJSONObject("booking").get("firstname"));
        softAssert.assertEquals(resJsonPath.get("booking.lastname"),expResBody.getJSONObject("booking").get("lastname"));
        softAssert.assertEquals(resJsonPath.get("booking.totalprice"),expResBody.getJSONObject("booking").get("totalprice"));
        softAssert.assertEquals(resJsonPath.get("booking.depositpaid"),expResBody.getJSONObject("booking").get("depositpaid"));
        softAssert.assertEquals(resJsonPath.get("booking.additionalneeds"),expResBody.getJSONObject("booking").get("additionalneeds"));
        softAssert.assertEquals(resJsonPath.get("booking.bookingdates.checkin"),expResBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        softAssert.assertEquals(resJsonPath.get("booking.bookingdates.checkout"),expResBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"));

    }
}
