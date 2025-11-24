import java.sql.*;
import java.util.*;

public class App {
    public static void main(String[] args) {

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection - UPDATED DATABASE NAME
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/adstudents?useSSL=false", "root", "Root");
                    

            // Prepared statement for inserting data
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student(name, gender, address) VALUES(?,?,?)");

            Scanner sc = new Scanner(System.in);

            // Input and insert 5 student records
            for (int i = 1; i <= 5; i++) {
                System.out.println("\nEnter details of student " + i);

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Gender: ");
                String gender = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                ps.setString(1, name);
                ps.setString(2, gender);
                ps.setString(3, address);

                ps.executeUpdate();
            }

            // Display records in ascending order by name
            System.out.println("\nStudent Records (Name Ascending):");
            System.out.println("==================================");

            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT * FROM student ORDER BY name ASC");

            // Better formatted output
            System.out.printf("%-5s %-20s %-10s %-30s\n", "ID", "Name", "Gender", "Address");
            System.out.println("------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-10s %-30s\n",
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("Address")
                );
            }

            sc.close();
            con.close();

            System.out.println("\nData Inserted Successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}