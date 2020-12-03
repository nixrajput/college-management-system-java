// Java program generate a random AlphaNumeric String 
// using Math.random() method 
package repository;

/**
 *
 * @author nixrajput
 */
public class RandomGenerator {

    public static String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static String getNumericString(int n) {

        String NumericString = "0123456789";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (NumericString.length()
                    * Math.random());

            sb.append(NumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
