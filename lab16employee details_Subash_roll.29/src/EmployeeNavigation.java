import java.sql.*;

public class EmployeeNavigation {
    public static void main(String[] args) { 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/swastik?useSSL=false", "root", "Root"); 
            
            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY
            ); 
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM emp"); 
            
            // First record
            if(rs.first()) {
                System.out.println("First: " + rs.getInt("id") + " " + 
                    rs.getString("name") + " " + rs.getDouble("salary")); 
            }
            
            // Last record
            if(rs.last()) {
                System.out.println("Last: " + rs.getInt("id") + " " + 
                    rs.getString("name") + " " + rs.getDouble("salary")); 
            }
            
            // Previous record (from last position)
            if(rs.previous()) {
                System.out.println("Previous: " + rs.getInt("id") + " " + 
                    rs.getString("name") + " " + rs.getDouble("salary")); 
            }
            
            // Next record (from previous position)
            if(rs.next()) {
                System.out.println("Next: " + rs.getInt("id") + " " + 
                    rs.getString("name") + " " + rs.getDouble("salary")); 
            }
            
            // Additional navigation examples
            System.out.println("\n--- Additional Navigation ---");
            
            // Move to first record again
            rs.first();
            System.out.println("Back to First: " + rs.getInt("id") + " " + 
                rs.getString("name") + " " + rs.getDouble("salary"));
            
            // Move to absolute position 2
            if(rs.absolute(2)) {
                System.out.println("Absolute(2): " + rs.getInt("id") + " " + 
                    rs.getString("name") + " " + rs.getDouble("salary"));
            }
            
            // Display all records
            System.out.println("\n--- All Records ---");
            rs.beforeFirst(); // Move before first record
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + 
                    rs.getString("name") + ", Salary: " + rs.getDouble("salary"));
            }
            
            con.close(); 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage()); 
        } 
    } 
}