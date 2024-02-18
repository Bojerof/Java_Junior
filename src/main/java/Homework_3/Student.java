package Homework_3;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    //данное ключевое слово не даёт сериализовать средний балл, а так же считать обратно
    transient double GPA;


    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return String.format("Имя %s, Возраст %d, средний балл %.2f", getName(), getAge(), getGPA());
    }
}
