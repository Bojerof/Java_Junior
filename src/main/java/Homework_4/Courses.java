package Homework_4;

import Seminar_4.modules.Student;

import java.util.Random;

public class Courses {
    private static final String[] titles = new String[]{"Математика", "Русский", "Физика", "Химия", "География", "Биология", "История", "Литература"};
    private static final Random random = new Random();

    private int id;
    private String title;
    private int duration;

    public Courses(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Courses(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static Courses create(){
        return new Courses(titles[random.nextInt(titles.length)], random.nextInt(80, 140));
    }

    public void updateAge(){
        duration = random.nextInt(20, 26);
    }

    public void updateName(){
        title = titles[random.nextInt(titles.length)];
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
