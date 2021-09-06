#About / Synopsis

* Monefy Appium Project is a project which has automated test scenarios which covers the basic features of the Monefy application which is a finance management app
* Project status: working


# Installation

- download the project zipped folder and place it in your workspace , all the dependencies and exe files are already placed in pom.xml and under resources folder

# Running the code

-- Before running the code make sure that the correct desired capabilities of the device are added in the Project.properties file and also the respective emulator should be configured on the system through android studio. 

--  Code can  be run by right clicking on the testNG.xml file and running it as testNG suite , also individual test files can be run by right clicking on the test cases and run the test case as testNG test.

# Features

- This  project contains various test cases to check the basic functionalities of the Monefy application for eg.

1. Expense Feature (able to add expense or not)
2. Income Feature (able to continue with 0 income or not)
3. Balance Feature (Verify the Balance)
4. Settings feature (Verify the left and Right settings feature)
5. Monefy Pro page verification
6. Exploration of Categories

These are few to name which are covered under this test suite .




# Requirements


- A stable internet connection
- Maven should be up on the system
- Android Studio
- Appium client (dependency given in POM)
- Appium Desktop
- Node.js
- Eclipse or any other editor
- JDK 8 or above
- An emulator should be configured through android studio and details of that emulator should be passed on Project.Properties File uder src/test/resources.

# Test reports

- After running the test through test runner test reports can be checked under the Extent reports folder and index.html file can be opened in browser to see the reports of the test execution.


