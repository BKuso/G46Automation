package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

import static io.restassured.RestAssured.config;

public abstract class BaseApiTest {

    protected RequestSpecification reqspec;
    protected ResponseSpecification resSpec;

    @Before
    public void setSpecs(){
        reqspec = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

}
