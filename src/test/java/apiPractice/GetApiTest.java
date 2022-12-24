package apiPractice;

import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetApiTest {

	@Test(enabled = false)
	public void  getCallStatusCodeValidatino() {
		RestAssured
		.given().log().all()
		.get("https://api.instantwebtools.net/v1/airlines/2")
		.then()
		.log().all()
		.statusCode(200);
	}
	@Test(enabled = false)
	public void  getCallBodyCodeValidatino() {
		RestAssured
		.given().log().all()
		.get("https://api.instantwebtools.net/v1/airlines/2")
		.then()
		.log().all()
		.statusCode(200)
		.body("name", equalTo("Singapore Airlines") )
		.body("country", equalTo("Singapore"))
		.body("slogan",equalTo("A Great Way to Fly")) 
		.body("established",equalTo("1947")); 

	}
	@Test(enabled = false)
	public void  getCallListValidatino() {
		String response =		
				RestAssured
				.given()
				.get("https://api.instantwebtools.net/v1/airlines/")
				.then()
				.extract().response().asString();

		System.out.println(response);
		JsonPath path = JsonPath.from(response);
		List<String> airLineNameList = path.getList("Name");
		for(String name: airLineNameList ) {
			System.out.println(name);
		}
	}
	@Test(enabled = false)
	public void  getCallComplexValidatinoJsonPath() {
		String response =		
				RestAssured
				.given()
				.param("page", "1")
				.log().all()
				.get("https://reqres.in/api/users?delay=3")
				.then()
				.extract().response().asString();

		System.out.println(response);

		JsonPath path = JsonPath.from(response);

		List<Integer> list = path.getList("data.id");
		for(int name: list ) {
			System.out.println(name);
		}
		System.out.println("size of the list :" + list.size());
		System.out.println(path.getInt("data.id[1]"));
	}
}
