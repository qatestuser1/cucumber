Feature: Login

Scenario: Positive login flow
  Given Open Chrome and go to home page
  When Click "Form Authentication" link
  And Input username "tomsmith" and password "SuperSecretPassword!"
  Then Message should be "You logged into a secure area!"
  And Close browser