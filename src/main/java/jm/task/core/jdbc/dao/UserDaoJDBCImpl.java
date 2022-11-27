package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    //private final Util util = new Util();

    public void createUsersTable() {
        /*String sql = """
                CREATE TABLE `SchemaOne`.`Users` (
                  `id` INT NOT NULL AUTO_INCREMENT,
                  `name` VARCHAR(45) NOT NULL,
                  `lastname` VARCHAR(45) NOT NULL,
                  `age` INT(3) NOT NULL,
                  PRIMARY KEY (`id`));""";
        PreparedStatement preparedStatement = null;
        try (Connection connection = util.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }

    public void dropUsersTable() {
        /*String sql = "DROP TABLE IF EXISTS Users;";
        PreparedStatement preparedStatement = null;
        try (Connection connection = util.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }

    public void saveUser(String name, String lastName, byte age) {
        /*String sql = "INSERT INTO Users (name, lastname, age) values (?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try (Connection connection = util.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,age);
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }

    public void removeUserById(long id) {
        /*String sql = "DELETE FROM Users WHERE  id = ?;";
        PreparedStatement preparedStatement = null;
        try (Connection connection = util.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

    }

    public List<User> getAllUsers() {
        /*List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM Users;";
        PreparedStatement preparedStatement = null;
        try (Connection connection = util.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return null;
    }

    public void cleanUsersTable() {
        /*String sql = "TRUNCATE TABLE Users;";
        PreparedStatement preparedStatement = null;
        try (Connection connection = util.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }
}
