Feature: create a pet and upload an image for a created pet 
   
Scenario: verify if pet is successfully created 
   Given create a pet
   When we will use "createPetApi"  with "POST" http request
   Then the API call should get success with status code 200
   

  Scenario: Verify if image is successfully uploaded
    Given I have a valid JPEG file 
    When I "upload" the JPEG file with http "POST" method
    Then the upload should be successful
    And the response status code should be 200
    And the response should contain the file URL




