package base;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import utils.Properties;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static String token;

    @BeforeMethod
    public void getToken() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject obj = (JSONObject) jsonParser.parse(new FileReader("a.json"));
        RestAssured.baseURI = Properties.baseUri;
        //String body = "{\"username\":\"rupeek\",\"password\":\"password\"}";
        JSONObject credential = new JSONObject();
        credential.put("username", Properties.getUserName);
        credential.put("password", Properties.getPassword);

        ResponseBody response = given().
                header("Content-Type", "application/json").
                body(obj.toString()).when().post(Properties.authenticateEndPoint).andReturn().body();
        token = response.jsonPath().get("token");




    }

}
