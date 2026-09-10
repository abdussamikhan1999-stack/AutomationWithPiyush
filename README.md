# AutomationWithPiyush

Selenium + Java test automation coursework, built around a vtiger CRM test suite, alongside reference exercises from a Selenium course (batch **A12**).

## Repository structure

| Path | What it is |
|---|---|
| [`CRM_A-12_Selenium/`](./CRM_A-12_Selenium) | My own test project: Selenium tests for a vtiger CRM instance (Contacts, Opportunities) |
| [`A12-selenium-superstar/`](./A12-selenium-superstar) | Course reference exercises (actions, dropdowns, iframes, JS executor, popups, screenshots, synchronization, window handling) |
| `*.xlsx` | Manual test case specs the automated tests are written against |

## Tech stack

- Java (JDK 11+)
- [Selenium WebDriver](https://www.selenium.dev/) 4.34
- Maven
- Selenium Manager — auto-provisions a matching browser/driver pair, no manual chromedriver setup required

## Getting started

**Prerequisites:** JDK, Maven, and internet access (so Selenium Manager can fetch a browser) — or a Chrome/Chromium install already on your machine.

### Run a test

Each test is a plain `main()` method — there's no JUnit/TestNG runner. From a project directory (e.g. `CRM_A-12_Selenium/`):

```bash
mvn test-compile exec:java -Dexec.mainClass="contact.CreateContactText" -Dexec.classpathScope=test
```

Swap the class name for whichever test you want to run, e.g. `oppourtunities.AddNewoppourtunities` or `browser.Browser`.

> The CRM tests (`contact.CreateContactText`, `oppourtunities.AddNewoppourtunities`) expect a local vtiger CRM instance running at `http://localhost:8888/` (login `admin` / `manager`).

### Import into an IDE

Both projects are standard Eclipse/Maven projects (`.project` / `.classpath` included) — File → Import → Existing Maven Projects, then Run As → Java Application on any class.

## Test cases

Manual test case documentation lives at the repo root:

- [`Organization test case.xlsx`](./Organization%20test%20case.xlsx)
- [`Oppourtunites Test case.xlsx`](./Oppourtunites%20Test%20case.xlsx)

## Author

Abdus Sami Khan
