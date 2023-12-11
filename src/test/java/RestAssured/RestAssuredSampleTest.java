package RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * Various Api tests using Rest assured.
 *
 * @author sagar.subedi
 */
class RestAssuredSampleTest {
	/**
	 * Fetch data test.
	 */
	@Test
	void testGetData() {
		final ValidatableResponse response = given()
				.auth()
				.basic("username", "pass***")
				.when()
				.get("Url")
				.then();

		response.assertThat()
				.statusCode(200);

		response.log()
				.all();
		// TODO: Various other junit assertions can be made.
	}

	/**
	 * Create data test.
	 */
	@Test
	void testPostData() {
		final String data =
				"""
				{
				 "someName": "name",
				 "id": 1,
				 "data": "test"
				}
				""";

		final Response response = given()
				.auth()
				.basic("username", "pass***")
				.header("Content-type", "application/json")
				.and()
				.body(data)
				.when()
				.post("url")
				.then()
				.extract()
				.response();

		Assertions.assertEquals(201, response.statusCode(), "Expected the response code to be 201.");
		// TODO: Various other junit assertions can be made.
	}

	/**
	 * Update data test.
	 */
	@Test
	void testPutData() {
		final String data =
				"""
				{
				 "someName": "name",
				 "id": 1,
				 "data": "test"
				}
				""";

		final Response response = given()
				.auth()
				.basic("username", "pass***")
				.header("Content-type", "application/json")
				.and()
				.body(data)
				.when()
				.put("url/id")
				.then()
				.extract()
				.response();

		Assertions.assertEquals(204, response.statusCode(), "Expected the response code to be 204.");
		// TODO: Various other junit assertions can be made.
	}

	/**
	 * Delete data test.
	 */
	@Test
	void testDeleteData() {
		final Response response = given()
				.auth()
				.basic("username", "pass***")
				.header("Content-type", "application/json")
				.and()
				.when()
				.delete("url/id")
				.then()
				.extract()
				.response();

		Assertions.assertEquals(200, response.statusCode(), "Expected the response code to be 200.");
		// TODO: Various other junit assertions can be made.
	}
}
