# 📦 Inventory Audit & Logging System

A real-time inventory management system with automated database audit logging using MySQL Triggers and Views.

## ✨ Features
- **Automated Logging**: Every `INSERT` and `UPDATE` on the products table is automatically recorded in an `audit_log` table via database triggers.
- **Activity Reports**: A daily activity summary generated using a MySQL View.
- **Premium UI**: Modern dashboard with glassmorphism, smooth animations, and a responsive layout.
- **Real-time Updates**: The dashboard polls for new logs every 5 seconds.

## 🚀 Setup Instructions

### 1. Prerequisites
- **XAMPP** (or any LAMP/WAMP stack) installed.
- Modern Web Browser (Chrome, Firefox, Edge).

### 2. Database Configuration
1. Open **XAMPP Control Panel** and start **Apache** and **MySQL**.
2. Go to [http://localhost/phpmyadmin](http://localhost/phpmyadmin).
3. Create a new database named `inventory_audit_db`.
4. Click on the database, go to the **SQL** tab.
5. Copy the contents of `schema.sql` from this project and paste them into the SQL box.
6. Click **Go** to execute. This will create the tables, triggers, and views.

### 3. Running the Application
1. Move the project folder to your XAMPP installation directory (usually `C:\xampp\htdocs\`).
2. Rename the folder to `inventory-audit`.
3. Open your browser and visit: `http://localhost/inventory-audit/index.html`

## 📂 Project Structure
- `index.html`: Main dashboard interface.
- `style.css`: Premium styling and layout.
- `script.js`: Frontend logic and API integration.
- `api.php`: Backend endpoints for database operations.
- `db.php`: Database connection configuration.
- `schema.sql`: SQL script for database setup.

## 🛠️ Built With
- **Frontend**: HTML5, CSS3 (Glassmorphism), JavaScript (ES6+).
- **Backend**: PHP (PDO).
- **Database**: MySQL (Triggers, Views).

---

## 🚀 How to Upload to GitHub

1. **Create a Repository**:
   - Go to [GitHub](https://github.com/) and create a new repository (e.g., `inventory-audit-logging`).
   - Keep it "Public".

2. **Initialize Git**:
   - Open VS Code Terminal or Command Prompt in your project folder.
   - Run the following commands:
   ```bash
   git init
   git add .
   git commit -m "Initial commit: Automated Logging System"
   ```

3. **Link and Push**:
   - Copy the remote URL from your GitHub repository page.
   - Run:
   ```bash
   git remote add origin YOUR_REPOSITORY_URL
   git branch -M main
   git push -u origin main
   ```

4. **Verify**:
   - Refresh your GitHub page to see your files!
