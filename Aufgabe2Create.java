import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe2Create {
    static String sql1 = "create table if not exists studierende (" +
    "MatrN int unique," +
    "nName text," +
    "vName text," +
    "birth date," +
    "primary key(MatrN))";
    static String sql2 = "create table if not exists klausur (" + 
    "kNr int unique," +
    "vorlesung VARCHAR(25)," +
    "doz VARCHAR(25)," +
    "primary key(kNr))";
    static String sql3 = "create table if not exists note (" +
    "MatrN int," +
    "kNr int," +
    "note int," +
    "primary key(MatrN, kNr))";
  public static void main(String[] args) {
    Aufgabe2Create studierende = new Aufgabe2Create();
    Aufgabe2Create klausur = new Aufgabe2Create();
    Aufgabe2Create note = new Aufgabe2Create();
    studierende.createDB(sql1);
    klausur.createDB(sql2);
    note.createDB(sql3);
  }
  public void createDB(String sql) { 
    String url = "jdbc:mysql://localhost/wwi2021g?&serverTimezone=Europe/Amsterdam";
    String user = "root";
    String pw = "";
    try (Connection con = DriverManager.getConnection(url, user, pw);
    Statement stmt = con.createStatement()) {
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
//    "foreign key(MatrN) references studierende," + "foreign key(kNr) references klausur)";
