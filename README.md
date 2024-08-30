<!-- # 212-Assignments

As part of your assignment this semester, you are required to develop a Car Leasing System.

## Branches
- Main branch is the latest version
- Every other branch is the updated version of the previous branch according to required tasks for that particular assignment -->

# Car Leasing System

## Overview

This repository contains a Car Leasing System developed for CSE-212 Software Development Methodologies, Fall 2022. The progression of development is shown through the branches, with each branch reflecting a different assignment. The main branch contains the final, fully functional system with a graphical user interface.

## Features

- **Create New Lease**: Allows users to create a new lease, including options for ordinary, short-term, and long-term leases.
- **Display Leases**: Displays all leases sorted by the car's model year, with options for ascending or descending order.
- **Display Lease Price**: Calculates and displays the price for a specific lease based on the owner's ID.
- **Calculate Insurances**: Displays insurance costs for leased cars and extra services.

## Commands

1. **Create New Lease**: 
   - Creates a new lease with monthly billing.
   - Prompts for lease details such as owner ID, model year, brand/model, lease start/end dates, and optional extra services.

2. **Create New Short Term Lease**: 
   - Creates a short-term lease with daily billing.

3. **Create New Long Term Lease**: 
   - Creates a long-term lease with yearly billing.

4. **Display All Leases Sorted by Car Model Year**: 
   - Shows all leases, sorted by car model year in either ascending or descending order.

5. **Display Lease Price**: 
   - Prompts for a lease owner ID and displays the total lease price including any extra services.

6. **Calculate Insurances**: 
   - Calculates and displays insurance costs for both leased cars and extra services.

7. **Exit**: 
   - Terminates the application.

## Branches

- **`main`**: Final version of the Car Leasing System with all features integrated.
- **`assignment-1`**: Initial system setup with basic lease creation and display functionality.
- **`assignment-2`**: Introduction of the `Car` class and integration with the lease system.
- **`assignment-3`**: Enhanced pricing functionality based on car’s model year.
- **`assignment-4`**: Addition of `ExtraServices` class and functionality for optional services.
- **`assignment-5`**: Implementation of lease comparison and exception handling.
- **`assignment-6`**: Integration of Java Swing GUI for user-friendly interaction.

## Usage

1. **Clone the Repository**
```bash
git clone https://github.com/yourusername/CarLeasingSystem.git
```
3. Navigate to the Desired Branch
```bash
git checkout assignment-x
```
3. Compile and Run
```bash
javac *.java
java Menu
```

## Licence
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
