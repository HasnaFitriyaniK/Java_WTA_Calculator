public class ComputationEngine {
    public static String processCalculation(String input1, String input2, String operator) {
        // Validasi input pertama
        String error1 = Validator.validateNumber(input1);
        if (error1 != null) {
            return error1;
        }

        // Validasi input kedua
        String error2 = Validator.validateNumber(input2);
        if (error2 != null) {
            return error2;
        }

        // Karena sudah tervalidasi, kita bisa safely convert
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);

        // Validasi operator
        if (!Validator.isValidOperator(operator)) {
            return "Error: Operator tidak valid";
        }

        // Validasi pembagi tidak nol jika operator pembagian
        if (operator.equals("/") && !Validator.isNonZeroDivisor(num2)) {
            return "Error: Pembagi tidak boleh nol";
        }

        // Proses operasi
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
