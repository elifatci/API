package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class T13 {
           /*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde
   donen response'un asagidaki gibi oldugunu test edin.
       Response Body
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
    public void exercise(){
        String url="http://dummy.restapiexample.com/api/v1/employee/3";
        JSONObject innerRespBody=new JSONObject();
        innerRespBody.put("id",3);
        innerRespBody.put("employee_name","Ashton Cox");
        innerRespBody.put("employee_salary",86000);
        innerRespBody.put("employee_age",66);
        innerRespBody.put("profile_image","");

        JSONObject expRespBody=new JSONObject();
        expRespBody.put("status","success");
        expRespBody.put("data",innerRespBody);
        expRespBody.put("message","Successfully! Record has been fetched.");

        Response response=given().when().get(url);
        JsonPath respJsonPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(respJsonPath.get("status"),expRespBody.get("status"));
        softAssert.assertEquals(respJsonPath.get("message"),expRespBody.get("message"));
        softAssert.assertEquals(respJsonPath.get("data.id"),expRespBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJsonPath.get("data.employee_name"),expRespBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJsonPath.get("data.employee_salary"),expRespBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJsonPath.get("data.employee_age"),expRespBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJsonPath.get("data.profile_image"),expRespBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(respJsonPath.get("data.id"),expRespBody.getJSONObject("data").get("id"));
    }
}
