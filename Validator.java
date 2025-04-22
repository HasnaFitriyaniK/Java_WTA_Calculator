public class Validator {

    private static final int MIN_VALUE = -32768;
    private static final int MAX_VALUE = 32767;

    public static String validateNumber(String input) {
        if (!isParsableAsLong(input)) {
            return "Error: Input harus angka";
        }

        long value = Long.parseLong(input);
        if (!isWithinShortRange(value)) {
            return "Error: Input di luar jangkauan";
        }

        return null; // valid
    }

    public static boolean isParsableAsLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isWithinShortRange(long number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

    public static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    public static boolean isNonZeroDivisor(int divisor) {
        return divisor != 0;
    }
}
