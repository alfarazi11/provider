package test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import restassured.apis.APIEndpoints;

public class BaseAPIMobileWebTest {

    RequestSpecification commonJsonSpec = new RequestSpecBuilder().setBaseUri("https://m.meditap.id/api")
            .setContentType(ContentType.JSON).build().log().all();
    RequestSpecification loginJsonSpec;

    @Test
    public void login() {
        RestAssured.baseURI = "https://api-live.meditap.id";
//        String loginPayload = DataUtility.getDataFromExcel("Payloads", "LoginPayload");
        String loginPayload = "{\"email\": \"whinda.permatasari@meditap.id\",\"password\": \"@Whinda1001\"}";
        Response response = RestAssured.given().contentType("multipart/form-data").body(loginPayload).when().post(APIEndpoints.login);
        Assert.assertEquals(response.getStatusCode(),200);

        String token = response.jsonPath().get("token");
//        System.out.println(token);

        loginJsonSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-live.meditap.id")
                .setContentType("multipart/form-data")
//                .setContentType(ContentType.HTML)
                .addHeader("Authorization", token)
                .build().log().all();
    }
}
