package School;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String registration;
    private List<Integer> grades = new ArrayList<>();
    private boolean aproved;

    public Student(String name, String registragion) {
        this.name = name;
        this.registration = registragion;
    }

    public boolean isAproved() {
        return aproved;
    }

    public void setAproved(boolean aproved) {
        this.aproved = aproved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", registration=" + registration + ", grades=" + grades + "]";
    }
}