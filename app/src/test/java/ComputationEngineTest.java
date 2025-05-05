import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputationEngineTest {

    @Test
    public void testAddition() {
        String input1 = "5";
        String input2 = "3";
        String operator = "+";
        String expected = "8.0";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testSubtraction() {
        String input1 = "5";
        String input2 = "3";
        String operator = "-";
        String expected = "2.0";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testMultiplication() {
        String input1 = "5";
        String input2 = "3";
        String operator = "*";
        String expected = "15.0";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testDivision() {
        String input1 = "6";
        String input2 = "3";
        String operator = "/";
        String expected = "2.0";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testDivisionByZero() {
        String input1 = "5";
        String input2 = "0";
        String operator = "/";
        String expected = "Error: Pembagi tidak boleh nol";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testInvalidOperator() {
        String input1 = "5";
        String input2 = "3";
        String operator = "%";
        String expected = "Error: Operator tidak valid";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testInvalidNumberInput1() {
        String input1 = "abc";
        String input2 = "3";
        String operator = "+";
        String expected = "Error: Input harus angka";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testInvalidNumberInput2() {
        String input1 = "5";
        String input2 = "32768";
        String operator = "+";
        String expected = "Error: Input di luar jangkauan";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual); 
    }

    @Test
    public void testInputWithSpaces() {
        String input1 = " 5 ";
        String input2 = " 5 ";
        String operator = "+";
        String expected = "Error: Input harus angka";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }

    @Test
    public void testOperatorWithSpaces() {
        String input1 = "5";
        String input2 = "5";
        String operator = " + ";
        String expected = "Error: Operator tidak valid";  

        String actual = ComputationEngine.processCalculation(input1, input2, operator);

        assertEquals(expected, actual);  
    }
}
