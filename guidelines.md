
## Project Guidelines

### 1. Folder Structure

```
├───app
    └───src
        └───main
            └───java
                └───konbini
                        ├───models
                        └───services
```
* **

### 2. Naming Conventions
* **Classes**: `PascalCase` → `
* **Variables/Methods**: `camelCase`
* **Constants**: `UPPER_CASE`

### 3. Branching & Git Workflow
* **Main Branch** → always stable, working code
* **Feature Branches** →

  * `feature/<text1>-<text2>`

* **General Commit Messages** (use short prefixes):

  * `chore(repo): initialize jfx/swing project, gitignore, formatter`
  * `docs(readme): add project overview and run instructions`
  * `feat(core): add base packages and empty class stubs per UML`
  * `test(core): add placeholder test suites per package`
---
#### 3.1 Example Commit Messages
  * `feat(product): implement Product fields, ctor overloads, getters/setters`
  * `feat(category): implement Category with subcategories and product list`
  * `feat(shelf): add ShelfLocation entity and link to Product`
  * `feat(inventory): implement Inventory collections and relationships` 
  * `feat(employee): implement Employee with validation helpers` 
  * `feat(customer): implement Customer (membership, points, login)`


#### 3.2 Types of Commit Messages
  * `feat:` → new feature or class implementation
  * `fix:` → bug fixes or logic correction
  * `refactor:` → code cleanup or structure changes
  * `chore:` → non-code or organization tasks (file moves, docs, guidelines)
  * `docs:` → documentation updates


---

### 4. Documentation

* Each variable → short comment describing purpose
* Each class → short comment describing purpose
* Each method → detailed doc comment
* All documentations will be done in Javadoc format

Example:

```java
/**
 * Calculates total tax
 * 
 * @param permit *parameter description*
 * @return *returned object description*
 */
public double calculateTotalTax(Total total) { ... }
```

Created by Leon Pavino (last updated @ 2:26 AM - 10/20/2025)