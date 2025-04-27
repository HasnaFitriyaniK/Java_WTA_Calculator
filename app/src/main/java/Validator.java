public class Validator {

    private static final int MIN_VALUE = -32768;
    private static final int MAX_VALUE = 32767;

    public static String validateNumber(String input) {
        if (!isParsableAsDouble(input)) {
            return "Error: Input harus angka";
        }

        double value = Double.parseDouble(input);
        if (!isWithinRange(value)) {
            return "Error: Input di luar jangkauan";
        }

        return null; // valid
    }

    public static boolean isParsableAsDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isWithinRange(double number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

    public static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    public static boolean isNonZeroDivisor(double divisor) {
        return divisor != 0.0;
    }
}
