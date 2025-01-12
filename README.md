# Automation-Exercise
*Approach:
-Page Object Model (POM):
HomePage: Contains methods for navigating through the site, such as selecting products and adding them to the cart.
LoginPage: Contains methods for login with valid credentials
CartPage: Methods for proceeding to checkout.
CheckoutPage: Methods for checking the product and the user data then check out.
PaymentPage: Methods for completing the order and inserting the payment data.
ConfirmationPage: Methods for asserting the order's success.

-Data-Driven Approach:
Use an external data source (e.g., a Jason file) to store test data, including payment information and product details.

-Test Data File:
Create a data file (Jason) containing product details and payment information.
Sample fields for the data file:
Product name, name on card
card number, CVC, expiration month, expiration year
Test Automation Script:

-Test Setup:
Use TestNG to configure the test and initialize WebDriver and other required dependencies.

-Test Execution: 
Implement test methods using Selenium to interact with the website based on POM.

-Assertions: Verify that the checkout steps are completed successfully, such as:
Correct product added to cart.
Correct shipping and payment information are displayed.
Order confirmation received.

-Reporting:
Use Allure Reports to generate detailed reports.
The reports will show the status of each step, including any failures.

-GitHub Repository:
Host the source code, along with the test scripts, POM, data files, and test report.

*Tools Used
-Selenium: 
For automating browser interactions.
-TestNG: 
For test execution, managing test cases, and reporting.
-Page Object Model (POM): 
For better code organization and maintainability.
Allure Reports: 
-For test reporting.
-GitHub: 
For version control and sharing the project.

*Implementation
-Create Page Objects:
HomePage: Select products, and add to cart.
CartPage: Proceed to checkout.
CheckoutPage: Proceed to enter payment info.
paymentPage: Enter payment info
ConfirmationPage: Confirm the order.

-Create Data-Driven Test:
Read product and user information from a CSV or Excel file using libraries like Apache POI or OpenCSV.

-Test Flow:
Select a product and add it to the cart.
Proceed to checkout and then fill in the data from the data file.
Complete the order and validate confirmation.
Reporting:

Generate reports with Allure Report to show the status of test execution.
