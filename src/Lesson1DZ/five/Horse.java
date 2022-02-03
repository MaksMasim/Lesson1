package Lesson1DZ.five;

import java.util.Random;

public class Horse extends Animal {

    Horse (String name, String colour, int birthYear) {
        super (name, colour, birthYear);
        runLimit = 1700 - (int)( Math.random() * 400);
        jumpLimit = 3.5f - (float) Math.random() * 1f;
        swimmingLimit = 120 - (int)( Math.random() * 40);
    }
}
