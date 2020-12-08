package tests.api.privat24;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tests.api.BaseApiTest;

import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.XML;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class PrivatCurrencyTest extends BaseApiTest {

    private String type;
    private String id;
    private String path;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> result = new ArrayList<>();
        Object[] xml1 = new Object[3];
        xml1[0] = "xml";
        xml1[1] = "11";
        xml1[2] = "exchangerates.row.exchangerate.@ccy";
        Object[] xml5 = new Object[3];
        xml5[0] = "xml";
        xml5[1] = "5";
        xml5[2] = "exchangerates.row.exchangerate.@ccy";
        Object[] json1 = new Object[3];
        json1[0] = "json";
        json1[1] = "11";
        json1[2] = "ccy";
        Object[] json5 = new Object[3];
        json5[0] = "json";
        json5[1] = "5";
        json5[2] = "ccy";
        result.add(xml1);
        result.add(xml5);
        result.add(json1);
        result.add(json5);
        return result;
    }

    public PrivatCurrencyTest(String type, String id, String path){
        this.type = type;
        this.id = id;
        this.path = path;
    }

    @Test
    public void checkJsonCurrencyAPI(){
       given()
                .spec(this.reqspec)
                .queryParam(this.type)
                .queryParam("exchange")
                .queryParam("coursid", this.id)
                .contentType(XML)
                .baseUri("https://api.privatbank.ua/p24api")
                .when()
                .post("/pubinfo")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body(this.path,
                        hasItems(equalTo("USD"),
                        equalTo("EUR"), equalTo("RUR")));
    }

}
