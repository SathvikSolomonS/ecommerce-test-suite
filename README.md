# 🛒 E-Commerce Test Automation Suite

![Java](https://img.shields.io/badge/Java-1.8-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-3.x-blue?style=for-the-badge&logo=apachemaven)
![CI](https://img.shields.io/badge/CI-GitHub_Actions-black?style=for-the-badge&logo=githubactions)

> Selenium-based test automation framework for [SauceDemo](https://www.saucedemo.com) e-commerce platform built with Page Object Model, TestNG, and GitHub Actions CI pipeline.

---

## 📌 Project Structure

```
ecommerce-test-suite/
├── src/
│   ├── main/java/
│   │   └── pages/
│   │       ├── LoginPage.java        ← Login page locators & actions
│   │       ├── InventoryPage.java    ← Product listing page actions
│   │       └── CartPage.java         ← Shopping cart page actions
│   └── test/java/
│       ├── tests/
│       │   ├── LoginTest.java        ← Login test scenarios
│       │   └── CartTest.java         ← Cart test scenarios
│       └── utils/
│           └── basetest.java         ← WebDriver setup & teardown
├── src/test/resources/
│   └── testng.xml                    ← Test suite configuration
├── .github/workflows/
│   └── ci.yml                        ← GitHub Actions CI pipeline
└── pom.xml                           ← Maven dependencies
```

---

## ⚙️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 1.8 | Core programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test framework & annotations |
| Maven | Build tool & dependency management |
| Page Object Model | Design pattern for maintainability |
| GitHub Actions | CI/CD pipeline |

---

## 🎨 Design Pattern — Page Object Model

Each page of the application has its own Java class containing all locators and actions for that page. Test classes only call methods — no locators in tests.

```
LoginPage.java     → handles login UI interactions
InventoryPage.java → handles product browsing
CartPage.java      → handles cart operations
basetest.java      → manages WebDriver lifecycle
```

---

## 🧪 Test Scenarios

### Login Tests (`LoginTest.java`)
| Test Case | Type |
|---|---|
| Valid login with correct credentials | ✅ Positive |
| Login with invalid password | ❌ Negative |
| Login with empty username | ❌ Negative |
| Login with locked out user | ❌ Negative |

### Cart Tests (`CartTest.java`)
| Test Case | Type |
|---|---|
| Add product to cart | ✅ Positive |
| Verify cart item count | ✅ Positive |
| Remove item from cart | ✅ Positive |
| Verify cart persists after navigation | ✅ Positive |

---

## 🚀 How to Run

### Prerequisites
- Java 1.8+
- Maven 3.x
- Google Chrome (latest)

### Run All Tests
```bash
git clone https://github.com/SathvikSolomonS/ecommerce-test-suite.git
cd ecommerce-test-suite
mvn clean test
```

### Run Specific Test
```bash
mvn test -Dtest=LoginTest
mvn test -Dtest=CartTest
```

### Run via TestNG XML
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 🔄 CI/CD Pipeline

This project uses **GitHub Actions** to automatically run tests on every push to the `main` branch.

```yaml
# .github/workflows/ci.yml
# Triggers on every push → builds project → runs all tests
```

✅ Every code push triggers automatic test execution
✅ Test results visible directly in GitHub Actions tab

---

## 🔑 Key Concepts Demonstrated

| Concept | Implementation |
|---|---|
| Page Object Model | `pages/` package — separate class per page |
| Base Test Class | `basetest.java` — WebDriver setup/teardown |
| TestNG Annotations | `@Test`, `@BeforeMethod`, `@AfterMethod` |
| XPath / CSS Locators | Used in all Page classes |
| Explicit Waits | Applied in page interactions |
| CI/CD Integration | GitHub Actions auto-trigger on push |
| Maven Build | `pom.xml` dependency management |

---

## 👤 Author

**Sathvik Solomon S**
- GitHub: [@SathvikSolomonS](https://github.com/SathvikSolomonS)

