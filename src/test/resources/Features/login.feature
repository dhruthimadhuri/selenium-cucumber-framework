Feature:  To test login feature
@smoke
Scenario: To test successful login
Given user is on login page
When user enters uname and pwd 
And clicks on login button
Then user should be logged in successfully


 