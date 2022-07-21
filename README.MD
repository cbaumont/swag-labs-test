# swag-labs-test

This project uses Selenium WebDriver, WebDriverManager and others, with some good development practices, in order to automate E2E front-end tests.

The web application under test can be found at https://www.saucedemo.com.

1. [Test creation](#test-creation)
2. [Local execution](#local-execution)
3. [Properties file](#properties-file)
3. [Logs and test reports](#logs-and-test-reports)
4. [Parallel testing](#parallel-testing)

## Test creation

The test creation is simple and fast, and should follow the patterns below:
 * Test classes must be on the path `/src/test/java`
 * Test classes must inherit from `BaseTest`
 
### Example

```java
public class MyTest extends BaseTest {

    @Test
    public void shouldLoadSamplePage() {
        
        /*
         * Test code:
         *  - using the Page Objects
         *  - assertions to verify the results
         */
    }
}
```  

## Local execution

This project uses the WebDriverManager library to automatically download the browser's driver during execution.
More info at https://github.com/bonigarcia/webdrivermanager

```xml
 <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>${bonigarcia.version}</version>
 </dependency>
```

You can run your tests through your IDE or running the command  `mvn test` via command line.

## Properties File

This project uses **config.properties**  file to define the base URL of the application under test.

`````properties
# Base URL
url.base = https://www.saucedemo.com
`````

[Properties model](src/main/resources/config.properties)

## Logs and test reports

This project uses Log4J 2 for console logging during the test execution, and Extent Reports to automatically generate a test report after the execution. The report will be created on the path `target/report/test-execution.html`.


## Parallel testing

This project supports the TestNG parallel execution. An example test suite which is running cross-browser tests in parallel can be found at `/src/test/resources/testng.xml`.