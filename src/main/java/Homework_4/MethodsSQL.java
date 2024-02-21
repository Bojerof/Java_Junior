package Homework_4;

import Seminar_4.modules.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MethodsSQL {
    public void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS coursesDB";
        PreparedStatement statement = connection.prepareStatement(createDatabaseSQL);
        statement.execute();
    }

    public void useDatabase(Connection connection) throws SQLException{
        String useDatabaseSQL = "USE coursesDB";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)){
            statement.execute();
        }
    }

    public void createTable(Connection connection) throws SQLException{
        String createTableSQL = "CREATE TABLE IF NOT EXISTS courses (id INT AUTO_INCREMENT KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }

    public void insertData(Connection connection, Courses courses) throws SQLException{
        String insertDataSQL = "INSERT INTO courses (title, duration) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)){
            statement.setString(1, courses.getTitle());
            statement.setInt(2, courses.getDuration());
            statement.execute();
        }
    }

    public Collection<Courses> readData(Connection connection) throws SQLException{
        ArrayList<Courses> courses = new ArrayList<>();
        String readDataSQL = "SELECT * FROM courses;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int duration = resultSet.getInt("duration");
                courses.add(new Courses(id, title, duration));
            }
            return courses;
        }
    }

    public void updateData(Connection connection, Courses courses) throws SQLException{
        String updateDataSQL = "UPDATE courses SET title=?, duration=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)){
            statement.setString(1, courses.getTitle());
            statement.setInt(2, courses.getDuration());
            statement.setInt(3, courses.getId());
            statement.executeUpdate();
        }
    }

    public void deleteData(Connection connection, int id) throws SQLException {
        String deleteDataSQL = "DELETE FROM courses WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}
