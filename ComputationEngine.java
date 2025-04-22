public class ComputationEngine {
    public static String processCalculation(String input1, String input2, String operator) {
        if (!Validator.isValidNumber(input1) || !Validator.isValidNumber(input2)) {
            return "Error: Input harus angka";
        }

        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);

        if (!Validator.isWithinRange(num1) || !Validator.isWithinRange(num2)) {
            return "Error: Nilai di luar jangkauan";
        }

        if (!Validator.isValidOperator(operator)) {
            return "Error: Operator tidak valid";
        }

        if (operator.equals("/") && !Validator.isNonZeroDivisor(num2)) {
            return "Error: Pembagi tidak boleh nol";
        }

        switch (operator) {
            case "+":
                return String.valueOf(CalculatorOperations.tambah(num1, num2));
            case "-":
                return String.valueOf(CalculatorOperations.kurang(num1, num2));
            case "*":
                return String.valueOf(CalculatorOperations.kali(num1, num2));
            case "/":
                return String.valueOf(CalculatorOperations.bagi(num1, num2));
            default:
                return "Error: Operator tidak valid";
        }
    }
}
