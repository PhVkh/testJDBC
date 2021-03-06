import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("d.MM.yyyy"));
            LocalDate dateOfBirth = LocalDate.parse(date, formatter);
            preparedStatement.setDate(4, Date.valueOf(dateOfBirth));

            boolean add = preparedStatement.execute();
            preparedStatement.close();

            //вывод
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + "\t" +
                        resultSet.getString("last_name") + "\t" +
                        resultSet.getString("patronymic") + "\t" +
                        resultSet.getString("date_of_birth"));
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}