package br.com.jugpe;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MembersResourceTest {

    @Test
    public void testFindAllEndpoint() {
        given()
                .when().get("/members")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }



}
