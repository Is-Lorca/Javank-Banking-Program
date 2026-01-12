# JAVANK – Banking Simulation (Java) 🏦

A simple console-based **banking system simulation** written in Java.  
JAVANK (Java + Bank) was created to practice core Java concepts such as methods, conditionals, loops, user input handling, and basic program flow control.

---

## 💻 Technologies Used

- Java
- `Scanner` class for user input
- `ProcessBuilder` for console screen clearing
- Console output with `System.out.printf`
- Basic exception handling (`IOException`, `InterruptedException`)

---

## 📚 Project Purpose

This project was developed to practice and reinforce:

- Programming logic
- Java syntax and structure
- Methods and return values
- Conditional statements (`if/else`, `switch`)
- Loops (`do/while`)
- User input validation
- Basic authentication logic
- Console-based UI organization
- Simulating real-world systems (banking operations)

It is part of my personal Java learning portfolio and represents my progress in understanding fundamental Java concepts.

---

## ▶️ How It Works

1. The program starts by displaying a welcome logo.
2. The user enters their name.
3. The user creates a **4-digit numeric password**.
4. After validation, the main menu is displayed.
5. Before performing any banking operation, the user must confirm their password.
6. The menu offers the following options:
   - Show balance
   - Deposit money
   - Withdraw money
   - Exit the system
7. The program runs in a loop until the user chooses to exit.

---

## 📌 Features

- User authentication with a 4-digit password
- Password verification before sensitive operations
- Limited password attempts for security
- Balance display with formatted currency output
- Deposit system with a maximum limit of 10,000
- Withdrawal system with balance validation
- Simulated processing time using `Thread.sleep`
- Console screen clearing compatible with:
  - Windows
  - Linux
  - macOS
- Simple and organized console interface

---

## 🚀 How to Run

1. Make sure you have Java installed on your system.
2. Clone this repository.
3. Compile the program:
    ```
    javac Main.java
    ```
4. Run the program:
    ```
    java Main
    ```

---

## 📝 Notes

This project focuses on clarity, structure, and logic rather than advanced Java features.  
The goal was to simulate a basic banking system while strengthening fundamental Java skills using a clean and readable console-based approach.
