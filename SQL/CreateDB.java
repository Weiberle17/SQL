import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost/wwi2021g?&serverTimezone=Europe/Amsterdam";
    String user = "root";
    String pw = "";
    try (Connection con = DriverManager.getConnection(url, user, pw);
    Statement stmt = con.createStatement()) {
      String sql = "create table if not exists artikel (" +
      "id integer primary key, " +
      "name text, " +
      "preis real, " +
      "menge integer)";
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
