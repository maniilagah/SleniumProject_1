package Reset_Assured;
import  org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;
import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.not; 
//import static org.hamcrest.collection.IsMapContaining.hasEntry;


public class HTTP_Request {
	
	// Given()  
	// content type,set coockies,add auth, add param, set header
	//When()
	// get,post,put,delete
	//then()
	//validate status ,extract response, extract headers cookies and response body
	
	
	// Get all users on oage 2
	// https://reqres.in/api/users?page=2
	
	
	// Get single users
	// https://reqres.in/api/users/2
	
	//Create User
	// https://reqres.in/api/users
	
//	{
//	    "name": "morpheus",
//	    "job": "leader"
//	}
	
	//Update user
	// https://reqres.in/api/users/2
	
//	{
//	    "name": "morpheus",
//	    "job": "zion resident"
//	}
	
	
	
	
@Test	
public void getUser()
{
	
	given()
	.when()
	.get("https://reqres.in/api/users?page=2")
	.then()
	.statusCode(200)
	.body("page",equalTo(2))
	.log().all();
	
	
	
	
}

	
	
	
	

}
