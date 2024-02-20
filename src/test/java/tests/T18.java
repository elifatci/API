package tests;

import baseURL.JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class T18 extends JsonPlaceHolder {
       /*
   https://jsonplaceholder.typicode.com/posts/22 url'ine
   bir GET request yolladigimizda
   donen response'in
       status kodunun 200
       ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

   Response body :
   {
       "userId":3,
       "id":22,
       "title":"dolor sint quo a velit explicabo quia nam",
       "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
*/

    @Test
    public void exercise(){
        specPlace.pathParams("pp1","posts","pp2","22");
        JSONObject expBody= JsonTestData.expBodyCreate(3,22,"dolor sint quo a velit explicabo quia nam","eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita earum mollitia molestiae aut atque rem suscipit\\nnam impedit esse");

        Response response=given().when().spec(specPlace).get("{pp1}/{pp2}");
        JsonPath resJP=response.jsonPath();

       assertEquals(JsonTestData.succesStatusCode,response.getStatusCode());
       assertEquals(expBody.getInt("userId"),resJP.getInt("userId"));
       assertEquals(expBody.getInt("id"),resJP.getInt("id"));
       assertEquals(expBody.getString("title"),resJP.getString("title"));
       assertEquals(expBody.getString("body"),resJP.getString("body"));
    }
}
