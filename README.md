# SauceDemo Automation Framework  
### Java • Selenium • TestNG • Cucumber • Maven • Jenkins (CI)

A beginner–friendly automation framework designed to demonstrate real-world QA automation skills using a clean Page Object Model structure, TestNG, Cucumber (TestNG runner), and continuous integration via Jenkins.

This project automates end-to-end flows on the public test website **SauceDemo**.

---

## ✔️ What This Project Demonstrates
- Java + Selenium WebDriver (Page Object Model)
- TestNG framework (test suites, data providers, assertions)
- Cucumber BDD (Gherkin scenarios + Step Definitions + Hooks)
- Hybrid TestNG + Cucumber execution model
- Maven build automation (pom dependencies, surefire)
- Git + GitHub version control
- Jenkins CI Pipeline using a `Jenkinsfile`
- Clean project structure for future extension

---

## ✔️ Project Structure
```
src/
 └── test/
      ├── java/
      │    ├── pages/       (POM: LoginPage, ProductPage, CartPage)
      │    ├── steps/       (Cucumber Step Definitions + Hooks)
      │    ├── tests/       (TestNG tests + Cucumber Runner)
      │    └── utils/       (DriverFactory)
      │
      └── resources/
           └── features/    (Cucumber feature files)
testng.xml                  (TestNG suite)
pom.xml                     (Maven dependencies)
Jenkinsfile                 (Jenkins Pipeline)
README.md
```

---

## ✔️ Automated Test Coverage

### **Cucumber Scenarios**
- Successful login  
- Add product to cart  
- Verify product appears in cart  

### **TestNG Tests**
- Valid login test  
- Invalid login tests (DataProvider)  
- Add product to cart test  
- Validate cart item details  

---

## ✔️ How to Run Locally

### **Run TestNG Suite**
```
mvn test
```

Or in Eclipse:  
**Right-click → testng.xml → Run As → TestNG Suite**

---

### **Run Cucumber Tests**
Right-click the class:
```
tests.CucumberTestRunner
```
→ Run As → TestNG Test

---

### **Run a Single Cucumber Feature (Recommended)**
Add a tag in your feature:
```gherkin
@cart
Feature: Product Cart
```

Update runner:
```java
@CucumberOptions(tags = "@cart")
```

---

## ✔️ Slow-Mode for Beginners
To visually watch each step:
```
-Dslow=true
```

Set this in Eclipse → Run Configurations → VM Arguments.

---

## ⚠️ Chrome Password Popup Note
Some Chrome setups show a password-save popup after login.  
This framework temporarily includes a small pause so the popup can be dismissed manually.  
The project can be enhanced later using ChromeOptions to suppress the popup completely.

---

## ✔️ Jenkins CI Setup

This project includes a complete **Jenkins Pipeline** using a `Jenkinsfile`.  
The pipeline performs:

- Checkout from GitHub  
- Maven clean + test  
- HTML + JSON report generation  
- Post-build archiving  

Trigger: Manual build or GitHub webhook (optional)

---

## ✔️ How to Run in Jenkins (Pipeline)

1. Create a Pipeline job  
2. Select: **Pipeline script from SCM**  
3. SCM: Git → paste your repo URL  
4. Jenkinsfile path (default):  
```
Jenkinsfile
```
5. Save → Build Now

Jenkins will:
- Clone project  
- Install dependencies  
- Run TestNG + Cucumber  
- Archive reports

---

## ✔️ Technologies Used
- **Language:** Java  
- **Build Tool:** Maven  
- **Testing Framework:** TestNG  
- **BDD:** Cucumber  
- **Browser Automation:** Selenium WebDriver  
- **CI/CD:** Jenkins  
- **Version Control:** Git + GitHub  

---

## ✔️ Why This Project Is Great for a QA Resume
- Demonstrates real automation architecture
- Shows Page Object Model + Hybrid framework skills
- Uses both TestNG and Cucumber
- Includes CI pipeline (big plus for recruiters)
- Clean structure, easy to extend

---

## Author
**Uttam Tyagi**  
QA Automation Learner  
GitHub: https://github.com/uttam512

