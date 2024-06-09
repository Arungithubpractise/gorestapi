Feature: Validating Gorest Api for a user

Scenario: verify if user is successfully created 
Given create a user
When user uses "createuserApi"  with "post" http request
Then check data is created with status code 201 created
And "gender" in response body is "male"