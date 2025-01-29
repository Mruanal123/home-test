# Inventory Automation Framework

## Overview
This project is a Selenium-based automation framework designed for end-to-end testing of an Inventory management system. It follows the Page Object Model (POM) design pattern, making the tests modular, maintainable, and easy to understand.

## Project Structure
Below is an overview of the key components and their purpose:


Inventory/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/           # Base test setup and common utilities
│   │   │   ├── pageObjects/    # Page Object Model classes
│   │   │   ├── pageEvents/     # Page interaction methods
│   │   │   ├── utils/          # Utility classes (e.g., data readers, listeners)
│   ├── test/
│       ├── java/
│           ├── inventory/test/ # Test scripts for Login, Search, Forms, etc.
├── testdata/                   # Test data files in .properties format
├── reports/                    # HTML reports of test runs
├── test-output/                # TestNG results and reports
├── pom.xml                     # Maven configuration for dependencies
├── testng.xml                  # To execute the tests
├── screenshots                    # For capturing  the fail test cases


## Prerequisites
- **Java Development Kit (JDK)**: Version 8 or above
- **Maven**: For managing dependencies and building the project
- **Selenium WebDriver**: Included via Maven dependencies
- **IDE**: Eclipse, IntelliJ IDEA, or any other Java IDE

## Setup Instructions
1. **Clone the Repository**:
   bash
   git clone <repository-url>
   cd Inventory
   

2. **Import the Project into Your IDE**:
   - For Eclipse: Use `File -> Import -> Existing Maven Projects`.
   - For IntelliJ IDEA: Open the `pom.xml` file directly.

3. **Install Dependencies**:
   Run the following command to download all required dependencies:
   bash
   mvn clean install
   

4. **Configure Test Data**:
   - Update the `.properties` files in the `testdata` folder with relevant test inputs.

## Running the Tests
1. **Run Using TestNG**:
   Use the `testng.xml` file to execute test cases:
   bash
   mvn test
   

2. **Run Specific Tests**:
   Specify the test class directly:
   bash
   mvn -Dtest=LoginTest test
   

3. **View Reports**:
   - Open the HTML reports in the`reports` folder.

## Key Features
- **Page Object Model**: Separates page locators and actions.
- **Reusable Components**: Common utilities for data reading, listeners, and constants.
- **Cross-Browser Testing**: Configurable through `testng.xml`.
- **Detailed Reporting**: HTML and XML reports for test results.

## Folder Details
### `src/main/java`
- **base**: Contains `BaseTest.java` for common test setup.
- **pageObjects**: Classes for locating elements on web pages.
- **pageEvents**: Methods to interact with web page elements.
- **utils**: Utility classes like `TestDataReader` and `SuiteListener`.

### `src/test/java`
- **inventory/test**: Test scripts for various functionalities (e.g., login, search, form interactions).

### `testdata`
- `.properties` files storing input values for tests.

### `test-output`
- Contains TestNG reports.

### `reports`
- reports getting generated in report folder name as Automation execution reports in HTML format.

## Maven Dependencies
Key dependencies defined in `pom.xml`:
- Selenium Java
- TestNG



