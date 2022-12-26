<h1><b>API Testing Framework</b></h1>

This Framework is designed for Backend Testing of web services using Java with RestAssured and Cucumber utilizing Maven as a dependency management tool.

<h2><b>Technology Stack</h2></b>
 1 Java<br>

 2 Cucumber<br>

 3 RestAssured<br>

 4 Maven<br>

 5 Extent Report<br>

 6 PDF Report<br>

<h2><b>Prerequisites</h2></b>

  1 Java 1.8 - Java Dev Kit<br>
  2 Maven - Dependency Manager<br>
  3 IntelliJ IDEA - IDE<br>

<h2><b>Project Structure</h2></b>
  1 Model: This directory contains all the response pojos of each JSON placeholder endpoint.<br>
  2 Runner: This package contains the runner file<br>
  3 Features: This package contains all test cases that are written in gherkin language.<br>
  4 Step Definitions: This package contains all test case methods that are written in java language.<br>
  5 Utilities: This package contains utility Classes<br>

<h2><b>Installation</h2></b>

Clone the repository to your workspace.  https://github.com/ShahzaibElahi11/RestAssured-with-Cucumber-Demo.git<br>

Run the following command in Terminal and build the project. It will automatically download all the required dependencies.<br>

```
mvn clean install
```

If the build is successful. All the required dependencies are installed successfully. But if the build fails, make sure to resolve all the issues in order to execute tests successfully. Make sure that config.properties path in the Property Reader class is set according to your Operating System Environment.<b>

<h2>Execute Tests</h2>

Run the following command in Terminal to execute tests.<br>

```
mvn clean verify
```

<h2><b>Test Reports</h2></b>

You can find the Extent HTML/PDF and JSON reports in the following directory of the Project.<br>

  1 \target\test-output\Spark\Inventa-HTML-Report.html<br>
  2 \target\test-output\PdfReport\ Inventa-PDF-Report.pdf<br>
  3 \target\test-output\json\Inventa-JSON-Report.json<br>
  
Also, Under the target folder directory, open ‘HTML-Report.html file to view the report.<br>
