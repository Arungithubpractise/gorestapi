Feature: Validating Gorest Api for a user

Scenario: verify if user is successfully created 
Given create a user
When user uses "createuserApi"  with "post" http request
Then the API call got success with status code 201
And "gender" in response body is "male"


Scenario: Verify the User created can be fetched from the server

Given fetch the user data created
When user uses "getuserApi"  with "GET" http request
Then the API call got success with status code 200

Scenario: Verify if update user functionality is working

Given UpdateUser Payload
When user uses "updateuserApi"  with "PUT" http request
Then the API call got success with status code 200

Scenario: Verify if Delete user functionality is working

Given DeleteUser Payload
When user uses "deleteuserApi"  with "DELETE " http request
Then the API call got success with status code 204

