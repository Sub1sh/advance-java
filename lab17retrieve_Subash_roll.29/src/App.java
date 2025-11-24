import java.sql.*; import java.util.Scanner; public class App {     public static void main(String[] args) {         try (Connection con = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/swastik?useSSL=false","root","Root"); 
             Scanner sc = new Scanner(System.in)) { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            System.out.print("Enter Employee ID to update: ");             int id = sc.nextInt(); sc.nextLine(); 
            PreparedStatement ps = con.prepareStatement( 
                    "SELECT * FROM emp WHERE id=?", 
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE 
            ); 
            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery(); 
     if(rs.next()) { 
                System.out.println("Current Name: " + rs.getString("name"));                 System.out.print("Enter new name: ");                 rs.updateString("name", sc.nextLine());                 rs.updateRow(); 
                System.out.println("Record updated successfully."); 
            } else System.out.println("Employee with ID " + id + " not found.");         } catch (Exception e) { System.out.println(e.getMessage()); } 
    } 
} 
