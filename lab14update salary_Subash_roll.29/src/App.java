import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swastik?useSSL=false", "root",
                    "Root");
            String updatesql = "UPDATE std SET Salary = (Salary + Salary * 0.15) WHERE Salary < 20000";
            PreparedStatement ps = con.prepareStatement(updatesql);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
