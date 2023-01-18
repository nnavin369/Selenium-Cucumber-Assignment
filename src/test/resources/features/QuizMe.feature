@quizMeFeature
Feature: Quiz Me for Automation Task

Background: Login into unext application
	Given I am on the Login page URL "https://capgemini-edunxtqa01.unext.tech"
    Then I enter registered emailId as "automation2@yopmail.com"
    Then I click on login button and wait for Unext login page
    Then I enter password as "test@123"
    And I Click on Login button
    Then I should see Dashboard page

  Scenario: After Logged in navigate to Start Quiz Page and Attempt all questions
    Given I should see Dashboard page
  	Then I click on All Courses button
    And click on Automation Course link from course list page
    Then click on Go to Content Area button from Automation Course page
    Then click on Quiz link from Course Dashboard
    And click on Automation Task link from Automation Task page
    Then click on Start Quiz button from Automation Task page
  	Then select Answer based on the question type and click Next button for next question
    Then repeat the above steps untill reach end of questions and click on submit
    Then print the quiz related details
    Then validate the attempted number display during quiz start page and noofattempts in report are equal
    Then compare the time taken before submit and validate with report
  
  
  