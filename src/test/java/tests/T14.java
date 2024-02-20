package tests;

import baseURL.Dummy;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class T14 extends Dummy {
     /*
       http://dummy.restapiexample.com/api/v1/update/21 url'ine
       asagidaki body'ye sahip bir PUT request gonderdigimizde
       donen response'un asagidaki gibi oldugunu test edin.
       Request Body
               {
               "status": "success",
               "data": {
                   "name": "Ahmet",
                   "salary": "1230",
                   "age": "44",
                   "id": 40
                       }
              }
       Response Body
               {
                   "status": "success",
                   "data": {
                       "name": "Ahmet",
                       "salary": "1230",
                       "age": "44",
                       "id": 40
                   }
               },
               "message": "Successfully! Record has been updated."
           }

*/

    @Test
    public void exercise(){
        specDummy.pathParams("pp1","update","pp2","21");
        JSONObject reqBody= DummyTestData.reqBodyCreate();
        JSONObject expBody=DummyTestData.expBodyCreate();

        Response response=given().contentType(ContentType.JSON).when().spec(specDummy).body(reqBody.toString()).put("{pp1}/{pp2}");
        JsonPath resJP=response.jsonPath();
        assertEquals(expBody.get("status"),resJP.get("status"));
        assertEquals(expBody.getJSONObject("data").get("status"),resJP.get("data.status"));
        assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("name"),resJP.get("data.data.name"));
        assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("salary"),resJP.get("data.data.salary"));
        assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("age"),resJP.get("data.data.age"));
        assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("id"),resJP.get("data.data.id"));
        assertEquals(expBody.get("message"),resJP.get("message"));
    }
}
