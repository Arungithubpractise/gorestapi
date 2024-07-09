Feature: OAuth Generation using Authorization Code

  Scenario: Successfully generate an OAuth token
    Given Hitting a Authorization url in browser with client id and client secret to get authorization code
    When I request an access token using the authorization "Token" with "POST" http request 
    Then I should receive a valid access token
    
    Scenario: create a playlist    
    Given create a playlist with userid
    When we use "createplaylistApi"  with "post" http request
    Then API call got success with status code 201
   
   
#    Scenario: Adding Custom Playlist Cover Image 
#    Given I upload the image to the endpoint "/images" with image id 
#    When the upload is successful
#    Then the response status code should be 200
#    And the response should contain "Image uploaded successfully"