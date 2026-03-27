# Assignment 1: Hello Kotlin. Hello Mobile Android World!

Course: Computação Móvel
Student(s): Ana Espinha
Date: 20/03/2026
Repository URL: https://github.com/amargaridaespinha/cmrm.git

---

## 1. Introduction
This assignment explored Kotlin programming and object-oriented concepts through practical exercises. The work included implementing a **Virtual Library system**, completing several Kotlin exercises (exer1, exer2, exer3), and developing **basic Android Studio applications** to gain hands-on experience in mobile development. AI tools were used to provide guidance, suggestions, and debugging support.

## 2. System Overview
The repository contains:  
- **Kotlin Exercises**: exer1, exer2, exer3, and a Virtual Library project with classes for managing books and library operations.  
- **Android Projects**: HelloWorld and SystemInfo, demonstrating basic Android app development and UI.  

Main features include:  
- Kotlin classes with inheritance and encapsulation.  
- Virtual Library management system with book borrowing/returning.  
- Android apps with basic UI and activity management.  

## 3. Architecture and Design
- **Folder Structure:**
CM_TP1/
├─ AndroidStudio/
│ ├─ HelloWorld/
│ └─ SystemInfo/
│ └─ Decide/
├─ Kotlin/
│ ├─ exer1/
│ ├─ exer2/
│ ├─ exer3/
│ └─ virtual_library/
└─ README.md

- Design choices:  
  - Object-oriented principles for Kotlin projects.  
  - Modular Android project structure.  
  - Clear separation between exercises and Android apps.  

## 4. Implementation
- **Kotlin Virtual Library**:  
  - Abstract `Book` class with subclasses `DigitalBook` and `PhysicalBook`.  
  - `Library` class managing collections with add, borrow, return, and search functions.  
  - Custom getters/setters and companion object for total book tracking.  
  - Data class `LibraryMember` for user management.  

- **Android Projects**:  
  - HelloWorld: basic app showing a text label.  
  - SystemInfo: app displaying device info using UI components and activities.
  - Decide: app assisting decision-making.

## 5. Testing and Validation
- Kotlin: manually tested borrowing, returning, and searching books in Virtual Library.  
- Edge cases handled: zero available copies, invalid searches.  
- Android: apps tested on emulator; UI and navigation verified.  

## 6. Usage Instructions
- **Kotlin**: run `main` functions in each exercise folder to see output.  
- **Virtual Library**: run `exer_vl.kt` to simulate library operations.  
- **Android**: open projects in Android Studio and run on emulator or device.  

---

# Autonomous Software Engineering Sections

## 7. Prompting Strategy
Used ChatGPT to clarify assignment requirements, suggest Kotlin class structures, and generate sample implementations. Prompts were iterative, refining code for correctness and clarity. Assistance applied both to the **Virtual Library project** and other **Kotlin exercises (exer1, exer2, exer3)**.

## 8. Autonomous Agent Workflow
ChatGPT contributed to:  
- Planning Kotlin class structures and project organization.  
- Debugging Kotlin code and Virtual Library logic.  
- Suggesting approaches for Android projects.  
- Explaining Git and GitHub operations.  
- Drafting README.md content.

## 9. Verification of AI-Generated Artifacts
- Manual review of all code.  
- Ran Kotlin programs to ensure expected output.  
- Cross-checked Android projects in Android Studio.

## 10. Human vs AI Contribution
- Human: wrote actual code, structured projects, tested outputs, finalized README.  
- AI-assisted: explanations, suggestions, and example snippets to guide implementation.
- The final task to generate a full application entirely using AI **was not completed**.

## 11. Ethical and Responsible Use
All AI-generated suggestions were manually reviewed to ensure correctness, completeness, and adherence to assignment requirements.

---

# Development Process

## 12. Version Control and Commit History
- Git used for all project versions.  
- Frequent commits reflect continuous work: exercise completion, Virtual Library development, Android projects.

## 13. Difficulties and Lessons Learned
- Challenges with GitHub organization and branch management.  
- Learned Kotlin OOP concepts, Virtual Library implementation, and project structuring.  
- Experienced difficulties with Android Studio and IntelliJ IDEA: the IDEs can be unintuitive at times, and occasional errors or glitches slowed down development.  
- Learned to troubleshoot issues with IDEs, Git, and project configurations, improving problem-solving skills.

## 14. Future Improvements
- Enhance Virtual Library with UI or database support.  
- Expand Android apps with more functionality and improved UI.

## 15. AI-Assisted Decision-Making App

An AI-assisted project was developed to create a **Decision-Making Android app** using Kotlin, Android Studio, and Material Design 3. The app helps users decide what to eat, watch, or do and keeps a history of decisions.

### 15.1 Features
- **Single screen** (MainActivity) with buttons for categories:
  - "O que comer?"
  - "O que ver?"
  - "O que fazer?"
- **Decision logic** handled in a `DecisionViewModel`.
- **Random selection** from predefined lists for each category.
- **History tracking** using a RecyclerView in a separate `HistoryActivity`.
- Clean and simple UI with animations for results display.

### 15.2 Architecture
- **MVVM pattern** (simple version) to separate UI and logic:
  - `DecisionViewModel` holds categories, results, and history.
  - `MainActivity` observes the ViewModel for category changes and decisions.
  - `HistoryActivity` displays past decisions passed via Intent.
- RecyclerView adapter for dynamic history display.

### 15.3 Implementation Details
- Kotlin `ViewModel` tracks:
  - `_currentCategory`: currently selected category.
  - `_result`: most recent decision.
  - `_history`: list of past decisions.
- MainActivity:
  - Buttons change category and trigger decision.
  - Animation used for fading in/out results.
  - History button opens HistoryActivity with past decisions.
- HistoryActivity:
  - Receives decision history via Intent.
  - Displays a list using RecyclerView.
  - Shows placeholder text if no history is available.

### 15.4 AI Contribution
- AI suggested:
  - Kotlin class structures (`ViewModel`, adapters).
  - Android UI layout and Material Design usage.
  - Correct handling of history sharing between activities.
  - Debugging tips for crashes and common Android errors.
- Human contribution:
  - Integrated AI suggestions into working app.
  - Fixed bugs related to history passing and decision logic.
  - Tested app on emulator to ensure functionality.

### 15.5 Known Issues and Improvements
- Initial versions had all decisions defaulting to "Bacalhau" due to category mismatches.
- History display initially broke because ViewModel instances were separate.
- Improvements made:
  - Corrected category keys in ViewModel.
  - Passed history via Intent to maintain consistency between activities.
  - Cleaned UI and animations.
- Future improvements:
  - Add database persistence for history.
  - Allow user-defined decision options.
  - Improve animations and Material Design components.  

---

## 16. AI Usage Disclosure (Mandatory)
- **Tools**: ChatGPT.  
- **Usage**: guided class design, project organization, and README drafting.  
- **Responsibility**: all submitted code and documentation reviewed and verified by me.
