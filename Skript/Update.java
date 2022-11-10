import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost/wwi2021g?&serverTimezone=Europe/Amsterdam";
    String user = "root";
    String pw = "";
    try (Connection con = DriverManager.getConnection(url, user, pw);
    Statement stmt = con.createStatement()) {
      String sql1 =
      "update artikel set preis = 4. where id = 4711";
      String sql2 = "update artikel set menge = menge + 5 " +
      "where id = 4712 or id = 4714";
      stmt.executeUpdate(sql1);
      stmt.executeUpdate(sql2);
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
