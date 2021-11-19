Feature: To Check the functionality of the homepage of *BigSmall.in*

Scenario Outline: To check the Login functionality
Given The user lands on the expected url
When the user Login is checked with valid data
Then the user Login is checked with invalid data "<user>" and "<pass>"
And The forgot password functionality is checked
Then close the report

Examples:
| user			       | pass    |
| sedifek613@otozuz.com| book@123|


Scenario: To check the Shopping flow
Given The user lands on the expected url
Then To buy Item using the search bar
And To buy Item using the header dropdown
Then To buy from the Latest products


Scenario: To check the Checkout flow
Given Checks the wishList  
Then Checkout from the cart
And Remove from teh cart
Then Contact the owner for conveying a Message
