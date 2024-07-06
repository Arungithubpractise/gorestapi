Feature: OAuth Generation using Authorization Code

  Scenario: Successfully generate an OAuth token
    Given Hitting a Authorization url in browser with client id and client secret to get authorization code
    When I request an access token using the authorization "Token" with "POST" http request 
    Then I should receive a valid access token
    