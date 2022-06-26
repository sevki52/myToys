 # myToys
Einfach alles für Ihr kind

This repository holds the test cases for the different  features offered by myToys. 
The framework chosen to implement this automated testing is Cucumber and using Java as the underlying implementation language. 
The below section gives a brief overview on how Cucumber is used in this testing.

Sample Scenario from Feature file

Scenario: The user searches for trampoline
      Given the user is on the home page
      When the user writes "trampoline"  on the search box
      And the user clicks on search button

# GUIDANCE
This is a maven project. so It's assumed that the host running this code have Java and maven installed and JAVA_HOME already set. 
Here is the guide for maven installation just in case : https://maven.apache.org/install.htmlProject get all dependencies from maven repository. So no additional installation is needed.
It is created based on POM design model. 
Dependencies that used in the projects are as follows; Selenium Webdriver, Cucumber, Cucumber-junit,Bonigarcia Webdrivermanager
 
# CREDENTIALS
Credentials are provided in configuration.properties file

# TEST EXECUTION
* Pre Conditions of execution;
  * IDE must be installed
* Open project in IDE and type to terminal following code order by
  ```
  mvn test
  ```
 
 Go to "CukesRunner file and click on green arrow next to (public class CukesRunner)
  


# TEST REPORTS
 
Cucumber HTML Plugin Reports target -> cucumber-html-reports > overview-steps.html (Right Click and Open in any Browser )

When you run the project from Maven verify, Cucumber will create automatically online report link. Reports will be saved in target folder.



    Software Test Engineer
        Sevki Öksüz