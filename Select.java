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
      String sql = "select id, name, menge, preis from artikel order by preis desc";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.printf("%4d %-15s %4d %8.2f%n",
          rs.getInt(1),
          rs.getString(2),
          rs.getInt(3),
          rs.getDouble(4));
      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
