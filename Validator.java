public class Validator {
    public static boolean isValidNumber(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isWithinRange(int number) {
        return (number >= -32768 && number <= 32767);
    }

    public static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    public static boolean isNonZeroDivisor(int divisor) {
        return divisor != 0;
    }
}
