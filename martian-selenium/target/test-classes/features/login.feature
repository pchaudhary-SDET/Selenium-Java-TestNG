Feature: Login feature

Scenario: Navigate to Landing Page
Given user is on landing page
And user clicks on login 
And user enters valid username and password
And user clicks on login button
Then user should be navigated to the home page
