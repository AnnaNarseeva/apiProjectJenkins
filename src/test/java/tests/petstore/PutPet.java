package tests.petstore;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPet {

    @BeforeTest
    public static void setup() {
        baseURI = "https://petstore.swagger.io/v2/";
    }

    @Test
    public void changePet(){
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 234567876,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"nameName\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"sold\"\n" +
                        "}")
                .when()
                .put("pet")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);
    }
}
