Feature: Task Management scenarios

  Background:
    Given I launch the browser
    When Open the url
   And Enter the valid credentials
    And click on login button
    Then I should see the page title "DENTAL ERP"
@regression
Scenario : Assigning Task in task management
  When Click on Task managhement
  And  go to assined tasks
  When add a new task
  And Enter the task details
  And click on save button
  Then verify task created successfully or not
