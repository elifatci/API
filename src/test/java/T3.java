import org.json.JSONObject;
import org.testng.annotations.Test;

public class T3 {

    /*
    {
    "firstname":"Jim",
    "additionalneeds":"Breakfast",
    "bookingdates": {
    "checkin":"2018-01-01",
    "checkout":"2019-01-01"
    },
    "totalprice":111,
    "depositpaid":true,
    "lastname":"Brown"
    }
     */

    @Test
    public void JsonCreate(){
        JSONObject innerJson=new JSONObject();
     innerJson.put("checkin","2018-01-01");
     innerJson.put("checkout","2019-01-01");

     JSONObject outerJson=new JSONObject();
     outerJson.put("firstname","Jim");
     outerJson.put("additionalneeds","Breakfast");
     outerJson.put("bookingdates",innerJson);
     outerJson.put("totalprice",111);
     outerJson.put("depositpaid",true);
     outerJson.put("lastname","Brown");

        System.out.println(outerJson);
    }

}
