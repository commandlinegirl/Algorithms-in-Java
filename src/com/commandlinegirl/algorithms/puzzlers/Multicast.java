package com.commandlinegirl.algorithms.puzzlers;

public class Multicast {

/* Test conversions between primitive data types (based on Java Puzzlers by J. Bloch)
 *
 * Java primitive data types 
 * byte - 8-bit, signed
 * short - 16-bit, signed
 * int - 32-bit, signed
 * long - 64-bit, signed 
 * float - single-precision 32-bit IEEE 754 floating point
 * double - single-precision 64-bit IEEE 754 floating point
 * char - 16-bit unicode character, unsigned
 * boolean - true/false; 
 * 
 */

    public static void main(String[] args) {
        System.out.println((int) (char) (byte) -1);

        // Cast int (-1) to byte - narrowing primitive conversion
        System.out.println((byte) -1);

        // Cast byte to char - sign extension occurs if signed type is
        // converted to unsigned. The resulting char has all 16 bits set!
        System.out.println((char) (byte) (-1));
        assert ((char) (byte) (-1)) == Math.pow(2, 16) - 1;

        // Zero extension is performed if the original value is a char,
        // regardless of the target type
        System.out.println((int) (char) (byte) (-1));
        assert ((int) (char) (byte) (-1)) == Math.pow(2, 16) - 1;

        // Compound assignment expression E1 op= E2
        // is equivalent to simple: T E1 = (T) (E1 op E2), and
        // E1 is evaluated only once
        byte x = 0;
        int i = 3333333;
        x += i; // hidden narrowing conversion!
        System.out.println("Unexpected x value after silent conversion to byte: " + x);
        assert x == -43;

        int y = 20;
        double j = 0.5;
        y += j; // hidden cast to int!
        assert y == 20;
        System.out.println("Unexpected y value after silent narrowing cast to int: " + y);

        Object n = "The cat ";
        String m = "is grumpy."; 
        n += m;
        System.out.println(n);
        
        // Widening primitive conversion of a char to an int zero extends char value.
        // Concatenation won't work for non-strings.
        System.out.println("This will print 169: ");
        System.out.println('H' + 'a');
        System.out.printf("Should print Ha: %c%c\n", 'H', 'a');
        System.out.println("2 + 2 = " + 2 + 2);
        System.out.println("" + 'H' + 'a');
        
        // Another way of concatenation chars is using a char array
        char[] chars = new char[]{'A', 'B', 'C'};
        System.out.println(String.valueOf(chars));
        
    }
}
