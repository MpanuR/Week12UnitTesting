//creat a package called com.promineotech in the src\main\java folder
package com.promineotech;

import java.util.Random;

public class TestDemo {
    // create an instanct method named add positive.
    public int addPositive(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
        return a + b;
    }

    public String printString(String a) {
        if (a == null) {
            throw new IllegalArgumentException("String cannot be null!");
        }
        return a;
    }

    public int randomNumberSquared() {

        return getRandomInt() * getRandomInt();
    }

    int getRandomInt() {
        Random random = new Random(); // create a random object
        return random.nextInt(10) + 1; // return a random number between 1 and 10

    }

}
