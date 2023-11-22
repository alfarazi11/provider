package test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.apis.APIEndpoints;
import utils.APIUtility;

import static io.restassured.RestAssured.given;

public class APITest extends BaseAPIMobileWebTest{

    @Test
    public void scanQR(){
        Response response = given().spec(loginJsonSpec).param("terminalid","WEBADMINTEST123").
                param("cardNo","9999202000000002").when().get(APIEndpoints.scanQR);
        APIUtility.verifyStatusCodeSuccess(response);
//        String birthDate = response.jsonPath().get("data.birthDate");
//        System.out.println(birthDate);
//        Assert.assertEquals(birthDate,"2000-06-22T00:00:00Z");
//        String cardNo = response.jsonPath().get("data.cardNo");
//        System.out.println(cardNo);
//        Assert.assertEquals(cardNo,"9999202000000002");
    }

    public void invalidCredTest() {
//        String loginPayload = DataUtility.getDataFromExcel("Payloads", "IncorrectLoginPayload")
//                .replace("$.username", "a@gmail.com").replace("$.password", "wrongpassword");
//        Response response = given().spec(commonJsonSpec).body(loginPayload).when().post(APIEndpoints.scanQR);
//        assertNotEquals(response.getStatusCode(), 200);
    }

}
