package Lesson1DZ.five;

import java.util.Random;

public class Bird extends Animal {

    Bird (String name, String colour, int birthYear) {
        super (name, colour, birthYear);
        runLimit = 6 - (int)( Math.random() * 2);
        jumpLimit = 250f - (float)(Math.random() * 30f);
        swimmingLimit = 0;
    }
}
