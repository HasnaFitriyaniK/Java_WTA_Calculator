import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CONTOH TEST UNTUK KELAS CalculatorOperations
class CalculatorOperationsTest {

    @Test
    void testTambah() {
        assertEquals(5, CalculatorOperations.tambah(2, 3));
        assertEquals(-1, CalculatorOperations.tambah(2, -3));
    }

    @Test
    void testKurang() {
        assertEquals(-1, CalculatorOperations.kurang(2, 3));
        assertEquals(5, CalculatorOperations.kurang(2, -3));
    }

    @Test
    void testKali() {
        assertEquals(6, CalculatorOperations.kali(2, 3));
        assertEquals(-6, CalculatorOperations.kali(2, -3));
    }

    @Test
    void testBagi() {
        assertEquals(2, CalculatorOperations.bagi(6, 3));
        assertEquals(-2, CalculatorOperations.bagi(6, -3));
    }

    
}
