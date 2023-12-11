package RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * Various JobQueue Api tests using Rest assured.
 *
 * @author sagar.subedi
 */
 class RestAssuredSampleTest
{
	/**
	 * Fetch queue test.
	 */
	@Test
	void testGetQueues() {
		final ValidatableResponse response = given()
				.auth()
				.basic("username", "pass***")
				.when()
				.get("queueUrl")
				.then();

		response.assertThat()
				.statusCode(200);

		response.log()
				.all();
	}

	/**
	 * Create queue test.
	 */
	@Test
	void testPostQueue() {
		final String queue =
				"""
				{
				 "color": "000000",
				 "customerId": 1,
				 "queueName": "test"
				}
				""";

		final Response response = given()
				.auth()
				.basic("username", "pass***")
				.header("Content-type", "application/json")
				.and()
				.body(queue)
				.when()
				.post("queueUrl")
				.then()
				.extract()
				.response();

		Assertions.assertEquals(201, response.statusCode(), "Expected the response code to be 201.");
	}

	/**
	 * Update queue test.
	 */
	@Test
	void testPutQueue() {
		final String queue =
				"""
				{
				 "color": "000000",
				 "customerId": 1,
				 "queueName": "test-updated"
				}
				""";

		final Response response = given()
				.auth()
				.basic("username", "pass***")
				.header("Content-type", "application/json")
				.and()
				.body(queue)
				.when()
				.put("queueUrl/id")
				.then()
				.extract()
				.response();

		Assertions.assertEquals(204, response.statusCode(), "Expected the response code to be 204.");
	}

	/**
	 * Delete queue test.
	 */
	@Test
	void testDeleteQueue() {
		final Response response = given()
				.auth()
				.basic("username", "pass***")
				.header("Content-type", "application/json")
				.and()
				.when()
				.delete("queueUrl/id")
				.then()
				.extract()
				.response();

		Assertions.assertEquals(200, response.statusCode(), "Expected the response code to be 200.");
	}
}
