import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) {

        String url = "dbc:mysql://localhost:3307/user=root";
        String user = "root";
        String password = "Madhu@2005";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            url, user, password);

            Statement stmt =
                    con.createStatement();

            ResultSet rs =
                    stmt.executeQuery(
                            "SELECT * FROM students");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age"));
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}