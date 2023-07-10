package api.endpoints;

//Created to perform CRUD operations for the user API.

import static io.restassured.RestAssured.*;
import io.restassured.http.*;
import io.restassured.response.Response;

import api.payload.User;

public class UserEndPoints {
	
	public static Response createUser(User payload){
		
		Response response = given().
				header("Content_Type","application/json").
				header("accept","application/json").
				body(payload).
			when().
				post(Routes.post_url);
		
		return response;
	}
	
	public static Response readUser(String userName){
		
		Response response = given().
				header("accept","application/json").
				pathParam("username",userName).
			when().
				get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload){
		
		Response response = given().
				header("Content_Type","application/json").
				header("accept","application/json").
				pathParam("username",userName).
				body(payload).
			when().
				put(Routes.update_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName){
		
		Response response = given().
				header("accept","application/json").
				pathParam("username",userName).
			when().
				delete(Routes.delete_url);
		
		return response;
	}
	
}
