import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Date;

public class Aufgabe2Data {
  static String url = "jdbc:mysql://localhost/wwi2021g?&serverTimezone=Europe/Amsterdam";
  static String user = "root";
  static String pw = "";
  public static void main(String[] args) {
    int note;
    String MatrN, kNr, nName, vName, vorlesung, doz, birth, ins1, ins2, ins3;
    Scanner in = new Scanner(System.in);
    System.out.println("Wollen Sie einen Datensatz in die Tabelle Studierende eingeben? (y um zu bestaetigen)");
    String s = in.next();
    if (s.equals("y")) {
      Aufgabe2Data insert1 = new Aufgabe2Data();
      System.out.println("Geben Sie einen Wert fuer die Matrikelnummer ein: ");
      MatrN = in.next();
      System.out.println("Geben Sie einen Wert fuer den Nachnamen ein: ");
      nName = in.next();
      System.out.println("Geben Sie einen Wert fuer den Vornamen ein: ");
      vName = in.next();
      System.out.println("Geben Sie einen Wert fuer das Geburtsdatum ein: (Format:'YYYY-MM-DD'): ");
      birth = in.next();
      ins1 = "insert into studierende values ('" + MatrN + "','" + nName + "','" + vName + "','" + birth + "')";
      insert1.update(ins1);
    }
    System.out.println("Wollen Sie einen Datensatz in die Tabelle Klausur eingeben? (y um zu bestaetigen)");
    String k = in.next();
    if (k.equals("y")) {
      Aufgabe2Data insert2 = new Aufgabe2Data();
      System.out.println("Geben Sie einen Wert fuer die Klausurnummer ein: ");
      kNr = in.next();
      System.out.println("Geben Sie einen Wert fuer den Vorlesungsnamen ein: ");
      vorlesung = in.next();
      System.out.println("Geben Sie einen Wert fuer den Dozenten ein: ");
      doz = in.next();
      ins2 = "insert into klausur values ('" + kNr + "','" + vorlesung + "','" + doz + "')";
      insert2.update(ins2);
    }
    System.out.println("Wollen Sie einen Datensatz in die Tabelle Note eingeben? (y um zu bestaetigen)");
    String n = in.next();
    if (n.equals("y")) {
      Aufgabe2Data insert3 = new Aufgabe2Data();
      System.out.println("Geben Sie einen Wert fuer die Matrikelnummer ein: ");
      MatrN = in.next();
      System.out.println("Geben Sie einen Wert fuer die Klausurnummer ein: ");
      kNr = in.next();
      System.out.println("Geben Sie einen Wert fuer die Note ein: ");
      note = in.nextInt();
      ins3 = "insert into note values ('" + MatrN + "','" + kNr + "','" + note + "')";
      insert3.update(ins3);
    }
  }

  public void update(String sql) {
    try (Connection con = DriverManager.getConnection(url, user, pw);
    Statement stmt = con.createStatement()) {
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
