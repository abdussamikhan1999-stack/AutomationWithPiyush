# AutomationWithPiyush

Selenium/Java coursework repo (Piyush's course, batch A12). Two sibling projects at repo root:

- `CRM_A-12_Selenium/` — my own vtiger CRM test project. This is the one to edit.
- `A12-selenium-superstar/` — a copy of the teacher's reference repo. Reference only, don't edit — if it needs to change, that's a mistake, stop and ask.

## Conventions (match the teacher's reference repo)

- Plain `main()`-driven tests, no JUnit/TestNG.
- `Thread.sleep`-based waits, no explicit/fluent waits.
- No WebDriverManager — driver setup is manual.
- `groupId` stays `org.qspiders.automationwithpiyush`, Selenium pinned to `4.34.0` in `pom.xml`.
- Package names lowercase (`contact`, `oppourtunities`, `browser`), matching existing typos/spelling rather than "fixing" them — these must match the teacher's naming for anything cross-referenced in class.

## Build / run

```
cd CRM_A-12_Selenium
mvn compile
mvn exec:java -Dexec.mainClass="<package>.<ClassName>"
```

There's no test runner (no JUnit) — a test class is "working" only if you've actually run its `main()` and watched the browser do the right thing. Don't report a test as done from reading the code alone.

## Git / push

- `gh` is already authenticated in this environment; plain `git push` works.
- Never use the GitHub MCP connector's file-write tools (`push_files`, `create_or_update_file`) for binaries (the `.xlsx` test-case specs) — they corrupt binary content. Text-only edits are fine either way, but prefer plain `git` for everything.
- This repo has no remote CI — nothing catches a bad push. Don't push without the user's go-ahead.

## Working style

- Update this file when a real mistake happens and the fix is a rule worth keeping — not for routine notes.
