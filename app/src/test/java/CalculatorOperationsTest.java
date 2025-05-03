import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorOperationsTest {

    @Test
    public void testTambah() {
        // (1) Setup
        double a = 7;
        double b = 9;
        double expected = 16;

        // (2) Execute
        double result;
        result = CalculatorOperations.tambah(a, b);

        // (3) Verify
        assertEquals(expected, result);

        // assertEquals(16, CalculatorOperations.tambah(7, 9));
        // assertEquals(-2, CalculatorOperations.tambah(7, -9));
    }

    @Test
    public void testKurang() {
        double a = 8;
        double b = 2;

        double expected = 6;
        double result = CalculatorOperations.kurang(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testKali() {
        double a = 2;
        double b = 4;

        double expected = 8;
        double result = CalculatorOperations.kali(a, b);

        assertEquals(expected, result);
        // assertEquals(8, CalculatorOperations.kali(2, 4));
        // assertEquals(-8, CalculatorOperations.kali(2, -4));
    }

    @Test
    public void testBagi() {
        double a = 10;
        double b = 5;

        double expected = 2;
        double result;
        
        result = CalculatorOperations.bagi(a, b);
        assertEquals(expected, result);

        // assertEquals(2, CalculatorOperations.bagi(10, 5));
        // assertEquals(-2, CalculatorOperations.bagi(10, -5));
    }

    @Test
    public void testBagiNegative() {
        double a = 10;
        double b = -5;

        double expected = -2;
        double result;
        
        result = CalculatorOperations.bagi(a, b);
        assertEquals(expected, result);

        // assertEquals(2, CalculatorOperations.bagi(10, 5));
        // assertEquals(-2, CalculatorOperations.bagi(10, -5));
    }
}
