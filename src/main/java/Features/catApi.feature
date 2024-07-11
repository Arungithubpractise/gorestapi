Feature: uplaod a image file

  Scenario: Verify if image is successfully uploaded
    Given I have a valid JPEG file 
    When I upload the JPEG file to "upload" with http "POST" method
    #Then the upload should be successful
    And the response status code should be 200
    And the response should contain the file URL




