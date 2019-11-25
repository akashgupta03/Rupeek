package ApiTestCases;

import base.TestBase;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;
import utils.Properties;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestApi extends TestBase {
    public List<String> listOfPhoneNumber;
    private String userPhoneNumber;


    @Test
    public void getUsers() {
        ResponseBody userData = given().
                header("Authorization", "Bearer " + token).
                when().get(Properties.userRecordEndPoint).andReturn().then().
                statusCode(200).extract().response().getBody();
        listOfPhoneNumber = userData.jsonPath().getList("phone");
        userPhoneNumber = userData.jsonPath().getList("phone").get(0).toString();


    }


    @Test(dependsOnMethods = "getUsers")
    public void getRecordOfUser() {
        ResponseBody userData = given().header("Authorization", "Bearer " + token).when().get(String.format(Properties.userRecordByPhoneEndPoint, userPhoneNumber)).andReturn().then().
                statusCode(200).extract().response().getBody();
        userData.prettyPrint();

    }


}




