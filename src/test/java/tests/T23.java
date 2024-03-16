package tests;

import baseURL.JsonBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonReqData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class T23 extends JsonBase {
    /*

     Response ==> status code- 200, content type-application/json; charset=utf-8, Server Header-cloudflare, status Line- HTTP/1.1 200 OK
     */


    @Test
    public void test01(){
        specJ.pathParams("pp1","posts","pp2",65);

        JSONObject reqData= JsonReqData.reqData();

        Response response=given().when().spec(specJ).body(reqData.toString()).put("{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();

        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8").header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }
}
