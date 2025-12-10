package vn.io.tunaa.dsa.week2.sorting.example;

public class Student implements Comparable {
     private String name;
     private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student[name=" + name + ",score=" + score + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object another) {
        return Double.compare(getScore(), ((Student) another).getScore());
    }
}
