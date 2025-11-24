import java.sql.*;
import java.util.Scanner;

public class StudentDatabase {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/adstudents?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Root";
    
    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to database successfully!\n");
            
            // Create table
            createStudentTable(connection);
            
            // Insert record using PreparedStatement
            insertStudentRecord(connection, scanner);
            
            // Display all records
            displayAllStudents(connection);
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (connection != null) {
                    connection.close();
                }
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Method to create tblStudent table
    private static void createStudentTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS tblStudent (" +
                                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                "name VARCHAR(100) NOT NULL, " +
                                "email VARCHAR(100) UNIQUE NOT NULL" +
                                ")";
        
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'tblStudent' created/verified successfully!");
        }
    }
    
    // Method to insert student record using PreparedStatement
    private static void insertStudentRecord(Connection connection, Scanner scanner) throws SQLException {
        String insertSQL = "INSERT INTO tblStudent (name, email) VALUES (?, ?)";
        
        System.out.println("Enter Student Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " record(s) inserted successfully!\n");
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Duplicate entry error
                System.out.println("Error: Email already exists!");
            } else {
                throw e;
            }
        }
    }
    
    // Method to display all student records
    private static void displayAllStudents(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM tblStudent";
        
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            
            System.out.println("Student Records in tblStudent:");
           
            System.out.printf("%-5s %-20s %-30s\n", "ID", "Name", "Email");
            
            
            boolean hasRecords = false;
            while (resultSet.next()) {
                hasRecords = true;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                
                System.out.printf("%-5d %-20s %-30s\n", id, name, email);
            }
            
            if (!hasRecords) {
                System.out.println("No records found in the table.");
            }
            
        }
    }
}