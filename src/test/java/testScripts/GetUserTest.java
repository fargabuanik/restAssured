package testScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.GetUserEnpoint;

public class GetUserTest {

	GetUserEnpoint getUsers;

	@BeforeMethod
	public void init () {
		getUsers = new GetUserEnpoint();

	}
	@Test
	public void getUsers() {
		getUsers.getUsers();
		getUsers.statusCodeValidation();
		getUsers.responseBodyValidation("data.last_name[2]" , "Funke");
		getUsers.responseBodyValidation("data.first_name[1]" , "Lindsay");
	}

}
