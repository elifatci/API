package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class T9 {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
     bir POST request gonderdigimizde
     {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" :{
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                        },
        "additionalneeds" : "wi-fi"
     }
     donen Response’un,
     status code’unun 200,
     ve content type’inin application/json,
     ve response body’sindeki
     "firstname“in,"Ahmet",
     ve "lastname“in, "Bulut",
     ve "totalprice“in,500,
     ve "depositpaid“in,false,
     ve "checkin" tarihinin 2021-06-01 ve "checkout" tarihinin 2021-06-10
     ve "additionalneeds“in,"wi-fi"
     oldugunu test edin

     */

    @Test
    public void exercise(){
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject reqBody=new JSONObject();
        JSONObject innerBody=new JSONObject();

        innerBody.put("checkin" , "2021-06-01");
        innerBody.put("checkout" , "2021-06-10");

        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds" , "wi-fi");

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat().statusCode(200)
                .contentType("application/json")
                .body("booking.firstname", equalTo("Ahmet")
                        ,"booking.lastname",equalTo("Bulut")
                        ,"booking.totalprice",equalTo(500)
                        ,"booking.depositpaid",equalTo(false)
                        ,"booking.bookingdates.checkin",equalTo("2021-06-01")
                        ,"booking.bookingdates.checkout",equalTo("2021-06-10")
                        ,"booking.additionalneeds",equalTo("wi-fi"));
    }


}
