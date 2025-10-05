Feature: Cart feature
Scenario Outline: Add and remove item from cart
Given User should trigger "https://www.myntra.com"
When user searches for "<product>"
Then Product list page should be displayed
When he selects what is new option from the sort dropdown
And he selects a discount range
And he clicks on the first option
Then Product description page should be displayed
When he selects the size as "<size>"
And he clicks on add to bag button
Then Added to bag popup should be displayed
When he clicks on got to bag button
Then Shopping bag page should be displayed
When he clicks on remove button 
And he clicks on remove option in the popup
Then itemn removed message should be displayed

Examples:
		|product|size|
		|shoes for men|8|
		|jeans for men|32|
		|bangles for women|2.6|
		|jackets for women|L|