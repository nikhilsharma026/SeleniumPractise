@Login
Feature: Facebook testing.

# Data driven without Examples keyword

@End2End
Scenario: LOgin facebook
  Given Browser and application is opened
	When User enters valid "nickrocks2@gmail.com" and "Jaikalkamaa"
	Then Navigate to homepage and verify title
	Then close the browser

	
# Data Driven with Examples Keyword
 	
@RegressionTest	
	Scenario Outline: Scroll below
	Given user enters valid "<Username>" and "<Password>"
	When user scrolls vertically
	Then exit the browser
	
	Examples:
	| Username | Password |
	| nickrocks2@gmail.com | Jaikalkamaa |