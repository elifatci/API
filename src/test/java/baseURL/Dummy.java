package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Dummy {

   protected RequestSpecification specDummy;

   @Before
    public void setUP(){
       specDummy=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();
   }
}
