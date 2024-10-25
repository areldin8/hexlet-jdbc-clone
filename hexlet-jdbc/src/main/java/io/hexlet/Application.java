package io.hexlet;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;


public class Application {
    public static void main(String[] args) {
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet_test")) {
            var createTableSql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
            try (var statement = conn.createStatement()) {
                statement.execute(createTableSql);
            }

            UserDAO userDAO = new UserDAO(conn);

            // Создание нового пользователя
            User user = new User("Sarah", "333333333");
            userDAO.save(user);
            System.out.println("User created with ID: " + user.getId());

            // Поиск пользователя по ID
            Optional<User> foundUser = userDAO.find(user.getId());
            foundUser.ifPresent(u -> {
                System.out.println("Username: " + u.getName());
                System.out.println("Phone: " + u.getPhone());
            });

            // Удаление пользователя
            userDAO.delete(user.getId());
            System.out.println("User with ID " + user.getId() + " deleted.");

            // Проверка, что пользователь удалён
            Optional<User> deletedUser = userDAO.find(user.getId());
            if (deletedUser.isEmpty()) {
                System.out.println("User with ID " + user.getId() + " was successfully deleted.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
