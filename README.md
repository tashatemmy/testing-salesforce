**Salesforce.com.au Automation Testing**

This project contains automated test scripts for the Salesforce Australia website (https://salesforce.com/au) using Selenium WebDriver and TestNG.

📌 Project Description

The purpose of this project is to demonstrate automation testing skills by validating key workflows and components on the Salesforce Australia website.

**✅ Key Features Automated**

“Try for Free” Section
Automated end-to-end flow of filling out and submitting the trial form.
Handled multiple components within the form, including input validation and dropdowns.
Managed Shadow DOM elements, which required advanced Selenium locators and JavaScript execution.
Switched between windows - homepage and try for free page

Homepage Chat Message Box
Wrote test scripts for interacting with the chat widget on the homepage.
Managed Shadow DOM elements, which required advanced Selenium locators and JavaScript execution.

**Test Demo**
Watch the Salesforce Test Demonstration Here: 
in [Salesforce `Try For Free Demo`](https://www.loom.com/share/35b54a7a4bd84c1a8d93651a4b742190?sid=795fc3ee-1609-4b2f-bfeb-d1ba6186514c)


**🛠️ Tech Stack**

Java
Selenium WebDriver
TestNG
WebDriverManager (for local driver setup)
BrowserStack SDK (for cloud-based cross-browser testing)

**🚀 How to Run**

You can run the tests in two environments:

Local:

```
mvn clean test -Denv=local -Dbrowser=chrome
```

BrowserStack:

```
mvn clean test -Denv=browserstack
```
📂 Structure

Base.java → Test setup (local & BrowserStack drivers)

tests/ → Contains test cases for “Try for Free” form & Chat box

browserstack.yml → BrowserStack SDK config

🎯 Purpose

This project showcases:

Handling complex DOM structures (including Shadow DOM).

Writing scalable TestNG suites.

Executing tests on local and cloud environments.

Building a QA portfolio project to demonstrate automation expertise.
