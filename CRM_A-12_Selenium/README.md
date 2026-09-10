# CRM_A-12_Selenium

Selenium test suite for a local vtiger CRM instance, built for batch A12 of the Selenium automation course.

## Tests

| Class | Module | What it does |
|---|---|---|
| [`contact.CreateContactText`](src/test/java/contact/CreateContactText.java) | Contacts | Logs in, creates a contact, verifies it, signs out |
| [`oppourtunities.AddNewoppourtunities`](src/test/java/oppourtunities/AddNewoppourtunities.java) | Opportunities | Logs in, creates an opportunity with a related contact, verifies it, signs out |
| [`browser.Browser`](src/test/java/browser/Browser.java) | — | Minimal smoke test (opens a browser, navigates to Google) |

Tests are plain `main()` methods — no JUnit/TestNG, no Page Object Model. Waits are `Thread.sleep`-based rather than explicit `WebDriverWait`, matching the course's conventions at this stage.

## Prerequisites

- A local vtiger CRM instance running at `http://localhost:8888/` (login `admin` / `manager`)
- JDK 11+ and Maven

## Running a test

```bash
mvn test-compile exec:java -Dexec.mainClass="contact.CreateContactText" -Dexec.classpathScope=test
```

Or import into Eclipse (File → Import → Existing Maven Projects) and Run As → Java Application on the class.

## Test case specs

The tests follow the manual test cases in the repo root: `Organization test case.xlsx` and `Oppourtunites Test case.xlsx`.

## Notes

- `oppourtunities.AddNewoppourtunities` locators (field names, popup handling) are inferred from the sibling contact test's conventions and the popup URL captured in the spreadsheet — verify against a live instance if the theme/layout differs.
