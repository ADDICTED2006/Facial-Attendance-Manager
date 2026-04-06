# 🛠️ Installation & Setup Guide

This guide explains how to get the **Facial Attendance Manager** running on any fresh computer using Visual Studio Code.

## 1. Prerequisites
You need to install the following software before opening the code:

*   **Java Development Kit (JDK 8 or newer):** [Download Here](https://adoptium.net/)
*   **MySQL Community Server (8.0+):** [Download Here](https://dev.mysql.com/downloads/installer/)
*   **Visual Studio Code:** [Download Here](https://code.visualstudio.com/)

---

## 2. Database Setup (Crucial!)
The application relies on a MySQL database to store face signatures, users, and attendance records.

### Step A: Install MySQL
During the MySQL installation, make sure you set the **root password** to `1234`. 
*(If you choose a different password, you must open `src/application/Database.java` and change the `Database_pass` variable to match it).* 

### Step B: Create the Schema
1. Open your **MySQL Command Line Client** (or MySQL Workbench).
2. Login with your password.`
3. Copy the entire contents of the `database_setup.sql` file included in this repository and paste it into the command line to execute it. 
*This automatically creates the `finaldetection` database and builds the `users`, `students`, and `attendance` tables.*

---

## 3. Visual Studio Code Setup
1. Open VS Code.
2. Go to the **Extensions** tab (or press `Ctrl+Shift+X`) and install the **Extension Pack for Java** by Microsoft.
3. Click **File > Open Folder...** and select this project folder.

---

## 4. Building & Running the Project
1. VS Code will detect the `pom.xml` file. A prompt might appear asking if you want to import or synchronize the Java project. Click **Yes** and wait a moment for it to download the Maven dependencies (like OpenCV and MySQL connectors).
2. In the explorer on the left, navigate to: 
   `src` ➔ `application` ➔ `Main.java`
3. Open `Main.java` and click the **Run** button (usually a play button in the top right corner of VS Code, or right-click the file and select "Run Java").

### Default Login Credentials:
*   **Admin Dashboard:** Username: `admin` | Password: `admin123` | Role: `ADMIN`
*   **Teacher/Camera Kiosk:** Username: `teacher` | Password: `teacher123` | Role: `TEACHER`
