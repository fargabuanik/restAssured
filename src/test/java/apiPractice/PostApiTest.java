package apiPractice;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostApiTest {

	@Test(enabled = false)
	public void postPassengerPrettyPrintTest() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body("{\"name\": \"Anik\",\"trips\": 151,\"airline\":1}")
		.post("https://api.instantwebtools.net/v1/passenger")
		.prettyPrint();

	}
	@Test(enabled = false)
	public void postPassengerTestWithFile() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(new File("src/apiPractice/resources/passenger.json"))
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(3))
		.body("airline.name",hasItem("Cathay Pacific"))
		.body("airline.website[0]",equalTo("www.cathaypacific.com"));

	}
	@Test(enabled = false)
	public void postPassengerTestWithFileAsInputStrean() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(new File("src/apiPractice/resources/passenger.json"))
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(3))
		.body("airline.name",hasItem("Cathay Pacific"))
		.body("airline.website[0]",equalTo("www.cathaypacific.com"));

	}
	@Test(enabled = false)
	public void postPassengerTestWithFileAsInputByteArray() throws IOException {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("src/apiPractice/resources/passenger.json"))
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(3))
		.body("airline.name",hasItem("Cathay Pacific"))
		.body("airline.website[0]",equalTo("www.cathaypacific.com"));
	}
	@Test(enabled = false)
	public void postPassengerTestWithMap() {
		Map<String, Object>map = new HashMap<>();
		map.put("name", "Anik");
		map.put("trips", 101);
		map.put("airline", 3);
		
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(map)
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(3))
		.body("airline.name",hasItem("Cathay Pacific"))
		.body("airline.website[0]",equalTo("www.cathaypacific.com"));
	}
}