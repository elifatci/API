package testDatas;

import baseURL.JsonPlaceHolder;
import org.json.JSONObject;

public class JsonTestData {

    public static int succesStatusCode=200;

    public static JSONObject expBodyCreate(int userId,int id,String title,String body){
        /*
          {
       "userId":3,
       "id":22,
       "title":"dolor sint quo a velit explicabo quia nam",
       "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
         */
        JSONObject expData=new JSONObject();
        expData.put("userId",userId);
        expData.put("id",id);
        expData.put("title",title);
        expData.put("body",body);

        return expData;
    }
}
