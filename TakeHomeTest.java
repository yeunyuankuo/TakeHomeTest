import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TakeHomeTest {
    /**
     * Takes in an string and converts it into an integer without using built-in parse functions.
     * Ex: "-123" to 123, "+999" to 999, "656" to 656
     *
     * @param str the input string
     * @return the int value of the input string.
     * @throws NumberFormatException when non-integer strings are given
     **/
    private static int stringToInteger(String str) {
        if (str.length() == 0 || str == null) throw new NumberFormatException();
        int sum = 0;
        boolean negative = false;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(0) == '-' || str.charAt(0) == '+') && str.length() > 1) {
                if (str.charAt(0) == '-') negative = true;
                i++;
            }
            char currChar = str.charAt(i);
            int digit = currChar - '0';
            if (digit >= 0 && digit <= 9) {
                sum = sum * 10 + digit;
            } else {
                throw new NumberFormatException();
            }
        }
        return negative ? sum * -1 : sum;
    }

    /**
     * Takes a string input and detects whether there's integer in there.
     *
     * @param str the string input
     * @return TRUE if there is integer contained; returns FALSE otherwise.
     */
    private static boolean containsNumber(String str) {
        if (str.length() == 0 || str == null) return false;
        Character[] integers = {'0','1','2','3','4','5','6','7','8','9'};
        Set<Character> integerStr = new HashSet<>(Arrays.asList(integers));
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (integerStr.contains(currChar)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            System.out.println(stringToInteger("123") == 123);
            System.out.println(stringToInteger("111") == 222);
            System.out.println(stringToInteger("+123") == 123);
            System.out.println(stringToInteger("-123") == -123);
            System.out.println(stringToInteger("abc"));
//            System.out.println(stringToInteger("-"));
        } catch (NumberFormatException e) {
            System.out.println("Error: Given string isn't valid to convert into integer!");
        }
        System.out.println(containsNumber("123"));
        System.out.println(containsNumber("-123"));
        System.out.println(containsNumber("This Is A Test4me"));
        System.out.println(containsNumber("IAMGOOD"));
    }
}
