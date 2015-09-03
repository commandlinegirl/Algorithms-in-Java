public class Multicast {

/* Test conversions between primitive data types.
 *
 * Java primitive data types 
 * byte - 8-bit, signed
 * short - 16-bit, signed
 * int - 32-bit, signed
 * long - 64-bit, signed 
 * float - single-precision 32-bit IEEE 754 floating point
 * double - single-precision 64-bit IEEE 754 floating point
 * char - 16-bit unicode character, unsigned
 * boolean - true/false; min value of '\u0000' (or 0); maximum value of '\uffff' (or 65,535 inclusive)
 */

    public static void main(String[] args) {
        // Example from Java Puzzlers
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
    }
}
