package tests;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;


public class T17 {

    @Test
    public void test01() {
            /*
https://jsonplaceholder.typicode.com/posts url'ine asagidaki body ile bir POST request gonderdigimizde
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


    }
    @Test
    public void test02(){
 /*
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json,
        ve response body'sindeki
        "firstname"in, "Susan",
        ve "lastname"in, "Jackson",
        ve "totalprice"in, 147,
        ve "depositpaid"in, true,
     ve "additionalneeds"in, "Breakfast" oldugunu test edin
 */

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200)
                .contentType("application/json")
                .body("firstname",equalTo("Susan")).body("lastname",equalTo("Jackson"))
                .body("totalprice",equalTo(147)).body("depositpaid",equalTo(true))
                .body("additionalneeds",nullValue());


    }
    @Test
    public void test03(){
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
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody=new JSONObject();
        innerBody.put("checkin" , "2021-06-01");
        innerBody.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , innerBody);
        reqBody.put("additionalneeds" , "wi-fi");

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat().statusCode(200)
                .contentType("application/json")
                .body("booking.firstname",equalTo("Ahmet"),"booking.lastname",equalTo("Bulut")
                        ,"booking.totalprice",equalTo(500),"booking.depositpaid",equalTo(false)
                        ,"booking.bookingdates.checkin",equalTo("2021-06-01"),"booking.bookingdates.checkout",equalTo("2021-06-10")
                        ,"booking.additionalneeds",equalTo("wi-fi"));



    }

    @Test
    public void test04(){
            /*
    http://dummy.restapiexample.com/api/v1/employees url'ine
    bir GET request yolladigimizda
        donen Response'in
            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sindeki
            employees sayisinin 24
            ve employee'lerden birinin "Ashton Cox"
            ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
 */
        String url="http://dummy.restapiexample.com/api/v1/employees";

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200).contentType("application/json").body("data.id",hasSize(24)
                ,"data.employee_name",hasItem("Ashton Cox"),"data.employee_age",hasItems(61,21,35));









    }

    @Test
    public void test05(){
            /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
    donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
  Response body :
{
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */
        String url="https://jsonplaceholder.typicode.com/posts/22";

        JSONObject expBody=new JSONObject();
        expBody.put("userId", 3);
        expBody.put("id", 22);
        expBody.put("title", "dolor sint quo a velit explicabo quia nam");
        expBody.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response=given().when().get(url);

        JsonPath resJP=response.jsonPath();

        assertEquals(expBody.get("userId"),resJP.get("userId"));
        assertEquals(expBody.get("id"),resJP.get("id"));
        assertEquals(expBody.get("title"),resJP.get("title"));
        assertEquals(expBody.get("body"),resJP.get("body"));

    }

    @Test
    public void test06(){
        /*
https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un id haric asagidaki gibi oldugunu test edin.

Request body
{
"firstname" : "Hasan",
"lastname" : "Yagmur",
"totalprice" : 500,
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


        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject innerBody=new JSONObject();
        innerBody.put("checkin" , "2021-06-01");
        innerBody.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Hasan");
        reqBody.put("lastname" , "Yagmur");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , innerBody);
        reqBody.put("additionalneeds" , "wi-fi");


        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        JsonPath resJP=response.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));

    }

}

