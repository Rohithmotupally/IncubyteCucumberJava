Feature: Sending Email from Yopmail

Scenario: To check the functionality for Yopmail to Send Email

Given User is on Yopmail Page
When User enter username as "user"
And Clicks on the arrow button
And Check if User is able to login to Inbox
And Click on Edit button
And Enter Subject as "Incubyte Deliverables:1"
And Enter Body as "Automation BQA test for Incubyte"
And Enter Email ID as "BQAAssesement@yopmail.com"
And Click on Send Button
And Refresh the page to get EMail
Then User must be able to view New Mail in Inbox.