Feature: user Details

Scenario: get call test
Given url 'https://reqres.in/api/users/23'
When method GET
Then status 404


Scenario: get call test
    Given url 'https://reqres.in/api/users/2'
    When method GET
    Then status 200


Scenario: get call test
    Given url 'https://reqres.in/api/users/2'
    When method DELETE
    Then status 204


Scenario: Successful Login
    Given driver 'https://demowebshop.tricentis.com/login'
    And input('#Email', 'nashtechhoang@gmail.com')
    And input('#Password', '123321456')
    When click('.button-1.login-button')
    Then waitFor("//div[@class='header-links']/ul/li/a[@class='account']")
    Then match driver.exists("//div[@class='header-links']/ul/li/a[@class='account']") == true
