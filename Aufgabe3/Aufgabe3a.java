import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost/wwi2021g?&serverTimezone=Europe/Amsterdam";
    String user = "root";
    String pw = "";
    try (Connection con = DriverManager.getConnection(url, user, pw);
    Statement stmt = con.createStatement()) {
      String sql = "select avg(note) from note";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println("Der Durchschnitt der Noten ist: " + rs.getInt(1));
      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
