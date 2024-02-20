package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class T11 {
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

    @Test
    public void exercise(){
        String url="https://jsonplaceholder.typicode.com/posts/22";

        JSONObject expData=new JSONObject();
        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response=given().when().get(url);
        SoftAssert softAssert=new SoftAssert();
        JsonPath resPath=response.jsonPath();
        softAssert.assertEquals(resPath.get("userId"),expData.get("userId"));
        softAssert.assertEquals(resPath.get("id"),expData.get("id"));
        softAssert.assertEquals(resPath.get("title"),expData.get("title"));
        softAssert.assertEquals(resPath.get("body"),expData.get("body"));
    }
}
