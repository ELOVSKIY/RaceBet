package model.database.dao;

import entities.User;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

    @Override
    public void updateUser(long userId, User user) {

    }

    @Override
    public void registerUser(User user) {
        final String url = "jdbc:mysql://localhost:3306/racebet?useUnicode=true&serverTimezone=UTC";
        final String userName = "root";
        final String password = "Nosa125123456789";
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try (final Connection connection = DriverManager.getConnection(url, userName, password)) {
            final Statement statement = connection.createStatement();
            final String query = new StringBuilder("INSERT INTO user (Name, Surname, Login, Password, Role) VALUES (")
                    .append("'").append(user.getName()).append("',")
                    .append("'").append(user.getSurname()).append("',")
                    .append("'").append(user.getLogin()).append("',")
                    .append("'").append(user.getPassword()).append("',")
                    .append("'").append("Boss');").toString();
            statement.execute(query);
            System.out.println("Got it!");
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

    @Override
    public User getUserById(User user) {
        return null;
    }
}
