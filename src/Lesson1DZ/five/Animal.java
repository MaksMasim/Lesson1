package Lesson1DZ.five;

import java.util.Calendar;

public class Animal {
    String name;
    String colour;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int birthYear;
    int age;
    int runLimit;
    float jumpLimit;
    int swimmingLimit;
    int serialNumber = 0;

    Animal(String name, String colour, int birthYear) {
        this.name = name;
        this.colour = colour;
        this.age = currentYear - birthYear;
        this.serialNumber++;
    }
}