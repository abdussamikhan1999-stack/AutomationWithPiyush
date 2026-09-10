# A12-selenium-superstar

Topic-organized Selenium exercises from the course, mirrored from [`AutomationWithPiyushhh/A12-selenium-superstars`](https://github.com/AutomationWithPiyushhh/A12-selenium-superstars) for local reference alongside [`CRM_A-12_Selenium`](../CRM_A-12_Selenium), my own project built on the same conventions.

## Topics covered

| Package | Covers |
|---|---|
| `initial_days` | First WebDriver script — title, URL, page source |
| `manage_methods` | `driver.manage().window()` — resize, position, maximize |
| `methods_of_webelement` | Core `WebElement` methods (Instagram example) |
| `search_context_methods` | Locator strategies, dynamic XPath/CSS expressions |
| `working_with_actions` | The `Actions` class — hover, drag, keyboard actions (Facebook, Zomato, YonoSBI, GlobalsQA, Slider) |
| `working_with_dropdown` | `Select` class for single-select dropdowns (Bollywood, Facebook) |
| `working_with_iframes` | Switching into/out of iframes |
| `working_with_javascriptexecutor` | `JavascriptExecutor` for scrolling, clicking, value injection |
| `working_with_popups` | Alerts, JS popups, file upload dialogs (native + Robot + AutoIt), Windows notifications |
| `working_with_screenshots` | Capturing screenshots with `TakesScreenshot` |
| `working_with_synchronization` | Implicit/explicit/fluent waits |
| `working_with_window_handling` | Multi-window/tab handling via window handles |
| `src/test/java/html` | Local HTML fixtures used by some of the above exercises |

## Prerequisites

- JDK 11+ and Maven
- Internet access (most exercises target live sites — Facebook, Instagram, Zomato, YonoSBI — so behavior can drift if those sites change their UI)
- On Windows, the file-upload exercises under `working_with_popups` and `src/test/resources` (`uploadFile.exe`, `uploadFile.au3`) rely on [AutoIt](https://www.autoitscript.com/) to drive the native OS file dialog

## Running an exercise

Each class is a standalone `main()` — no test runner:

```bash
mvn test-compile exec:java -Dexec.mainClass="working_with_actions.FaceBook" -Dexec.classpathScope=test
```

Or import into Eclipse (`.project` / `.classpath` included) and Run As → Java Application on the class.

## Source

This is a working copy for local reference and coursework — the canonical, actively updated version is [AutomationWithPiyushhh/A12-selenium-superstars](https://github.com/AutomationWithPiyushhh/A12-selenium-superstars).
