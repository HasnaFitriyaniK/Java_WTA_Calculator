public class ComputationEngine {

    public static String processCalculation(String input1, String input2, String operator) {

        input1 = input1.replace(",", ".");
        input2 = input2.replace(",", ".");

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

        // Karena sudah tervalidasi, bisa safely convert
        double num1 = (double) Double.parseDouble(input1);
        double num2 = (double) Double.parseDouble(input2);

        // Validasi operator
        if (!Validator.isValidOperator(operator)) {
            return "Error: Operator tidak valid";
        }

        // Proses operasi
        if (operator.equals("+")) {
            return String.valueOf(CalculatorOperations.tambah(num1, num2));
        } else if (operator.equals("-")) {
            return String.valueOf(CalculatorOperations.kurang(num1, num2));
        } else if (operator.equals("*")) {
            return String.valueOf(CalculatorOperations.kali(num1, num2));
        } else {
            // Validasi pembagi tidak nol jika operator pembagian
            if (operator.equals("/") && !Validator.isNonZeroDivisor(num2)) {
                return "Error: Pembagi tidak boleh nol";
            }
            return String.valueOf(CalculatorOperations.bagi(num1, num2));
        }
    }
}

