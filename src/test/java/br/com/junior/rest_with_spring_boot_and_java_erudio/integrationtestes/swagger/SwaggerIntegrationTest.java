package br.com.junior.rest_with_spring_boot_and_java_erudio.integrationtestes.swagger;

import br.com.junior.rest_with_spring_boot_and_java_erudio.config.TestConfigs;
import br.com.junior.rest_with_spring_boot_and_java_erudio.integrationtestes.testcontainers.AbstractIntegrationTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static junit.framework.TestCase.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @Test
    void shouldDisplaySwaggerUIPage() {
        var content = RestAssured.given()
                .baseUri("http://localhost")
                .port(TestConfigs.SERVER_PORT)
                .when()
                .get("/swagger-ui/index.html")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();


        Assertions.assertTrue(content.contains("Swagger UI"));
    }

}
