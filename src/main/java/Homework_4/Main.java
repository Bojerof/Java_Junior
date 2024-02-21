package Homework_4;

import Seminar_4.modules.Student;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MethodsSQL methodsSQL = new MethodsSQL();
        Random random = new Random();
        String url = "jdbc:mysql://localhost:3306/coursesDB";
        String user = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            methodsSQL.createDatabase(connection);
            System.out.println("Database created");

            methodsSQL.useDatabase(connection);
            System.out.println("Use database successfully");

            methodsSQL.createTable(connection);
            System.out.println("Create table successfully");

            int count = random.nextInt(5, 11);
            for (int i = 0; i < count; i++) {
                methodsSQL.insertData(connection, Courses.create());
            }
            System.out.println("Insert data successfully");

            Collection<Courses> courses = methodsSQL.readData(connection);
            for (var course : courses){
                System.out.println(course);
            }
            System.out.println("Read data successfully");

            for (var course : courses) {
                course.updateAge();
                course.updateName();
                methodsSQL.updateData(connection, course);
            }
            System.out.println("Update data successfully");

            for (var course: courses){
                methodsSQL.deleteData(connection, course.getId());
            }

            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
