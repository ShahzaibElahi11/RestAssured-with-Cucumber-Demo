@UserManagement @Regression
Feature: Check All Employees Services

  Scenario Outline: Check the Request for All Employees Records
    Given Valid Request is prepared
    When Get request is send to server for end point "<End Point>"
    Then response is matches with response specification
    And Value at json path "message" is equals to "Successfully! All records has been fetched."

    Examples:
      | End Point         |
      | /api/v1/employees |

  Scenario Outline: Check the Request for Employee Record by Id
    Given Valid Request is prepared
    When Get request is send to server for end point "<End Point>"
    Then response is matches with response specification
    And Value at json path "data.employee_name" is equals to "Tiger Nixon"
    And Value at json path "message" is equals to "Successfully! Record has been fetched."

    Examples:
      | End Point          |
      | /api/v1/employee/1 |

  Scenario Outline: Create New Employee Record in The Application
    Given Valid Request is prepared
    And Request payload is created for employee
    When Post request is send to server for end point "<End Point>"
    Then response is matches with response specification
    And Extract Employee id from json path
    And Value at json path "message" is equals to "Successfully! Record has been added."
    Examples:
      | End Point      |
      | /api/v1/create |


  Scenario Outline: Update the Request for Employee Record by Id
    Given Valid Request is prepared
    And Update newly created employee record
    When Put request is send to server for end point "<End Point>"
    Then response is matches with response specification
    And Value at json path "message" is equals to "Successfully! Record has been updated."
    Examples:
      | End Point       |
      | /api/v1/update/ |


  Scenario Outline: Check the Request for Delete Employee Record
    Given Valid Request is prepared
    When Delete request is send to server for end point "<End Point>"
    Then response is matches with response specification
    And Value at json path "message" is equals to "Successfully! Record has been deleted"

    Examples:
      | End Point       |
      | /api/v1/delete/ |