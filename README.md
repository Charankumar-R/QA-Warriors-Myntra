# Myntra Automation Framework (Selenium + TestNG + PageFactory)

## Project Overview

This project is a **Selenium Test Automation Framework** designed to automate key user journeys of an e-commerce platform similar to Myntra.

The framework follows the **Page Object Model (POM) with PageFactory**, integrates **Allure reporting**, and supports **Excel-based data-driven testing**.

It automates multiple real-world scenarios such as:

* Product search
* Product selection
* Sorting products
* Coupon application
* Quantity validation
* Mandatory field validation
* Excel input/output validation

The goal of the project is to demonstrate a **scalable automation framework architecture used in real QA automation teams**.

---

# Technology Stack

| Technology       | Purpose                          |
| ---------------- | -------------------------------- |
| Java 21          | Programming Language             |
| Selenium 4       | Web Automation                   |
| TestNG           | Test Execution Framework         |
| Maven            | Dependency Management            |
| PageFactory      | Page Object Model Implementation |
| Apache POI       | Excel Data Driven Testing        |
| Allure Report    | Test Reporting                   |
| WebDriverManager | Driver Management                |

---

# Framework Architecture

```
src
 └ test
    ├ java
    │
    │  ├ base
    │  │    BaseTest.java
    │  │    DriverFactory.java
    │  │
    │  ├ listeners
    │  │    AllureListener.java
    │  │
    │  ├ pages
    │  │    BasePage.java
    │  │    HomePage.java
    │  │    ProductsPage.java
    │  │    ProductPage.java
    │  │    BagPage.java
    │  │    CouponPage.java
    │  │
    │  ├ tests
    │  │    ValidCouponTest.java
    │  │    ValidCouponWithSortingTest.java
    │  │    InvalidCouponTest.java
    │  │    DynamicQtyLimitTest.java
    │  │    AddToBagWithoutSizeTest.java
    │  │
    │  ├ utils
    │  │    ExcelUtils.java
    │  │    ExcelReader.java
    │  │    PropertyReader.java
    │  │    TestDataProvider.java
    │
    └ resources
        allure.properties
        config.properties
        testdata.xlsx
        testng.xml
```

---

# Framework Design

The framework is divided into the following layers:

### Base Layer

Responsible for browser initialization and test setup.

Classes:

* **DriverFactory** – manages WebDriver instance
* **BaseTest** – test lifecycle setup and teardown

---

### Page Layer (Page Object Model)

Each web page is represented as a class containing:

* Page elements using **@FindBy**
* Page actions
* Business logic methods

Pages implemented:

* HomePage
* ProductsPage
* ProductPage
* BagPage
* CouponPage

PageFactory initializes elements automatically.

---

### Test Layer

Contains automated test scenarios.

Each test:

* Uses Page Objects
* Includes Allure step logging
* Uses assertions for validation

Implemented tests:

* ValidCouponTest
* ValidCouponWithSortingTest
* InvalidCouponTest
* DynamicQtyLimitTest
* AddToBagWithoutSizeTest

---

### Utility Layer

Reusable helper components.

Utilities include:

* ExcelUtils – read/write Excel
* ExcelReader – structured Excel handling
* PropertyReader – read configuration properties
* TestDataProvider – TestNG data provider support

---

### Listener Layer

The **AllureListener** captures:

* Test start/end
* Screenshots on failure
* Attachments for Allure report

---

# Data Driven Testing (Excel)

The framework supports **Excel input and output**.

Test data is read from:

```
src/test/resources/testdata.xlsx
```

Example structure:

| TestCase    | Product     | Name | PriceBefore | PriceAfter | Result |
| ----------- | ----------- | ---- | ----------- | ---------- | ------ |
| ValidCoupon | Men T-shirt |      |             |            |        |

### Excel Input

Product name is read from Excel.

### Excel Output

The framework writes:

* Product Name
* Price Before Coupon
* Price After Coupon
* Test Result

Example after execution:

| TestCase    | Product     | Name        | PriceBefore | PriceAfter | Result |
| ----------- | ----------- | ----------- | ----------- | ---------- | ------ |
| ValidCoupon | Men T-shirt | Men T-shirt | 299         | 199        | PASS   |

---

# Test Scenarios

## 1. Valid Coupon Test

Objective:

Verify that applying a valid coupon reduces the product price.

Flow:

```
Home Page
 ↓
Search Product
 ↓
Products Page
 ↓
Select Product
 ↓
Product Page
 ↓
Select Size
Add to Bag
 ↓
Bag Page
 ↓
Apply Coupon
 ↓
Validate Price Reduction
```

Validation:

```
Price After Coupon < Price Before Coupon
```

---

## 2. Valid Coupon with Sorting

Objective:

Validate coupon application after sorting products.

Flow:

```
Search Product
 ↓
Sort by Customer Rating
 ↓
Select Product
 ↓
Add to Bag
 ↓
Apply Coupon
 ↓
Validate Discount
```

---

## 3. Invalid Coupon Test

Objective:

Ensure invalid coupon codes are rejected.

Expected result:

```
Error message displayed
Coupon not applied
```

---

## 4. Dynamic Quantity Limit Test

Objective:

Verify maximum quantity selection.

Flow:

```
Search Product
 ↓
Select Product
 ↓
Add to Bag
 ↓
Change Quantity to Maximum
 ↓
Validate Quantity = 10
```

---

## 5. Negative Test – Add To Bag Without Size

Objective:

Ensure size selection is mandatory.

Flow:

```
Search Product
 ↓
Select Product
 ↓
Click Add To Bag Without Selecting Size
```

Expected Result:

```
Error message: Please select size
```

---

# Allure Reporting

Allure provides advanced test reports including:

* Test execution summary
* Step-by-step actions
* Screenshots on failure
* Attachments
* Execution timeline

Generate report:

```
mvn clean test
allure serve
```

---

# Running the Tests

Execute the test suite using:

```
mvn clean test
```

Test execution is controlled using:

```
src/test/resources/testng.xml
```

---

# Key Features

The framework implements:

* Page Object Model with PageFactory
* Data Driven Testing using Excel
* Automated Excel Result Logging
* Allure Reporting Integration
* Modular Framework Architecture
* Selenium Web Automation
* TestNG Execution

---

# Project Objective

This project demonstrates how to build a **production-ready automation framework** capable of validating real-world e-commerce workflows.

It showcases:

* Clean test architecture
* Maintainable automation design
* Data-driven testing
* Advanced reporting integration

---
