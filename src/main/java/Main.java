import DAO.MySQLConnection;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Chạy ứng dụng chính...");
        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.openConnection();
    }
}