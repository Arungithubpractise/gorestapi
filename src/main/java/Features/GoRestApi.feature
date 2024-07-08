Feature: Validating Gorest Api for a user

Scenario Outline: verify if user is successfully created 

Given create a user with "<gender>"  "<status>"
When user uses "createuserApi"  with "post" http request
Then the API call got success with status code 201
And "gender" in response body is "male"
#And verify id created to "<name>" using "getPlaceAPI" 

Examples:
	|gender  | status   |
	|male    | inactive |
	
Scenario: Verify the User created can be fetched from the server

Given fetch the data created of user with "getuserApi" 
When user uses "getuserApi"  with "GET" http request
Then the API call got success with status code 200

Scenario: Verify if update user functionality is working

Given UpdateUser with "updateuserApi" 
When user uses "updateuserApi"  with "PUT" http request
Then the API call got success with status code 200

Scenario: Verify if Delete user functionality is working

Given Delete the user with "deleteuserApi"
When user uses "deleteuserApi"  with "DELETE" http request
Then the API call got success with status code 200

