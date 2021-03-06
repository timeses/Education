import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "NEW_PASSWORD";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, (count(course_name) / (max(MONTH" +
                    "(subscription_date)) - min(MONTH(subscription_date)) + 1)) as avg FROM PurchaseList WHERE YEAR" +
                    "(subscription_date) = 2018 GROUP BY course_name;");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String avg = resultSet.getString("avg");

                System.out.println(" Курс - " + courseName + " - AVG subscriptions per month --- " + avg + " шт.");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}