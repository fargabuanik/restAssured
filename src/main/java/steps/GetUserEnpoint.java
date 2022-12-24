package steps;

import java.util.HashMap;
import java.util.Map;

import utils.ReadConfig;
import utils.RestSteps;

public class GetUserEnpoint extends RestSteps {
	final String ENDPOINT = "/api/users";
	Map<String, Object>map= new HashMap<String, Object>();


	ReadConfig readConfig = new ReadConfig();

	public GetUserEnpoint() {
		setBaseUrl(readConfig.get("reqResbaseUrl"));
	}

	public void getUsers() {
		map.put("page", 2);
		setAsget(ENDPOINT,map);
	}

	public void statusCodeValidation() {
		getResponse().then().statusCode(200);


	}
}

