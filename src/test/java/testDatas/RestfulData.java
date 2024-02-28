package testDatas;

import org.json.JSONObject;

public class RestfulData {

    public static int succesStatusCode=200;
    public static String successContentType="application/json; charset=utf-8";


    public static JSONObject requestBody(){

        /*
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
         */

        JSONObject innerBody=new JSONObject();
        innerBody.put("checkin" , "2021-06-01");
        innerBody.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "John");
        reqBody.put("lastname" , "Swee");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds" , "wi-fi");

        return reqBody;
    }

    public static JSONObject expectedBody(){
        /*
         "firstname“,"Ahmet",
          "lastname“, "Swee",
          "totalprice“,500,
          "depositpaid“,false,
          "checkin" 2021-06-01 and "checkout" 2021-06-10
          "additionalneeds“,"wi-fi"
         */

        JSONObject expBody=new JSONObject();
        expBody.put("firstname","John");
        expBody.put("lastname", "Swee");
        expBody.put("totalprice",500);
        expBody.put("depositpaid",false);
        expBody.put("checkin" , "2021-06-01");
        expBody.put("checkout" , "2021-06-10");
        expBody.put("additionalneeds","wi-fi");

        return expBody;
    }
}
