package tests;
import baseURL.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class T20 extends Dummy {
    /*
http://dummy.restapiexample.com/api/v1/employee/3 url'ine
bir GET request gonderdigimizde
donen response'un status code'unun 200,
content Type'inin application/json
ve body'sinin asagidaki gibi oldugunu test edin.

Expected Response Body
{
 "status":"success",
 "data":{
         "id":3,
         "employee_name":"Ashton Cox",
         "employee_salary":86000,
         "employee_age":66,
         "profile_image":""
         },
 "message":"Successfully! Record has been fetched."
}
*/
    @Test
    public void test01(){

        specDummy.pathParams("pp1","employee","pp2","3");

        JSONObject expData= DummyTestData.expectedBodyCreate();

        Response response=given().when().spec(specDummy).get("{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();

        assertEquals(expData.get("status"),resJP.get("status"));
        assertEquals(expData.getJSONObject("data").get("id"),resJP.get("data.id"));
        assertEquals(expData.getJSONObject("data").get("employee_name"),resJP.get("data.employee_name"));
        assertEquals(expData.getJSONObject("data").get("employee_salary"),resJP.get("data.employee_salary"));
        assertEquals(expData.getJSONObject("data").get("employee_age"),resJP.get("data.employee_age"));
        assertEquals(expData.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));
        assertEquals(expData.get("message"),resJP.get("message"));


    }
}
