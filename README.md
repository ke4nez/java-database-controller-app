# Java Database Management App for PL/SQL Database

This Java project is a command-line application for managing a remote PL/SQL database, offering essential CRUD functionality along with specialized operations tailored for specific database tables. Built for IDE-based execution, the app does not include a graphical interface.

### Features
- **CRUD Operations**: Supports Create, Read, Update, and Delete operations across tables.
- **Table-Specific Commands**: Provides additional, specific operations for certain tables.
- **Remote PL/SQL Integration**: Connects to a PL/SQL database hosted on a remote server.
- **IDE-Based Execution**: Intended to be executed within an IDE, with no standalone interface.

### Requirements
- **Java**: Version 8 or higher
- **JDBC Driver for Oracle**: Ensure the appropriate JDBC driver is installed for PL/SQL connections.
- **IDE**: Compatible with IntelliJ IDEA, Eclipse, or other Java IDEs.
- **Database Access**: Configure the PL/SQL server for remote access with necessary permissions.

### Getting Started
1. **Open the Project in an IDE**: Clone or download the repository, then load it in your IDE.
2. **Set Up Database Connection**: Update the JDBC connection string in the configuration file to connect to your PL/SQL database on the remote server.
3. **Execute Commands**:
   - **CRUD Operations**: Use CRUD methods to manage data in the database.
   - **Table-Specific Operations**: Access specialized commands for particular tables.

### Database Setup
Refer to `documentation.pdf` in the `/documentation` folder for SQL `CREATE TABLE` scripts needed to define the database structure. The ER model, represented through SQL table definitions, provides full schema details and required data types.

### Documentation
The `/documentation` folder contains:
- **ER Model in SQL**: SQL `CREATE TABLE` statements for all required tables.
- **Conceptual and Relational Schemas**: Conceptual and relational schemas illustrate the table structure and relationships, serving as a detailed guide for understanding the database organization.
