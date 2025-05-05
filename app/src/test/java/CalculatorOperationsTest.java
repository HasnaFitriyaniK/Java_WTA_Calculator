import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorOperationsTest {

    @Test
    public void testTambah() {
        double a = 7;
        double b = 9;
        double expected = 16;

        double result = CalculatorOperations.tambah(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testTambahNegativeB() {
        double a = 7;
        double b = -9;
        double expected = -2;

        double result = CalculatorOperations.tambah(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testTambahBothNegative() {
        double a = -7;
        double b = -9;
        double expected = -16;

        double result = CalculatorOperations.tambah(a, b);

        assertEquals(expected, result);
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
    public void testKurangNegativeA() {
        double a = -8;
        double b = 2;
        double expected = -10;

        double result = CalculatorOperations.kurang(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testKurangBothNegative() {
        double a = -8;
        double b = -2;
        double expected = -6;

        double result = CalculatorOperations.kurang(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testKali() {
        double a = 25;
        double b = 4;
        double expected = 100;

        double result = CalculatorOperations.kali(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testKaliNegativeB() {
        double a = 25;
        double b = -4;
        double expected = -100;

        double result = CalculatorOperations.kali(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testKaliBothNegative() {
        double a = -25;
        double b = -4;
        double expected = 100;

        double result = CalculatorOperations.kali(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testBagi() {
        double a = 10;
        double b = 5;
        double expected = 2;

        double result = CalculatorOperations.bagi(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testBagiNegativeA() {
        double a = -10;
        double b = 5;
        double expected = -2;

        double result = CalculatorOperations.bagi(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testBagiBothNegative() {
        double a = -10;
        double b = -5;
        double expected = 2;

        double result = CalculatorOperations.bagi(a, b);

        assertEquals(expected, result);
    }
}
