Feature: Task Management Workflow

  Background:
    Given I launch the browser
    When Open the url
@Sanity
  Scenario Outline: Admin and Practice Manager task management flow
    Given I enter the valid passcode for the admin user
    And I click on the login button
    Then I should see the page title "DENTAL ERP"
    When I click on Task Management
    And I click on Assigned Tasks
    And I click on the add button to add a new task
    And I enter the task details as follows:
      | TaskTitle   | SearchUser   | SelectUser   | StartDateYeear | StartDateMonth | StartDatedate | DueDateYear   | DueDateMonth   | DueDatedate   | Priority   | Description   |  |
      | <tasktitle> | <searchuser> | <selectuser> | <startyear>    | <startMonth>   | <startdate>   | <duedateyear> | <duedatemonth> | <duedatedate> | <priority> | <description> |  |
   And I click on the save button
    Then I verify the task is created successfully
    And Admin user logout of the application
    And I enter the valid passcode for the Practice Manager
    And Practice Manager click on notification list
    And verify the admin assigned task is present in my task list with the title "<tasktitle>"
    And  click on My Tasks
    And I reassign the task to "<Assignname>"and add comments to the task as "<reassignComments>" from pending list
    And Practice Manager logout of the application
    And I enter the valid passcode for the admin user
    And I click on the login button
    And admin user click on notification list
    And verify the Practice manager reassigned task is present in notification list with the title "<tasktitle>"
    And I accept the request
    And Admin user logout of the application
    And I enter the valid passcode for the 2nd Practice Manager
    And  second Practice Manager click on notification list
    Then I verify the practice manager reassigned task is present in my task list with the title "<tasktitle>"
    And I add the comment "<progressComment>" and move to In Progress
    And I add the comment "<doneComment>" and move to finished
    Then I verify the admin assigned task is present in my task list with the title "<tasktitle>" in the finished list
    And Practice Manager logout of the application
    Examples:
      | tasktitle       | searchuser | selectuser         | startyear | startMonth | startdate | duedateyear | duedatemonth | duedatedate | priority | description   | reassignComments    | progressComment        | doneComment        | Assignname     |
      | Dental Checkup1 | KhajaPM    | KhajaPmAlpha alpha | 2024      | NOV        | 4         | 2024        | NOV          | 5           | High     | Dentalcheckup | Iam unable to do it | Iam taking up the task | completed the task | alpha pm alpha |