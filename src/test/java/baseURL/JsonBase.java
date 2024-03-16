package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonBase {

    protected RequestSpecification specJ;

    @Before
    public void setUp(){
        specJ=new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com/").build();
    }
}
