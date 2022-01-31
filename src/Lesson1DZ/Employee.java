package Lesson1DZ;

public class Employee {
    private static int serialNumber = 0;
    private int numberID;
    private String name;
    private int salary;
    private int age;

    public Employee () {
        serialNumber++;
        this.numberID = serialNumber;
    }
    public Employee (String name, int salary, int age) {
        serialNumber++;
        this.numberID = serialNumber;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getNumberID() {
        return numberID;
    }
    public String getName () {
        return name;
    }
    public int getSalary () {
        return salary;
    }
    public int getAge () {
        return age;
    }

    public void setSalary (int salary) {
        this.salary = salary;
    }
}