Feature: Test pre-uat smoke scenario
  
Scenario Outline: Test Login with Valid credentials
    Given Open Chrome and start application
    When I enter valid username "<username>" and password "<password>"
    Then User should be able to login successfully and see the heading as "<heading>"
    Then application should be closed

Examples: 
      | username              | password  | heading |
      | javier van der meulen | KYCnet123 | My reviews|
      | javier van der meulen | KYCnet123 | My reviews|
      | javier van der meulen | KYCnet123 | My reviews|