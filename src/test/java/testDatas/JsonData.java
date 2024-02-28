package testDatas;

import org.json.JSONObject;

public class JsonData {



    public static JSONObject reqBodyCreate(){
        /*
        {
     "title": "Ahmet",
     "body": "Merhaba",
     "userId": 10,
     "id": 70
     }
         */
        JSONObject reqBody=new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        return  reqBody;
    }

}
