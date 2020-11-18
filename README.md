# WestpacMobileWebApp
This project provides the solution to run the Westpac web app automation using Serenity, Cucumber and Appium all working together to run a mobile web app.
This Readme page helps to understand how to run the test after cloning the project.

# Application under test
In this project, the AUT is https://www.westpac.co.nz/ . The selected test device is Android tablet. The application will be opened in Emulator’s chrome browser.
# How to run
-	Open the Android Emulator (Tablet).
-	Make sure that you have all software’s installed to run the Appium test
-	Go to the folder path where your project POM.xml resides and type
-	**mvn clean verify -Dcucumber.options=”—tags @smoke”** – This will run one of the scenarios from KiwiSaverCalc.feature in Android Emulator
-	In case of running all the scenarios from all feature files, use **“mvn clean verify serenity:aggregate”** which will run all scenarios and produce the aggregated results.
# How to add further tests
For a new story
-	Design your feature files based on your acceptance criteria and what your user wants to achieve
-	Create your step definitions for how to do what the user wants to achieve
# Reporting
This project uses the Serenity reports which acts as a living documentation of results.
* After running the **mvn clean verify**, the report is available at **\kiwisaverMobile\reports\timestamp** folder if the test is initiated from the command prompt.
* If tests are started from **TestRunner** class (which is inside com.westpac.webapp.testRunner package), then results will be available at **target/site/serenity/index.html**

