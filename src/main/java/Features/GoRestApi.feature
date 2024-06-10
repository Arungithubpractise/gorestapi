Feature: Validating Gorest Api for a user

Scenario: verify if user is successfully created 
Given create a user
When user uses "createuserApi"  with "post" http request
Then the API call got success with status code 201
And "gender" in response body is "male"


Scenario: Verify if Delete user functionality is working

Given DeleteUser Payload
When user uses "createuserApi"  with "post" http request
Then the API call got success with status code 200