import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class StudentDAO {

    String url = "jdbc:mysql://localhost:3306/studentdb";
    String username = "root";
    String password = "Akshaya.Vijay_2k@4";

    public void insertStudent(int id, String name, int age) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();

            System.out.println(rows + " record inserted.");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudent(int id, String name) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "UPDATE students SET name=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " record updated.");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class StudentDAOExample {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.insertStudent(104, "Ram", 22);

        dao.updateStudent(104, "Arun");
    }
}
