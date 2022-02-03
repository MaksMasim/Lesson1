package Lesson1DZ.five;

import java.util.Calendar;
import java.util.Random;

public class Dog extends Animal {

        Dog(String name, String colour, int birthYear) {
            super (name, colour, birthYear);
            runLimit = 600 - (int)( Math.random() * 200);
            jumpLimit = 0.7f - (float) Math.random() * 0.3f;
            swimmingLimit = 12 - (int)( Math.random() * 8);
    }
}
