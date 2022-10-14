import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost/wwi2021g?&serverTimezone=Europe/Amsterdam";
    String user = "root";
    String pw = "";
    try (Connection con = DriverManager.getConnection(url, user, pw);
    Statement stmt = con.createStatement()) {
      String sql = "delete from artikel where id = 4713";
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
