package Lesson1DZ.five;

import java.util.Random;

public class Cat extends Animal {

    Cat (String name, String colour, int birthYear) {
        super (name, colour, birthYear);
        runLimit = 230 - (int)( Math.random() * 60);
        jumpLimit = 2.3f - (float) Math.random() * 0.6f;
        swimmingLimit = 0;
    }
}
