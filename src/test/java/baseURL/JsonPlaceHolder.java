package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolder {
    protected RequestSpecification specPlace;

    @Before
    public void setUP(){
        specPlace=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

    }
}
