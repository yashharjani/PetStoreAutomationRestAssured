package api.endpoints;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTest {
	@SuppressWarnings("unchecked")
	@Test
	public void createUser() {
		JSONObject request = new JSONObject();
		request.put("id", "101");
		request.put("username", "John_Wick");
		request.put("firstName", "John");
		request.put("lastName", "Wick");
		request.put("email", "a@gmail.com");
		request.put("password", "test@1");
		request.put("phone", "123456987");
		request.put("userStatus", 0);
		Response response = given().
				header("Content-Type","application/json").
				header("accept","application/json").
				body(request).
			when().
				post(Routes.post_url);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
	}
}
