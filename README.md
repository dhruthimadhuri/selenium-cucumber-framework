# Selenium Cucumber BDD Framework

A Java-based test automation framework built using Selenium WebDriver, Cucumber BDD, and the Page Object Model (POM) design pattern. Built to demonstrate a clean, scalable, and maintainable automation structure for web application testing.

---

## Tech Stack

| Tool | Purpose |
|---|---|
| Java | Core programming language |
| Selenium WebDriver | Browser automation |
| Cucumber (BDD) | Feature file and step definition structure |
| TestNG | Test execution and configuration |
| Maven | Build and dependency management |
| Page Object Model | Design pattern for maintainability |
| Extent Reports | HTML test execution reporting |

## Test Scenarios Covered

**Login**
- Valid user login with correct credentials
- Verify successful redirect to product page post-login

**Product Selection**
- Browse product listing page
- Select a product and add to cart
- Verify product name and price on product detail page

**Cart Verification**
- Verify selected product appears in cart
- Validate product details (name, quantity, price) in cart

**Logout**
- Logout from application
- Verify user is redirected back to login page

---

## Design Patterns

**Page Object Model (POM)**
Each page of the application has a dedicated Java class that contains all the web elements and methods for that page. This keeps test logic completely separate from page interaction logic, making the framework easy to maintain when the UI changes.

**BDD with Cucumber**
Test scenarios are written in plain English using Gherkin syntax in `.feature` files. This makes tests readable by both technical and non-technical stakeholders.

**Hooks**
`@Before` and `@After` hooks handle browser setup and teardown, and initialise the Extent Report for every test run.

## Key Framework Features

- **Reusable Page Objects** — UI changes only require updates in one place
- **Readable BDD scenarios** — Feature files written in plain Gherkin, easy to review with business stakeholders
- **Extent HTML Reports** — Clear, visual test execution reports with pass/fail breakdown
- **Driver Management** — Centralised WebDriver initialisation and teardown via DriverManager utility
- **Scalable structure** — Easy to add new pages, step definitions, and feature files without touching existing code

---

## Author

**Dhruthi Madhuri Gajjarapu**  
Senior QA Automation Engineer | Ontario, Canada
