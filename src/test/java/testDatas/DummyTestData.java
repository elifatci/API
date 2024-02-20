package testDatas;
import org.json.JSONObject;

public class DummyTestData {

    public static JSONObject reqBodyCreate(){
        /*
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
         */
        JSONObject innerData=new JSONObject();
        innerData.put("name", "Ahmet");
        innerData.put("salary", "1230");
        innerData.put("age", "44");
        innerData.put("id", 40);

        JSONObject reqData=new JSONObject();
        reqData.put("status", "success");
        reqData.put("data",innerData);

        return reqData;
    }

    public static JSONObject expBodyCreate(){
        /*
               Response Body
               {
                   "status": "success",
                   "data": {
                       "name": "Ahmet",
                       "salary": "1230",
                       "age": "44",
                       "id": 40
                   }
                   "message": "Successfully! Record has been updated."
               }
         */

        JSONObject expData=new JSONObject();
        expData.put("status","success");
        expData.put("data",reqBodyCreate());
        expData.put("message","Successfully! Record has been updated.");

        return expData;
    }
}
