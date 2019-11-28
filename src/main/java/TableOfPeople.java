import java.sql.*;
import java.sql.Date;

public class TableOfPeople {
    public static void addPerson(String name, String lastName, String patronymic, String date) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "asdqwe123");
            String sql = "INSERT INTO people VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, patronymic);
            SplitDate dateOfBirth = new SplitDate(date);
            preparedStatement.setDate(4, new Date(dateOfBirth.getYear() - 1900, dateOfBirth.getMonth() - 1, dateOfBirth.getDay()));
            boolean add = preparedStatement.execute();

            //вывод
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name") + "\t" +
//                        resultSet.getString("last_name") + "\t" +
//                        resultSet.getString("patronymic") + "\t" +
//                        resultSet.getString("date_of_birth"));
//            }
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}