package base;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import utils.Properties;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static String token;

    @BeforeMethod
    public void getToken() {
        RestAssured.baseURI = Properties.baseUri;
        //String body = "{\"username\":\"rupeek\",\"password\":\"password\"}";
        JSONObject credential = new JSONObject();
        credential.put("username", Properties.getUserName);
        credential.put("password", Properties.getPassword);

        ResponseBody response = given().
                header("Content-Type", "application/json").
                body(credential.toString()).when().post(Properties.authenticateEndPoint).andReturn().body();
        token = response.jsonPath().get("token");

    }

}
