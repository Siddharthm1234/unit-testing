package com.example.unittesting.integration;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class HomeControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    @Sql(
            scripts = { "/items-delete-test.sql", "/items-insert-test.sql"}
    )
    @Sql(
            scripts = "/items-delete-test.sql",
            executionPhase = AFTER_TEST_METHOD)
    public void getItemIntegrationTest() throws JSONException {
        String response = testRestTemplate.getForObject("/items", String.class);
        JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]", response, false);

    }
}
