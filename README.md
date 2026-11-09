# E-Commerce Test Automation

## Project Overview

This project focuses on automating functional tests for an e-commerce web application using Selenium WebDriver and Java.

The objective is to validate key user workflows, including authentication, shopping cart management, product sorting, and checkout.

The tests are implemented using the Page Object Model (POM) design pattern to improve code organization, maintainability, and reusability.

## Technologies Used

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git & GitHub
- Google Chrome

## Application Under Test

- Website: https://www.saucedemo.com/
- Test account: `standard_user`

## Test Scenarios

| Test ID | Scenario | Expected Result |
|---|---|---|
| TC01 | Valid login | User accesses the products page |
| TC02 | Invalid password | Error message is displayed |
| TC03 | Empty username | Username validation message is displayed |
| TC04 | Empty password | Password validation message is displayed |
| TC05 | Add product to cart | Product appears in the cart |
| TC06 | Remove product from cart | Product is removed |
| TC07 | Sort products by price ascending | Products are sorted from lowest to highest price |
| TC08 | Access checkout | Checkout information form is displayed |
| TC09 | Complete an order | Order confirmation message is displayed |

## Project Architecture

```text
src
└── test
    └── java
        ├── pages
        │   ├── BasePage.java
        │   ├── LoginPage.java
        │   ├── InventoryPage.java
        │   ├── CartPage.java
        │   └── CheckoutPage.java
        │
        └── tests
            ├── BaseTest.java
            ├── LoginTest.java
            └── CartTest.java
```

## Design Pattern

The project uses the Page Object Model (POM).

Each page has its own class containing:
- Web element locators.
- Methods for interacting with the page.
- Reusable actions.

The test classes contain the test scenarios and assertions.

## Test Execution

Make sure Java 21, Maven, and Google Chrome are installed.

Run the tests using:

```bash
mvn clean test
```

## Test Reports

Maven Surefire generates test reports in:

```text
target/surefire-reports/
```

Reports include test execution results, failures, errors, and skipped tests.

## Current Test Results

The initial test execution completed successfully:

- Tests executed: 9
- Failures: 0
- Errors: 0
- Skipped: 0

**Build status: SUCCESS**

## Author

Karima Ait Ahmid

GitHub: https://github.com/KarimaAitAhmid/Ecommerce-Selenium-Testing
