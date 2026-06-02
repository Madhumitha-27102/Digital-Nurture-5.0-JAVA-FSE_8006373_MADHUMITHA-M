import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandling {

    public static void transfer(int fromAcc, int toAcc, double amount) {

        String url = "jdbc:mysql://localhost:3307/studentdb";
        String username = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            con.setAutoCommit(false);

            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";

            PreparedStatement debit = con.prepareStatement(debitQuery);

            debit.setDouble(1, amount);
            debit.setInt(2, fromAcc);

            int debitRows = debit.executeUpdate();

            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";

            PreparedStatement credit = con.prepareStatement(creditQuery);

            credit.setDouble(1, amount);
            credit.setInt(2, toAcc);

            int creditRows = credit.executeUpdate();

            if (debitRows > 0 && creditRows > 0) {
                con.commit();
                System.out.println("Transaction Successful");
            } else {
                con.rollback();
                System.out.println("Transaction Failed");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        transfer(101, 102, 2000);
    }
}