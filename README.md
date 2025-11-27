# SauceDemo Automation — Java + Selenium + TestNG + Cucumber

A beginner-friendly automation framework for the SauceDemo demo site.  
Implements Page Object Model (POM) with TestNG and Cucumber (TestNG runner).

## What’s included
- Java + Selenium WebDriver (Page Objects)
- TestNG tests: `LoginTest`, `ProductTest`, `CartTest`
- Cucumber feature files + step definitions + `CucumberTestRunner`
- Simple `DriverFactory` for Chrome (WebDriverManager)
- `testng.xml` suite and feature files under `src/test/resources/features`
- NOTE: Current project contains a small manual pause after login to allow dismissing a Chrome password popup (documented below).

---

## Project structure (important parts)
src/
test/
java/
    pages/ (Page Objects)
    tests/ (TestNG tests + runner)
    steps/ (Cucumber step defs + Hooks)
    utils/ (DriverFactory)
resources/
    features/ (Cucumber .feature files)
testng.xml
pom.xml
README.md

---

## Quick prerequisites
- Java 11+ or 17+ installed
- Maven installed
- Chrome browser installed (WebDriverManager will fetch driver)
- An IDE (Eclipse / IntelliJ) or use command line

---

## How to run

### Run full TestNG suite (all TestNG test classes)

From project root:

mvn test

or run testng.xml from IDE: Right click -> Run As -> TestNG Suite

### Run the Cucumber feature suite (via the TestNG Cucumber runner)
- Run `tests.CucumberTestRunner` as TestNG Test in your IDE, or `mvn test` if runner is included in suite.

### Run ONLY a single Cucumber feature (recommended while developing)
- Add a tag (e.g. `@cart`) above your feature and update `@CucumberOptions(tags = "@cart")` in `CucumberTestRunner`, then run the runner.

## Slow mode (visual debugging)
If you want to slow the steps so you can watch actions:
- Add VM argument: -Dslow=true
...

## IMPORTANT: Manual Chrome popup note
Some Chrome installations show a **Save/Update password** popup right after login.  
This project currently includes **a small manual pause** in Cucumber and TestNG setups so you can click **OK** on that popup when it first appears.

- Pause locations:
  - `ProductCartSteps` `@Given` (Cucumber) — `Thread.sleep(...)`
  - `ProductTest` / `CartTest` `@BeforeMethod` (TestNG) — `Thread.sleep(...)`

---

## Commit & push to GitHub (quick commands)
Replace `<your-github-url>` with the repo URL you create on GitHub.

```bash
git init
git add .
git commit -m "Initial commit — SauceDemo automation"
git branch -M main
git remote add origin <your-github-url>
git push -u origin main

















