package Homework_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(new Student("Sasha", 23, 4.3), new Student("Petr", 24, 5.0), new Student("Vlad", 22, 3.9)));
        try (FileOutputStream fileOut = new FileOutputStream("student.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){

            out.writeObject(students);
            System.out.println("Объект сериализован");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("student.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn)){
            students  = (ArrayList<Student>) in.readObject();
            System.out.println("Объект десериализован");
            for (Student student : students) {
                System.out.println(student);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


}
