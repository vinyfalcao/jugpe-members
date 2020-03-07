package br.com.jugpe;

import br.com.jugpe.models.Member;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
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

    @Test
    public void testAddEndpoint() {
        Jsonb jsonb = JsonbBuilder.create();
        given()
                .contentType(ContentType.JSON)
                .body(jsonb.toJson(new Member("Vinicius")))
                .when()
                .post("/members")
                .then()
                .statusCode(201)
                .body(containsString("Vinicius"));
    }


}
