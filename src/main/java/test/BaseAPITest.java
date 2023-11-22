package test;

import groovy.json.JsonSlurper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.apis.APIEndpoints;
import utils.DataUtility;

import javax.print.DocFlavor;
import java.util.Base64;
import java.util.Map;


public class BaseAPITest {
    RequestSpecification commonJsonSpec = new RequestSpecBuilder().setBaseUri("https://api-live.meditap.id/v1/")
            .setContentType(ContentType.JSON).build().log().all();
    RequestSpecification loginJsonSpec;
    String uid;


    @Test
    public void login() {
        RestAssured.baseURI = "https://iam.meditap.id/auth/realms/provider/protocol/openid-connect/token";
//        String loginPayload = DataUtility.getDataFromExcel("Payloads", "LoginPayload");
        String loginPayload = "{\"client_id\": \"dire-web-provider\",\"username\": \"testingadmin\"," +
                "               \"password\": \"Tpa@2023\",\"grant_type\": \"password\"}";
        Response response = RestAssured.given().contentType("application/json").body(loginPayload).when()
                .post(APIEndpoints.login);
        Assert.assertEquals(response.getStatusCode(),200);

        String token = response.jsonPath().get("x.access_token");
        System.out.println(token);
//        String token = response.jsonPath().get(JsonPaths.authToken);
        loginJsonSpec = new RequestSpecBuilder().setBaseUri("https://api-live.meditap.id/v1/")
                .setContentType(ContentType.JSON).addHeader("Authorization", token).build().log().all();
       //decoded token
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] parts = token.split("\\.");
        String decodedToken = new String(decoder.decode(parts[1]));
        System.out.println(decodedToken);
        JsonSlurper js = new JsonSlurper();
        Map m = (Map) js.parseText(decodedToken);
        uid = (String) m.get("id");
        System.out.println(uid);
    }

//    public void userId(String userId){
//        Response response = RestAssured.given().contentType("application/json").body(loginPayload).when()
//                .post(APIEndpoints.login);
//        String token = response.jsonPath().get("data.record.token");
//        Base64.Decoder decoder = Base64.getUrlDecoder();
//        String[] parts = token.split("\\.");
//        String decodedToken = new String(decoder.decode(parts[1]));
//    }
}
