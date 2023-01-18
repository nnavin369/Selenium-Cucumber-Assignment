@quizReportFeature
Feature: Login into unext application with Invalid credentials for failure test case 

  Scenario: Login into unext application with Invalid credentials
  	Given I am on the Login page URL "https://capgemini-edunxtqa01.unext.tech"
    Then I enter registered emailId as "automation2@yopmail.com"
    Then I click on login button and wait for Unext login page
    Then I enter password as "test@321"
    And I Click on Login button
    Then I should see dashboard page after login
  
 