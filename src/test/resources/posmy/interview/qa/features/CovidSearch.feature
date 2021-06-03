Feature: Launch browser and open Google homepage

Scenario: Launch browser and open Google

Given User is on Google page

When user enters covid 19 in Malaysia into search box

When user clicks Google Search button

Then validate Top Stories section is shown

When user clicks on Testing menu on sidebar

Then Validate Common Question Labels shown

When user clicks on Overview menu on sidebar

Then user clicks on MOH link from results page