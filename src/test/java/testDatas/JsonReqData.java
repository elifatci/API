package testDatas;

import org.json.JSONObject;

public class JsonReqData {

    public static JSONObject reqData(){

        JSONObject req =new JSONObject();
        req.put("title", "Metin");
        req.put("body", "Hi");
        req.put("userId", 10);
        req.put("id", 65);

        return req;
    }
}
